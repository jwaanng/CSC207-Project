package login;

import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.PetProfileDataAccessObject;
import dataAcessObject.ProfilePictureDataAccessInterface;
import dataAcessObject.UserDataAcessInterface;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LGUCI implements LGIB{
    private final LGOB presenter;
    private final UserDataAcessInterface dao;

    private final PetProfileDataAccessInterface daoP;

    private final ProfilePictureDataAccessInterface daoPic;
    public LGUCI(LGOB presenter, UserDataAcessInterface userDataAcessInterface,
                 PetProfileDataAccessInterface petProfileDataAccessInterface,
                 ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {
        this.presenter = presenter;
        this.dao = userDataAcessInterface;
        this.daoP = petProfileDataAccessInterface;
        this.daoPic = profilePictureDataAccessInterface;
    }

    @Override
    public void execute(LGIPData loginData) {
        String name = loginData.getUsername();
        String pw = loginData.getPassword();

        if (!dao.exist(name)) {
            presenter.prepareFailView(LGOPData.createFailData("Username does not exist"));
        } else {
            AppUser currUser = dao.retrieve(name);
            if (!currUser.getPassword().equals(pw)) {
                presenter.prepareFailView(LGOPData.createFailData("Password does not match"));
            } else {
                try {
                    //TODO. cjage
                    Image profile = daoPic.retrieveUserProfile(name);
                    if (profile == null) {
                        profile = ImageIO.read(getClass().getResource("/defaultprofile.png"));
                    }
                    LGOPData successData = LGOPData.createSuccessData(name, profile);
                    for (int petId : currUser.getFavPet()) {
                        PetProfile petProfile = daoP.getProfile(petId);
                        successData.addPetNameAndPHOTO(
                                petProfile.getId(),
                                petProfile.getName(), daoPic.retrievePetProfile(petId));
                    }
                    presenter.prepareSuccessView(successData);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
