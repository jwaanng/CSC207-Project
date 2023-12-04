package app;

import browsePage.BrowsePageView;
import browsePage.BrowsePageViewModel;
import browsePage.browsePageRedirect.BrowsePageRDRController;
import browsePage.swipe.PetProfilePresenter;
import browsePage.swipe.ProfileQueueChainer;
import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;
import dataAccessObject.UserDataAccessInterface;
import favPetPage.FavPetPageViewModel;
import favPetPage.addAFavPet.AddController;
import favPetPage.addAFavPet.AddPresenter;
import favPetPage.addAFavPet.AddUCI;
import favPetPage.browsePet.BrowseController;
import favPetPage.browsePet.BrowsePresenter;
import favPetPage.browsePet.BrowseUCI;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myProfilePage.myProfileRedirect.MyProfileRDRController;
import viewModel.ViewModelManager;

public class BrowsePetPageFactory {
    static public <SwipePageView> BrowsePageView createBrowsePage(
            BrowsePageViewModel browsePageViewModel, FavPetPageViewModel favPetPageViewModel,
            UserDataAccessInterface userDataAccessInterface,
            PetProfileDataAccessInterface petProfileDataAccessInterface,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface,
            FavPetRDRController favPetRDRController,
            MyPetRDRController myPetRDRController,
            MyProfileRDRController myProfileRDRController
    ) {


        PetProfilePresenter presenter = new PetProfilePresenter(profilePictureDataAccessInterface);
        AddPresenter addPresenter = new AddPresenter(favPetPageViewModel.getAddViewModel());
        AddUCI addUCI = new AddUCI(
                addPresenter,
                userDataAccessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface);
        AddController addController = new AddController(addUCI);
        return new BrowsePageView(
                browsePageViewModel,
                presenter,
                addController,
                favPetRDRController,
                myPetRDRController,
                myProfileRDRController);
    }
}