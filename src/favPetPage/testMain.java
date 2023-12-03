package favPetPage;

import app.FavPetPageFactory;
import dataAcessObject.*;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

import favPetPage.displayUser.DisplayUserController;
import favPetPage.displayUser.DisplayUserPresenter;
import favPetPage.displayUser.DisplayUserUCI;
import favPetPage.updateAFavPet.UpdateController;
import favPetPage.updateAFavPet.UpdatePresenter;
import favPetPage.updateAFavPet.UpdateUCI;
import viewModel.ViewModelManager;

import javax.swing.*;
import java.io.IOException;

public class testMain {
    public static void main(String[] args) throws IOException {


        UserDataAccessInterface dao = new CommonUserDataAccessObject();
        PetProfileDataAccessInterface daop = new PetProfileDataAccessObject();
        ProfilePictureDataAccessInterface daopic = new CommonProfileDataAccessObject();
//        AppUser jack = new AppUser("Jack", "123Jack", "1sd4GoodKing",   "Jack0924320");
//        AppUser monder = new AppUser("Monder", "123Monder", "123213GoodQueen", "Monder2344");
//        jack.certifyAsPetOwner();
//        monder.certifyAsPetOwner();
//        dao.add(jack);
//        dao.add(monder);
        AppUser michael = dao.retrieve("Michael");
//       DogProfile jessica = new PetProfileBuilderFactory().createDogProfile("Jack").
//               vaccinated(true).neutered(true).withBreed("Labarado").withAge(4).isMale().withName("Jessica").build();
//     DogProfile mondrea = new PetProfileBuilderFactory().createDogProfile("Monder").vaccinated(true).isLargePet().
//          withBreed("Golden retriver").withAge(1).isFemale().withName("Mondrea").build();
//     daop.add(jessica);
//     daop.add(mondrea);
//    jessica.setTemperDescr("I am always very happy");
//    jessica.setLikeDescr("I will always like playing with human");
//    daop.update(jessica);
    PetProfile dog1 = daop.getProfile(0);
      PetProfile dog2 = daop.getProfile(1);

//        michael.addFavProfile(dog1.getId());
//        michael.addFavProfile(dog2.getId());
//        dao.update(michael);
//        daopic.uploadPetProfile(dog1.getId(), new File("resources/testingPetProfiles/gr1.png"));
//        daopic.uploadPetProfile(dog2.getId(), new File("resources/testingPetProfiles/gr2.png"));
        ViewModelManager manager = new ViewModelManager();
        FavPetPageViewModel vm = new FavPetPageViewModel();
        FavPetPageView view = FavPetPageFactory.createFavPetPage(manager, vm, dao, daop, daopic);

        DisplayUserPresenter DUpresenter = new DisplayUserPresenter(vm.getDisplayUserModel());
        DisplayUserUCI DUuci = new DisplayUserUCI(DUpresenter,daopic);
        DisplayUserController DUcontroller = new DisplayUserController(DUuci);
        DUcontroller.execute(michael.getUsername());
        vm.getDisplayUserModel().firePropertyChanged();
        vm.getAddViewModel().getState().addPetNameAndPhoto(
                dog1.getId(),
                dog1.getName(),
                daopic.retrievePetProfile(dog1.getId()));
        vm.getAddViewModel().getState().addPetNameAndPhoto(
                dog2.getId(),
                dog2.getName(),
                daopic.retrievePetProfile(dog2.getId()));

        vm.viewmodelsfirePropertyChanges();
        dog1.setName("Avelene");
        daop.update(dog1);
        UpdatePresenter UDpresenter = new UpdatePresenter(vm.getUpdateViewModel());
        UpdateUCI UDuci = new UpdateUCI(UDpresenter,daop, daopic);
        UpdateController UDController = new UpdateController(UDuci);
        UDController.execute(0);
        vm.viewmodelsfirePropertyChanges();




        JFrame app = new JFrame();
        app.add(view);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,500);
    }
}
