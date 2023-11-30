package favPetPage;

import browsePage.BrowsePageViewModel;
import dataAcessObject.CommonUserDataAccessObject;
import dataAcessObject.PetProfileDataAccessObject;
import dataAcessObject.UserDataAcessInterface;
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
import favPetPage.viewThisPetProfile.ViewThisIB;
import favPetPage.viewThisPetProfile.ViewThisPresenter;
import favPetPage.viewThisPetProfile.ViewThisController;
import favPetPage.viewThisPetProfile.ViewThisUCI;
import viewModel.ViewModelManager;

import javax.swing.*;

public class testMain {
    public static void main(String[] args) {
        ViewModelManager manager = new ViewModelManager();
        FavPetPageViewModel viewModel = new FavPetPageViewModel();
        UserDataAcessInterface dao = new CommonUserDataAccessObject();
        PetProfileDataAccessObject daop = new PetProfileDataAccessObject();

        //delete fav pet cycle
        DeletePresenter deletePresenter = new DeletePresenter(viewModel);
        DeleteIB dfpUci = new DeleteUCI(dao, deletePresenter);
        DeleteController deleteController = new DeleteController(dfpUci);

        //view this pet cycle
        ViewThisPresenter viewThisPresenter = new ViewThisPresenter();
        ViewThisIB vtpuci = new ViewThisUCI(daop, viewThisPresenter);
        ViewThisController viewThisController = new ViewThisController(vtpuci);

        //redirect cycle
        FavPetRDRPresenter FavPetRDRPresenter = new FavPetRDRPresenter( viewModel, manager);
        FavPetRDRUCI FavPetRDRUCI = new FavPetRDRUCI(FavPetRDRPresenter);
        FavPetRDRController favPetRDRController = new FavPetRDRController(FavPetRDRUCI);

        //BrowsePet cycle
        BrowsePresenter browsePresenter = new BrowsePresenter(new BrowsePageViewModel(), manager);
        BrowseUCI browseUCI = new BrowseUCI(browsePresenter);
        BrowseController browseController = new BrowseController(browseUCI);
        FavPetPageView view = new FavPetPageView(viewModel, deleteController, viewThisController, favPetRDRController, browseController);

        JFrame app = new JFrame();
        app.add(view);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,500);
    }
}
