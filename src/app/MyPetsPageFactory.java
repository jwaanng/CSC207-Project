package app;

import browsePage.browsePageRedirect.BrowsePageRDRController;
import dataAccessObject.*;
import entity.petProfile.PetProfileBuilderFactory;
import favPetPage.FavPetPageViewModel;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.InnerViewModelManager;
import myPets.MyPetsView;
import myPets.MyPetsViewModel;
import myPets.createNewDog.CreateController;
import myPets.createNewDog.CreatePresenter;
import myPets.createNewDog.CreateUCI;
import myPets.createRedirect.CreateRedirectController;
import myPets.createRedirect.CreateRedirectPresenter;
import myPets.createRedirect.CreateRedirectUCI;
import myPets.createRedirect.CreateRedirectViewModel;
import myPets.deleteMyPet.DeleteMyPetController;
import myPets.deleteMyPet.DeleteMyPetIB;
import myPets.deleteMyPet.DeleteMyPetPresenter;
import myPets.deleteMyPet.DeleteMyPetUCI;
import myPets.myPetDisplayRedirect.MyPetRedirectController;
import myPets.myPetDisplayRedirect.MyPetRedirectPresenter;
import myPets.myPetDisplayRedirect.MyPetRedirectUCI;
import myPets.myPetDisplayRedirect.MyPetRedirectViewModel;
import myPets.myPetPageRedirect.MyPetRDRController;
import myProfilePage.myProfileRedirect.MyProfileRDRController;
import viewModel.ViewModelManager;

public class MyPetsPageFactory {
    public static MyPetsView createMyPetsPage(
            MyPetsViewModel myPetsViewModel,
            UserDataAccessInterface userDataAccessInterface,
            PetProfileDataAccessInterface petProfileDataAccessInterface,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface,
            BrowsePageRDRController browsePageRDRController,
            FavPetRDRController favPetRDRController,
            MyProfileRDRController myProfileRDRController
    ) {

        InnerViewModelManager innerViewManagerModel = new InnerViewModelManager();
        PetProfileBuilderFactory petProfileBuilderFactory = new PetProfileBuilderFactory();
        //delete fav pet cycle
        DeleteMyPetPresenter deletePresenter = new DeleteMyPetPresenter(
                myPetsViewModel.getDeleteMyPetViewModel()
        );
        DeleteMyPetIB deleteUCI = new DeleteMyPetUCI(
                petProfileDataAccessInterface,
                deletePresenter
        );
        DeleteMyPetController deleteController = new DeleteMyPetController(deleteUCI);

     
        //MyPetsRedirect Cycle
        MyPetRedirectPresenter myPetRedirectPresenter = new MyPetRedirectPresenter(
                myPetsViewModel.getMyPetRedirectViewModel());
        MyPetRedirectUCI myPetRedirectUCI = new MyPetRedirectUCI(myPetRedirectPresenter);
        MyPetRedirectController myPetRedirectController = new MyPetRedirectController(myPetRedirectUCI);

        //Create cycle
        CreatePresenter createPresenter = new CreatePresenter(
                innerViewManagerModel,
                myPetsViewModel,
                myPetsViewModel.getCreateViewModel());
        CreateUCI createUCI = new CreateUCI(
                createPresenter,
                petProfileBuilderFactory, userDataAccessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface
        );
        CreateController createController = new CreateController(createUCI);

        //Create Redirect Cycle
        CreateRedirectPresenter createRedirectPresenter = new CreateRedirectPresenter(
                myPetsViewModel.getCreateRedirectViewModel()
        );
        CreateRedirectUCI createRedirectUCI = new CreateRedirectUCI(createRedirectPresenter);
        CreateRedirectController createRedirectController = new CreateRedirectController(createRedirectUCI);

        return new MyPetsView(
                innerViewManagerModel,
                myPetsViewModel,
                deleteController,
                myPetsViewModel.getCreateRedirectViewModel(),
                createController,
                createRedirectController,
                myPetsViewModel.getMyPetRedirectViewModel(),
                myPetRedirectController,
                browsePageRDRController,
                favPetRDRController,
                myProfileRDRController
        );
    }
}
