package app;

import browsePage.BrowsePageView;
import browsePage.BrowsePageViewModel;
import browsePage.swipe.InitiateProfileSwiper;
import dataAccessObject.*;
import entity.user.AppUser;
import favPetPage.FavPetPageView;
import favPetPage.FavPetPageViewModel;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import favPetPage.myFavPetPageRedirect.FavPetRDRPresenter;
import favPetPage.myFavPetPageRedirect.FavPetRDRUCI;
import login.*;
import myPets.MyPetsView;
import myPets.MyPetsViewModel;
import myPets.myPetPageRedirect.MyPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRPresenter;
import myPets.myPetPageRedirect.MyPetRDRUCI;
import myProfilePage.MyProfileView;
import myProfilePage.MyProfileViewModel;
import myProfilePage.myProfileRedirect.MyProfileRDRController;
import myProfilePage.myProfileRedirect.MyProfileRDRPresenter;
import myProfilePage.myProfileRedirect.MyProfileRDRUCI;
import signupPage.SignupView;
import signupPage.SignupViewModel;
import browsePage.browsePageRedirect.*;
import view.ViewManager;
import viewModel.ViewModelManager;

import javax.swing.*;
import java.awt.*;

public class main {
    //APP Building
    public static void main(String[] args) {

        //intialize all data access objects
        UserDataAccessInterface userDataAccessInterface = new CommonUserDataAccessObject();


        PetProfileDataAccessInterface petProfileDataAccessInterface = new PetProfileDataAccessObject();
        ProfilePictureDataAccessInterface profilePictureDataAccessInterface = new CommonProfileDataAccessObject();
        //intialize all needed viewmodels
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        FavPetPageViewModel favPetPageViewModel = new FavPetPageViewModel();
        MyProfileViewModel myProfileViewModel = new MyProfileViewModel();
        MyPetsViewModel myPetsViewModel = new MyPetsViewModel();
        BrowsePageViewModel browsePageViewModel = new BrowsePageViewModel();
        ViewModelManager manager = new ViewModelManager();

        //app pages system control
        CardLayout appLayout = new CardLayout();
        JPanel views = new JPanel(appLayout);
        ViewManager viewManager = new ViewManager(appLayout, views, manager);


        //intialize page redirecting controllers,
        MyProfileRDRPresenter myProfileRDRPresenter = new MyProfileRDRPresenter(manager, myProfileViewModel);
        MyProfileRDRUCI myProfileRDRUCI = new MyProfileRDRUCI(myProfileRDRPresenter);
        MyProfileRDRController myProfileRDRController = new MyProfileRDRController(myProfileRDRUCI);

        BrowsePageRDRPresenter browsePageRDRPresenter = new BrowsePageRDRPresenter(manager, browsePageViewModel);
        BrowsePageRDRUCI browsePageRDRUCI = new BrowsePageRDRUCI(
                browsePageRDRPresenter,
                new InitiateProfileSwiper(userDataAccessInterface,petProfileDataAccessInterface,browsePageViewModel));
        BrowsePageRDRController browsePageRDRController = new BrowsePageRDRController(browsePageRDRUCI);

        FavPetRDRPresenter FavPetRDRPresenter = new FavPetRDRPresenter(manager,favPetPageViewModel);
        FavPetRDRUCI FavPetRDRUCI = new FavPetRDRUCI(FavPetRDRPresenter);
        FavPetRDRController favPetRDRController = new FavPetRDRController(FavPetRDRUCI);

        MyPetRDRPresenter myPetRDRPresenter = new MyPetRDRPresenter(myPetsViewModel, manager);
        MyPetRDRUCI myPetRDRUCI = new MyPetRDRUCI(myPetRDRPresenter);
        MyPetRDRController myPetRDRController = new MyPetRDRController(myPetRDRUCI);


        //sign up page
        SignupView signup = SignupPageFactory.createSignUpPage(
                manager,
                signupViewModel,
                loginViewModel,
                userDataAccessInterface
        );
        views.add(signup, signupViewModel.getViewName());
        appLayout.show(views, signupViewModel.getViewName());

        //log in page
        LoginView login = LoginPageFactory.createLoginPage(
                manager,
                loginViewModel,
                favPetPageViewModel,
                myProfileViewModel,
                browsePageViewModel,
                myPetsViewModel,
                userDataAccessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface
        );
        views.add(login, loginViewModel.getViewName());

        //fav pet page
        FavPetPageView favPetPage = FavPetPageFactory.createFavPetPage(manager,
                favPetPageViewModel,
                browsePageViewModel,
                userDataAccessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface,
                browsePageRDRController,
                myPetRDRController,
                myProfileRDRController
        );
        views.add(favPetPage, favPetPageViewModel.getViewName());

        //my pets page
        MyPetsView myPetsPage = MyPetsPageFactory.createMyPetsPage(myPetsViewModel,
                userDataAccessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface,browsePageRDRController,
                favPetRDRController,
                myProfileRDRController);
        views.add(myPetsPage, myPetsViewModel.getViewName());

        //my profile page
        MyProfileView myProfilePage = MyProfilePageFactory.createMyProfilePage(myProfileViewModel,favPetPageViewModel,
                userDataAccessInterface,
                profilePictureDataAccessInterface,
                browsePageRDRController,
                favPetRDRController,
                myPetRDRController
                );
        views.add(myProfilePage, myProfileViewModel.getViewName());
        //browse page
        BrowsePageView brosePage = BrowsePetPageFactory.createBrowsePage(
                browsePageViewModel,
                favPetPageViewModel,
                userDataAccessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface,
                favPetRDRController,myPetRDRController,
                myProfileRDRController);
        views.add(brosePage, browsePageViewModel.getViewName());
        //creating app
        JFrame app = new JFrame();
        app.add(views);
        app.pack();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setSize(1000, 1000);
        app.setVisible(true);


    }


}
