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
    /**
     * Factory method to create an instance of {@link FavPetPageView}.
     *
     * This method initializes and configures the necessary components for the Favorite Pet Page,
     * such as controllers and presenters for handling actions like deleting a favorite pet,
     * viewing a pet's profile, and redirecting to the My Favorite Pet Page. It also sets up the
     * BrowsePet cycle for browsing pets.
     *
     * @param manager                    The {@link ViewModelManager} responsible for managing view models.
     * @param favPetPageViewModel        The {@link FavPetPageViewModel} associated with the Favorite Pet Page.
     * @param userDataAcessInterface     The {@link UserDataAcessInterface} for accessing user data.
     * @param petProfileDataAccessInterface The {@link PetProfileDataAccessInterface} for accessing pet profile data.
     * @return                           An instance of {@link FavPetPageView} configured with the necessary components.

     */
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
