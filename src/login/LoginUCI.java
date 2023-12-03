package login;

import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.ProfilePictureDataAccessInterface;
import dataAcessObject.UserDataAcessInterface;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
/**
 * The {@code LoginUCI} class represents the use case interactor for the login feature, responsible for
 * executing login-related operations and interacting with data access interfaces.
 */
public class LoginUCI implements LoginIB {
    private final LoginOB presenter;



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

    public LoginUCI(LoginOB presenter, UserDataAcessInterface userDataAccessInterface,
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