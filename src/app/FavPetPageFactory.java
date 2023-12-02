package app;

import browsePage.BrowsePageViewModel;
import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.ProfilePictureDataAccessInterface;
import dataAcessObject.UserDataAcessInterface;
import favPetPage.FavPetPageView;
import favPetPage.FavPetPageViewModel;
import favPetPage.browsePet.BrowseController;
import favPetPage.browsePet.BrowsePresenter;
import favPetPage.browsePet.BrowseUCI;
import favPetPage.deleteAFavPet.DeleteController;
import favPetPage.deleteAFavPet.DeleteIB;
import favPetPage.deleteAFavPet.DeletePresenter;
import favPetPage.deleteAFavPet.DeleteUCI;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import favPetPage.myFavPetPageRedirect.FavPetRDRPresenter;
import favPetPage.myFavPetPageRedirect.FavPetRDRUCI;
import favPetPage.viewThisPetProfile.ViewThisController;
import favPetPage.viewThisPetProfile.ViewThisIB;
import favPetPage.viewThisPetProfile.ViewThisPresenter;
import favPetPage.viewThisPetProfile.ViewThisUCI;
import viewModel.ViewModelManager;

public class FavPetPageFactory {
    static public FavPetPageView createFavPetPage(
            ViewModelManager manager, FavPetPageViewModel favPetPageViewModel,
            UserDataAcessInterface userDataAcessInterface,
            PetProfileDataAccessInterface petProfileDataAccessInterface,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface){

        //delete fav pet cycle
        DeletePresenter deletePresenter = new DeletePresenter(favPetPageViewModel.getDeleteFavPetViewModel());
        DeleteIB dfpUci = new DeleteUCI(deletePresenter,userDataAcessInterface);
        DeleteController deleteController = new DeleteController(dfpUci);

        //view this pet cycle
        ViewThisPresenter viewThisPresenter = new ViewThisPresenter(favPetPageViewModel.getViewThisViewModel());
        ViewThisIB vtUci = new ViewThisUCI(viewThisPresenter, userDataAcessInterface, petProfileDataAccessInterface,
                profilePictureDataAccessInterface);
        ViewThisController viewThisController = new ViewThisController(vtUci);

        //TODO copy this code when needed redirect int my fav pet page cycle
        FavPetRDRPresenter FavPetRDRPresenter = new FavPetRDRPresenter(favPetPageViewModel, manager);
        FavPetRDRUCI FavPetRDRUCI = new FavPetRDRUCI(FavPetRDRPresenter);
        FavPetRDRController favPetRDRController = new FavPetRDRController(FavPetRDRUCI);

        //BrowsePet cycle
        BrowsePresenter browsePresenter = new BrowsePresenter(new BrowsePageViewModel(), manager);
        BrowseUCI browseUCI = new BrowseUCI(browsePresenter);
        BrowseController browseController = new BrowseController(browseUCI);

        return new FavPetPageView(
                favPetPageViewModel,
                deleteController,
                viewThisController,
                browseController);
    }
}
