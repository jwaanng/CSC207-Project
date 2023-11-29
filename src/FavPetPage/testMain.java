package FavPetPage;

import BrowsePage.BrowsePageViewModel;
import DataAcessObject.CommonUserDataAccessObject;
import DataAcessObject.PetProfileDataAccessObject;
import DataAcessObject.UserDataAcessInterface;
import FavPetPage.BrowsePet.BPController;
import FavPetPage.BrowsePet.BPPresenter;
import FavPetPage.BrowsePet.BPUCI;
import FavPetPage.DeleteAFavPet.DFPController;
import FavPetPage.DeleteAFavPet.DFPIB;
import FavPetPage.DeleteAFavPet.DFPPresenter;
import FavPetPage.DeleteAFavPet.DFPUCI;

import FavPetPage.myFavPetPageRedirect.FavPetRDRController;
import FavPetPage.myFavPetPageRedirect.FavPetRDRPresenter;
import FavPetPage.myFavPetPageRedirect.FavPetRDRUCI;
import FavPetPage.ViewThisPetProfile.ViewThisIB;
import FavPetPage.ViewThisPetProfile.ViewThisPresenter;
import FavPetPage.ViewThisPetProfile.ViewThisController;
import FavPetPage.ViewThisPetProfile.ViewThisUCI;
import ViewModel.ViewModelManager;

import javax.swing.*;

public class testMain {
    public static void main(String[] args) {
        ViewModelManager manager = new ViewModelManager();
        FavPetPageViewModel viewModel = new FavPetPageViewModel();
        UserDataAcessInterface dao = new CommonUserDataAccessObject();
        PetProfileDataAccessObject daop = new PetProfileDataAccessObject();

        //delete fav pet cycle
        DFPPresenter dfpPresenter = new DFPPresenter(viewModel);
        DFPIB dfpUci = new DFPUCI(dao, dfpPresenter);
        DFPController dfpController = new DFPController(dfpUci);

        //view this pet cycle
        ViewThisPresenter viewThisPresenter = new ViewThisPresenter();
        ViewThisIB vtpuci = new ViewThisUCI(daop, viewThisPresenter);
        ViewThisController viewThisController = new ViewThisController(vtpuci);

        //redirect cycle
        FavPetRDRPresenter FavPetRDRPresenter = new FavPetRDRPresenter( viewModel, manager);
        FavPetRDRUCI FavPetRDRUCI = new FavPetRDRUCI(FavPetRDRPresenter);
        FavPetRDRController favPetRDRController = new FavPetRDRController(FavPetRDRUCI);

        //BrowsePet cycle
        BPPresenter bpPresenter = new BPPresenter(new BrowsePageViewModel(), manager);
        BPUCI bpuci = new BPUCI(bpPresenter);
        BPController bpController = new BPController(bpuci);

        FavPetPageView view = new FavPetPageView(viewModel, dfpController, viewThisController, favPetRDRController, bpController);

        JFrame app = new JFrame();
        app.add(view);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,500);
    }
}
