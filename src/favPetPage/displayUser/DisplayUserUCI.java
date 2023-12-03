package favPetPage.displayUser;

import dataAccessObject.ProfilePictureDataAccessInterface;

import java.awt.Image;

/**
 * A concrete implementation of {@link DisplayUserIB}
 * <p>
 * An implementation of a displayUser usecase interactor that displays a user's name and profile picture
 */
public class DisplayUserUCI implements DisplayUserIB {
    private final DisplayUserOB presenter;
    private final ProfilePictureDataAccessInterface daoPic;

    /**
     * Construct a new usecase interactor
     *
     * @param displayUserOutputBoundary         a presenter for the diplayUser usecase that is called by the
     *                                          interactor to finish usecase
     * @param profilePictureDataAccessInterface a data access object that can interact with the database that stores
     *                                          all profile photos of user and pet profiles
     */
    public DisplayUserUCI(
            DisplayUserOB displayUserOutputBoundary,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {

        this.presenter = displayUserOutputBoundary;
        this.daoPic = profilePictureDataAccessInterface;
    }

    /**
     * Display the user's username and profile picture
     *
     * @param username the username of the user
     */
    @Override
    public void execute(String username) {
        Image profile = daoPic.retrieveUserProfile(username);
        if (!(profile == null)) {
            DisplayUserOPData outputData = new DisplayUserOPData();
            outputData.username = username;
            outputData.photo = profile;
            presenter.prepareSuccessView(outputData);

        }
    }


}
