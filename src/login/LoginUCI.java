package login;

import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;
import dataAccessObject.UserDataAccessInterface;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * The {@code LoginUCI} class represents the use case interactor for the login feature, responsible for
 * executing login-related operations and interacting with data access interfaces.
 * <p>
 * An implementation of {@link  LoginIB}
 */
public class LoginUCI implements LoginIB {
    private final LoginOB presenter;


    private final UserDataAccessInterface dao;

    private final PetProfileDataAccessInterface daoP;

    private final ProfilePictureDataAccessInterface daoPic;


    /**
     * Constructs an {@code LoginUCI} instance with the specified presenter and data access interfaces.
     *
     * @param presenter                         The presenter implementing {@link LoginOB} associated with the
     *                                          login use case.
     * @param userDataAccessInterface           The data access object implementing {@link UserDataAccessInterface}
     *                                          for user-related data.
     * @param petProfileDataAccessInterface     The data access object implementing  {@link PetProfileDataAccessInterface}
     *                                          for pet profile-related data.
     * @param profilePictureDataAccessInterface The data access object implementing  {@link ProfilePictureDataAccessInterface}
     *                                          for profile picture-related data.
     */

    public LoginUCI(LoginOB presenter, UserDataAccessInterface userDataAccessInterface,
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
        LoginOPData data = new LoginOPData();
        if (!dao.exist(name)) {
            data.error = "Username does not exist";
            presenter.prepareFailView(data);
        } else {
            AppUser currUser = dao.retrieve(name);
            if (!currUser.getPassword().equals(pw)) {
                data.error = "Password does not match";
                presenter.prepareFailView(data);
            } else {
                try {
                    Image profile = daoPic.retrieveUserProfile(name);
                    if (profile == null) {
                        profile = ImageIO.read(getClass().getResource("/defaultprofile.png"));
                    }
                    data.username = name;
                    data.address = currUser.getAddress();
                    data.preferredSize = currUser.getPreferredSize();
                    data.preferredSex = currUser.getPreferredSex();
                    data.profile = profile;
                    data.bio = currUser.getBio();
                    for (int petId : currUser.getFavPet()) {
                        PetProfile petProfile = daoP.getProfile(petId);
                        data.addPetNameAndPHOTO(
                                petProfile.getId(),
                                petProfile.getName(), daoPic.retrievePetProfile(petId));
                    }

                    presenter.prepareSuccessView(data);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}