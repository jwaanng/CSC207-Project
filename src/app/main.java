package app;

import dataAcessObject.*;
import favPetPage.FavPetPageView;
import favPetPage.FavPetPageViewModel;
import login.*;
import signupPage.SignupView;
import signupPage.SignupViewModel;
import view.ViewManager;
import viewModel.ViewModelManager;

import javax.swing.*;
import java.awt.*;

public class main {
    //APP Building
    public static void main(String[] args) {

        //intialize all data access objects
        UserDataAcessInterface userDataAcessInterface = new CommonUserDataAccessObject();
        PetProfileDataAccessInterface petProfileDataAccessInterface = new PetProfileDataAccessObject();
        ProfilePictureDataAccessInterface profilePictureDataAccessInterface = new CommonProfileDataAccessObject();
        //intialize all needed viewmodels
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        FavPetPageViewModel favPetPageViewModel = new FavPetPageViewModel();
        ViewModelManager manager = new ViewModelManager();

        //app pages system control
        CardLayout appLayout= new CardLayout();
        JPanel views = new JPanel(appLayout);
        ViewManager viewManager = new ViewManager(appLayout, views, manager);

        //sign up page
        SignupView signup = SignupPageFactory.createSignUpPage(
                manager,
                signupViewModel,
                loginViewModel,
                userDataAcessInterface
        );
        views.add(signup, signupViewModel.getViewName());
        appLayout.show(views, signupViewModel.getViewName());

        //log in page
        LoginView login = LoginPageFactory.createLoginPage(
                manager,
                loginViewModel,
                favPetPageViewModel,
                userDataAcessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface
        );
        views.add(login , loginViewModel.getViewName());

        //fav pet page
        FavPetPageView favPetPage = FavPetPageFactory.createFavPetPage(manager,
                favPetPageViewModel,
                userDataAcessInterface,
                petProfileDataAccessInterface,
                profilePictureDataAccessInterface
        );
        views.add(favPetPage, favPetPageViewModel.getViewName());

        //creating app
        JFrame app = new JFrame();
        app.add(views);
        app.pack();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setSize(1000,1000);
        app.setVisible(true);



    }



}
