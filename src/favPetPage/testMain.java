package favPetPage;

import app.FavPetPageFactory;
import dataAcessObject.*;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

import favPetPage.displayUser.DisplayUserController;
import favPetPage.displayUser.DisplayUserPresenter;
import favPetPage.displayUser.DisplayUserUCI;
import favPetPage.viewThisPetProfile.ViewThisController;
import favPetPage.viewThisPetProfile.ViewThisPresenter;
import favPetPage.viewThisPetProfile.ViewThisUCI;
import viewModel.ViewModelManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class testMain {
    public static void main(String[] args) throws IOException {


        UserDataAcessInterface dao = new CommonUserDataAccessObject();
        PetProfileDataAccessInterface daop = new PetProfileDataAccessObject();
        ProfilePictureDataAccessInterface daopic = new CommonProfileDataAccessObject();

        AppUser michael = dao.retrieve("Michael");
        PetProfile dog1 = daop.getProfile(0);
        PetProfile dog2 = daop.getProfile(1);
//        michael.addFavProfile(dog1.getId());
//        michael.addFavProfile(dog2.getId());
//        dao.update(michael);
//        daopic.uploadPetProfile(dog1.getId(), new File("resources/testingPetProfiles/gr1.png"));
//        daopic.uploadPetProfile(dog2.getId(), new File("resources/testingPetProfiles/gr2.png"));

        ViewModelManager manager = new ViewModelManager();
        FavPetPageViewModel vm = new FavPetPageViewModel();
        FavPetPageView view = FavPetPageFactory.createFavPetPage(manager, vm, dao, daop);
        //viewthis cycle
        DisplayUserPresenter DUpresenter = new DisplayUserPresenter(vm.getDisplayUserModel());
        DisplayUserUCI DUuci = new DisplayUserUCI(DUpresenter,daopic);
        DisplayUserController DUcontroller = new DisplayUserController(DUuci);
        DUcontroller.execute(michael.getUsername());

        vm.getAddViewModel().getState().addPetNameAndPhoto(
                dog1.getId(),
                dog1.getName(),
                daopic.retrievePetProfile(dog1.getId()));
        vm.getAddViewModel().getState().addPetNameAndPhoto(
                dog2.getId(),
                dog2.getName(),
                daopic.retrievePetProfile(dog2.getId()));

        vm.viewmodelsfirePropertyChanges();
        JFrame app = new JFrame();
        app.add(view);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,500);
    }
}
