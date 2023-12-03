package app;

import browsePage.BrowsePageViewModel;
import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;
import dataAccessObject.UserDataAccessInterface;
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

/**
 * This is a utility class for generating the signup page
 */
public class FavPetPageFactory {
    /**
     * Factory method to create an instance of {@link FavPetPageView}.
     * <p>
     * This method initializes and configures the necessary components for the Favorite Pet Page,
     * such as controllers and presenters for handling actions like deleting a favorite pet,
     * viewing a pet's profile, and redirecting to the My Favorite Pet Page. It also sets up the
     * BrowsePet cycle for browsing pets.
     *
     * @param manager                           The {@link ViewModelManager} responsible for managing view models.
     * @param favPetPageViewModel               The {@link FavPetPageViewModel} associated with the Favorite Pet Page.
     * @param userDataAccessInterface           A data access object implementing  {@link UserDataAccessInterface}
     *                                          for accessing user data.
     * @param petProfileDataAccessInterface     A data access object implementing  {@link PetProfileDataAccessInterface}
     *                                          for accessing pet profile data.
     * @param profilePictureDataAccessInterface A data access object implementing  {@link ProfilePictureDataAccessInterface}
     *                                          for accessing profile picture data for both user and pet profiles
     * @return An instance of {@link FavPetPageView} configured with the necessary components.
     */
    static public FavPetPageView createFavPetPage(
            ViewModelManager manager, FavPetPageViewModel favPetPageViewModel,
            UserDataAccessInterface userDataAccessInterface,
            PetProfileDataAccessInterface petProfileDataAccessInterface,
            ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {

        //delete fav pet cycle
        DeletePresenter deletePresenter = new DeletePresenter(favPetPageViewModel.getDeleteFavPetViewModel());
        DeleteIB dfpUci = new DeleteUCI(deletePresenter, userDataAccessInterface);
        DeleteController deleteController = new DeleteController(dfpUci);

        //view this pet cycle
        ViewThisPresenter viewThisPresenter = new ViewThisPresenter(favPetPageViewModel.getViewThisViewModel());
        ViewThisIB vtUci = new ViewThisUCI(viewThisPresenter, userDataAccessInterface, petProfileDataAccessInterface,
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
