package app;

import configProfile.SignupController;
import dataAcessObject.UserDataAcessInterface;
import entity.user.AppUserFactory;
import login.LoginViewModel;
import signupPage.cancel.CancelController;
import signupPage.cancel.CancelPresenter;
import signupPage.cancel.CancelUCI;
import signupPage.SignupView;
import signupPage.signup.SignupInteractor;
import signupPage.signup.SignupPresenter;
import signupPage.SignupViewModel;
import viewModel.ViewModelManager;

public class SignupPageFactory {
    public static SignupView createSignUpPage(
            ViewModelManager manager,
            SignupViewModel signupViewModel,
            LoginViewModel loginViewModel,
            UserDataAcessInterface userDataAcessInterface
            )
    {
        SignupPresenter signupPresenter = new SignupPresenter(signupViewModel, loginViewModel, manager);
        SignupInteractor signupInteractor = new SignupInteractor(userDataAcessInterface, signupPresenter, new AppUserFactory());
        SignupController signupController = new SignupController(signupInteractor);
        CancelPresenter cancelPresenter = new CancelPresenter(loginViewModel, manager);
        CancelUCI cancelUCI = new CancelUCI(cancelPresenter);
        CancelController cancelController = new CancelController(cancelUCI);
        return new SignupView(signupViewModel, signupController, cancelController);
    }

}
