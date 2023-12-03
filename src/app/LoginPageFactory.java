package app;

import configProfile.ConfigProfileViewModel;
import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.ProfilePictureDataAccessInterface;
import dataAcessObject.UserDataAcessInterface;
import favPetPage.FavPetPageViewModel;
import login.*;
import viewModel.ViewModelManager;

public class LoginPageFactory {
    public static LoginView createLoginPage(
            ViewModelManager manager,
            LoginViewModel loginViewModel,
            FavPetPageViewModel favPetPageViewModel,
            UserDataAcessInterface userDataAcessInterface,
            PetProfileDataAccessInterface petProfileDataAccessInterface,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface
    ) {
        LoginPresenter loginPresenter = new LoginPresenter(loginViewModel,
                favPetPageViewModel, manager, new ConfigProfileViewModel());
        LoginUCI loginUCI = new LoginUCI(loginPresenter, userDataAcessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface);
        LoginController loginController = new LoginController(loginUCI);
        return new LoginView(loginViewModel, loginController);
    }
}
