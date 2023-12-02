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

/**
 * The {@code LGUCI} class represents the use case interactor for the login feature, responsible for
 * executing login-related operations and interacting with data access interfaces.
 */
public class LGUCI implements LGIB {

    private final LGOB presenter;

    private final UserDataAcessInterface dao;

    private final PetProfileDataAccessInterface daoP;

    private final ProfilePictureDataAccessInterface daoPic;

    /**
     * Constructs an {@code LGUCI} instance with the specified presenter and data access interfaces.
     *
     * @param presenter                    The presenter associated with the login use case.
     * @param userDataAccessInterface      The data access interface for user-related data.
     * @param petProfileDataAccessInterface The data access interface for pet profile-related data.
     * @param profilePictureDataAccessInterface The data access interface for profile picture-related data.
     */
    public LGUCI(LGOB presenter, UserDataAcessInterface userDataAccessInterface,
                 PetProfileDataAccessInterface petProfileDataAccessInterface,
                 ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {
        this.presenter = presenter;
        this.dao = userDataAccessInterface;
        this.daoP = petProfileDataAccessInterface;
        this.daoPic = profilePictureDataAccessInterface;
    }

    /**
     * Executes the login use case with the provided login data.
     *
     * @param loginData The input data for the login use case.
     */
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