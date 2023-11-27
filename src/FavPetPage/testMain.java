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

import FavPetPage.Redirect.RDController;
import FavPetPage.Redirect.RDIB;
import FavPetPage.Redirect.RDPresenter;
import FavPetPage.Redirect.RDUCI;
import FavPetPage.ViewThisPetProfile.VTPIB;
import FavPetPage.ViewThisPetProfile.VTPPresenter;
import FavPetPage.ViewThisPetProfile.VTPController;
import FavPetPage.ViewThisPetProfile.VTPUCI;
import View.ViewManager;
import ViewModel.ViewModelManager;

import javax.swing.*;

public class testMain {
    public static void main(String[] args) {
        ViewModelManager manager = new ViewModelManager();
        MyFavPetPageViewModel viewModel = new MyFavPetPageViewModel();
        UserDataAcessInterface dao = new CommonUserDataAccessObject();
        PetProfileDataAccessObject daop = new PetProfileDataAccessObject();

        //delete fav pet cycle
        DFPPresenter dfpPresenter = new DFPPresenter(viewModel);
        DFPIB dfpUci = new DFPUCI(dao, dfpPresenter);
        DFPController dfpController = new DFPController(dfpUci);

        //view this pet cycle
        VTPPresenter vtpPresenter = new VTPPresenter();
        VTPIB vtpuci = new VTPUCI(daop, vtpPresenter);
        VTPController vtpController = new VTPController(vtpuci);

        //redirect cycle
        RDPresenter rdPresenter = new RDPresenter(viewModel.getPageRedirectViewModel(), manager);
        RDUCI rduci = new RDUCI(rdPresenter);
        RDController rdController = new RDController(rduci);

        //BrowsePet cycle
        BPPresenter bpPresenter = new BPPresenter(new BrowsePageViewModel(), manager);
        BPUCI bpuci = new BPUCI(bpPresenter);
        BPController bpController = new BPController(bpuci);

        MyFavPetPageView view = new MyFavPetPageView(viewModel, dfpController, vtpController, rdController, bpController);

        JFrame app = new JFrame();
        app.add(view);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,500);
    }
}
