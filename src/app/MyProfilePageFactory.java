package app;

import dataAccessObject.*;
import favPetPage.FavPetPageViewModel;
import favPetPage.displayUser.DisplayUserController;
import favPetPage.displayUser.DisplayUserPresenter;
import favPetPage.displayUser.DisplayUserUCI;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myProfilePage.MyProfileView;
import myProfilePage.MyProfileViewModel;
import myProfilePage.changeProfile.ChangeProfileController;
import myProfilePage.changeProfile.ChangeProfilePresenter;
import myProfilePage.changeProfile.ChangeProfileUCI;
import myProfilePage.configProfile.ConfigProfileController;
import myProfilePage.configProfile.ConfigProfilePresenter;
import myProfilePage.configProfile.ConfigProfileUCI;



public class MyProfilePageFactory {

    static public MyProfileView createMyProfilePage(
            MyProfileViewModel myProfileViewModel, FavPetPageViewModel favPetPageViewModel,
            UserDataAccessInterface userDataAccessInterface,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface,
            FavPetRDRController favPetRDRController){
        DisplayUserPresenter displayUserPresenter = new DisplayUserPresenter(favPetPageViewModel.getDisplayUserModel());
        DisplayUserUCI displayUserUCI = new DisplayUserUCI(displayUserPresenter, profilePictureDataAccessInterface);
        DisplayUserController displayUserController = new DisplayUserController(displayUserUCI);
    ConfigProfilePresenter configProfilePresenter = new ConfigProfilePresenter(
            myProfileViewModel.getConfigProfileViewModel()
    );
    ConfigProfileUCI configProfileUCI = new ConfigProfileUCI(
            userDataAccessInterface, configProfilePresenter
    );
    ConfigProfileController configProfileController = new ConfigProfileController(configProfileUCI);
    ChangeProfilePresenter changeProfilePresenter = new ChangeProfilePresenter(
            myProfileViewModel.getChangeProfileViewModel()
    );
    ChangeProfileUCI changeProfileUCI = new ChangeProfileUCI(
            profilePictureDataAccessInterface,
            changeProfilePresenter,displayUserController
    );
    ChangeProfileController changeProfileController = new ChangeProfileController(changeProfileUCI);
        return new MyProfileView(
           myProfileViewModel, configProfileController,
            changeProfileController,favPetRDRController);
    }
}
