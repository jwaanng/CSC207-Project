package app;

import myProfilePage.MyProfileViewModel;
import myProfilePage.configProfile.ConfigProfileViewModel;
import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;
import dataAccessObject.UserDataAccessInterface;
import favPetPage.FavPetPageViewModel;
import login.*;
import viewModel.ViewModelManager;

/**
 * This is a utility class for generating the login page
 */
public class LoginPageFactory {
    /**
     * Factory method to create an instance of {@link LoginView}.
     * <p>
     * This method initializes and configures the necessary components for the login page,
     * such as controllers and presenters for handling user login
     *
     * @param manager                           The {@link ViewModelManager} responsible for managing view models.
     * @param loginViewModel                    The {@link LoginViewModel} associate with the login page
     * @param favPetPageViewModel               The {@link FavPetPageViewModel} associated with the Favorite Pet Page.
     * @param userDataAccessInterface           A data access object implementing {@link UserDataAccessInterface}
     *                                          for accessing user data.
     * @param petProfileDataAccessInterface     A data access object implementing {@link PetProfileDataAccessInterface}
     *                                          for accessing pet profile data.
     * @param profilePictureDataAccessInterface A data access object implementing  {@link PetProfileDataAccessInterface}
     *                                          for accessing profile picture data for both user and pet profiles
     * @return An instance of {@link LoginView} configured with the necessary components.
     */
    public static LoginView createLoginPage(
            ViewModelManager manager,
            LoginViewModel loginViewModel,
            FavPetPageViewModel favPetPageViewModel,
            MyProfileViewModel myProfileViewModel,
            UserDataAccessInterface userDataAccessInterface,
            PetProfileDataAccessInterface petProfileDataAccessInterface,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface
    ) {
        LoginPresenter loginPresenter = new LoginPresenter( manager,loginViewModel,
                favPetPageViewModel, myProfileViewModel);
        LoginUCI loginUCI = new LoginUCI(loginPresenter, userDataAccessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface);
        LoginController loginController = new LoginController(loginUCI);
        return new LoginView(loginViewModel, loginController);
    }
}
