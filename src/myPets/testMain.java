package myPets;

//import app.MyPetPageFactory;

import dataAccessObject.*;
import entity.petProfile.PetProfileBuilderFactory;
import myPets.MyPetsDisplay.AddPetViewModel;
import myPets.MyPetsDisplay.AddPresenter;
import myPets.MyPetsDisplay.AddUCI;
import myPets.createNewDog.CreateController;
import myPets.createNewDog.CreatePresenter;
import myPets.createNewDog.CreateUCI;
import myPets.createNewDog.CreateUseCaseFactory;
import myPets.createRedirect.CreateRedirectController;
import myPets.createRedirect.CreateRedirectPresenter;
import myPets.createRedirect.CreateRedirectUCI;
import myPets.createRedirect.CreateRedirectViewModel;
import myPets.deleteMyPet.DeleteMyPetController;
import myPets.deleteMyPet.DeleteMyPetIB;
import myPets.deleteMyPet.DeleteMyPetPresenter;
import myPets.deleteMyPet.DeleteMyPetUCI;
import myPets.innerViews.CreatePetView;
import myPets.myPetDisplayRedirect.MyPetRedirectController;
import myPets.myPetDisplayRedirect.MyPetRedirectPresenter;
import myPets.myPetDisplayRedirect.MyPetRedirectUCI;
import myPets.myPetDisplayRedirect.MyPetRedirectViewModel;
import myPets.myPetsRedirect.MyRedirectController;
import myPets.myPetsRedirect.MyRedirectPresenter;
import myPets.myPetsRedirect.MyRedirectUCI;
import view.ViewManager;
import viewModel.ViewModelManager;

import javax.swing.*;
import java.awt.*;

public class testMain {
    public static void main(String[] args) {

        JFrame application = new JFrame("MyPets Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewModelManager viewManagerModel = new ViewModelManager();
        new ViewManager(cardLayout, views, viewManagerModel);

        InnerViewModelManager innerViewManagerModel = new InnerViewModelManager();
        //new InnerViewManager(cardLayout, views, viewManagerModel);

        MyPetsViewModel myPetsViewModel = new MyPetsViewModel();
        UserDataAccessInterface dao = new CommonUserDataAccessObject();
        PetProfileDataAccessObject daop = new PetProfileDataAccessObject();
        ProfilePictureDataAccessInterface daoPic = new CommonProfileDataAccessObject();
        CreateRedirectViewModel createRedirectViewModel = new CreateRedirectViewModel();
        MyPetRedirectViewModel myPetRedirectViewModel = new MyPetRedirectViewModel();

        PetProfileBuilderFactory petProfileBuilderFactory = new PetProfileBuilderFactory();

        //delete fav pet cycle
        DeleteMyPetPresenter deletePresenter = new DeleteMyPetPresenter(myPetsViewModel.getDeleteMyPetViewModel());
        DeleteMyPetIB deleteUCI = new DeleteMyPetUCI(daop, deletePresenter);
        DeleteMyPetController deleteController = new DeleteMyPetController(deleteUCI);

        //view this pet cycle
//        ViewThisPresenter viewThisPresenter = new ViewThisPresenter();
//        ViewThisIB vtpuci = new ViewThisUCI(daop, viewThisPresenter);
//        ViewThisController viewThisController = new ViewThisController(vtpuci);

        //redirect cycle
        MyRedirectPresenter myRedirectPresenter= new MyRedirectPresenter(myPetsViewModel, innerViewManagerModel);
        MyRedirectUCI myRedirectUCI = new MyRedirectUCI(myRedirectPresenter);
        MyRedirectController myRedirectController = new MyRedirectController(myRedirectUCI);

        //Add Cycle
        AddPetViewModel addViewModel = new AddPetViewModel();
        AddPresenter addPresenter = new AddPresenter(addViewModel);
        AddUCI addUCI = new AddUCI(addPresenter, dao, daop, daoPic);

        //MyPetsRedirect Cycle
        MyPetRedirectPresenter myPetRedirectPresenter= new MyPetRedirectPresenter(myPetRedirectViewModel);
        MyPetRedirectUCI myPetRedirectUCI = new MyPetRedirectUCI(myPetRedirectPresenter);
        MyPetRedirectController myPetRedirectController = new MyPetRedirectController(myPetRedirectUCI);

        //Create cycle
        CreatePresenter createPresenter = new CreatePresenter(innerViewManagerModel, myPetsViewModel, myPetsViewModel.getCreateViewModel());
        CreateUCI createUCI = new CreateUCI(createPresenter, petProfileBuilderFactory , daop, daoPic);
        CreateController createController = new CreateController(createUCI);
        CreatePetView createView = CreateUseCaseFactory.create(innerViewManagerModel, myPetsViewModel, myPetsViewModel.getCreateViewModel(), daop, myPetRedirectController, daoPic);
        views.add(createView, createView.viewName);

        //Create Redirect Cycle
        CreateRedirectPresenter createRedirectPresenter = new CreateRedirectPresenter(createRedirectViewModel);
        CreateRedirectUCI createRedirectUCI = new CreateRedirectUCI(createRedirectPresenter);
        CreateRedirectController createRedirectController = new CreateRedirectController(createRedirectUCI);


        MyPetsView myPetsView = new MyPetsView(innerViewManagerModel, myPetsViewModel,deleteController, myRedirectController, daop, createRedirectViewModel, createController, createRedirectController, myPetRedirectViewModel, myPetRedirectController);
        views.add(myPetsView, myPetsView.viewName);

        viewManagerModel.setActiveViewName(myPetsView.viewName);
        viewManagerModel.firePropertyChange();


        JFrame app = new JFrame();
        app.add(views);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,500);
    }
}
