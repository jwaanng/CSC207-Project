package favPetPage;

import browsePage.BrowsePageViewModel;
import dataAcessObject.CommonUserDataAccessObject;
import dataAcessObject.PetProfileDataAccessObject;
import dataAcessObject.UserDataAcessInterface;
import favPetPage.browsePet.BPController;
import favPetPage.browsePet.BPPresenter;
import favPetPage.browsePet.BPUCI;
import favPetPage.deleteAFavPet.DFPController;
import favPetPage.deleteAFavPet.DFPIB;
import favPetPage.deleteAFavPet.DFPPresenter;
import favPetPage.deleteAFavPet.DFPUCI;

import favPetPage.redirect.RDController;
import favPetPage.redirect.RDPresenter;
import favPetPage.redirect.RDUCI;
import favPetPage.viewThisPetProfile.VTPIB;
import favPetPage.viewThisPetProfile.VTPPresenter;
import favPetPage.viewThisPetProfile.VTPController;
import favPetPage.viewThisPetProfile.VTPUCI;
import viewModel.ViewModelManager;

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
