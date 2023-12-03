package login;

import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.ProfilePictureDataAccessInterface;
import dataAcessObject.UserDataAcessInterface;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class LoginUCI implements LoginIB {
    private final LoginOB presenter;
    private final UserDataAcessInterface dao;

    private final PetProfileDataAccessInterface daoP;

    private final ProfilePictureDataAccessInterface daoPic;
    public LoginUCI(LoginOB presenter, UserDataAcessInterface userDataAcessInterface,
                    PetProfileDataAccessInterface petProfileDataAccessInterface,
                    ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {
        this.presenter = presenter;
        this.dao = userDataAcessInterface;
        this.daoP = petProfileDataAccessInterface;
        this.daoPic = profilePictureDataAccessInterface;
    }

    @Override
    public void execute(LoginIPData loginData) {
        String name = loginData.getUsername();
        String pw = loginData.getPassword();

        if (!dao.exist(name)) {
            presenter.prepareFailView(LoginOPData.createFailData("Username does not exist"));
        } else {
            AppUser currUser = dao.retrieve(name);
            if (!currUser.getPassword().equals(pw)) {
                presenter.prepareFailView(LoginOPData.createFailData("Password does not match"));
            } else {
                try {
                    //TODO. cjage
                    Image profile = daoPic.retrieveUserProfile(name);
                    if (profile == null) {
                        profile = ImageIO.read(getClass().getResource("/defaultprofile.png"));
                    }
                    System.out.println("userprofile is" + (profile == null) );
                    System.out.println(name);
                    LoginOPData successData = LoginOPData.createSuccessData(name, profile);
                    for (int petId : currUser.getFavPet()) {
                        PetProfile petProfile = daoP.getProfile(petId);
                        successData.addPetNameAndPHOTO(
                                petProfile.getId(),
                                petProfile.getName(), daoPic.retrievePetProfile(petId));
                        System.out.println("profile is null" + (daoPic.retrievePetProfile(petId) == null));
                    }

                    presenter.prepareSuccessView(successData);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
