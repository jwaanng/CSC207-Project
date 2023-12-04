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
import myPets.myPetPageRedirect.MyPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRPresenter;
import myPets.myPetPageRedirect.MyPetRDRUCI;
import view.ViewManager;
import viewModel.ViewModelManager;

import javax.swing.*;
import java.awt.*;

public class testMain {
    public static void main(String[] args) {
//
//        JFrame application = new JFrame("MyPets Example");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//
//        // The various View objects. Only one view is visible at a time.
//        JPanel views = new JPanel(cardLayout);
//        application.add(views);
//
//
//        views.add(myPetsView, myPetsView.viewName);
//
//        manager.setActiveViewName(myPetsView.viewName);
//        manager.firePropertyChange();
//
//
//        JFrame app = new JFrame();
//        app.add(views);
//        app.setVisible(true);
//        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        app.setSize(500,500);
    }
}
