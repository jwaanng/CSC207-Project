package app;


import dataAcessObject.UserDataAccessInterface;
import entity.user.AppUserFactory;
import login.LoginViewModel;
import signupPage.cancel.CancelController;
import signupPage.cancel.CancelPresenter;
import signupPage.cancel.CancelUCI;
import signupPage.SignupView;
import signupPage.signup.SignupController;
import signupPage.signup.SignupUCI;
import signupPage.signup.SignupPresenter;
import signupPage.SignupViewModel;
import viewModel.ViewModelManager;

public class SignupPageFactory {
    /**
     * Factory method to create an instance of {@link SignupView}.
     * <p>
     * This method initializes and configures the necessary components for the signup page,
     * such as controllers and presenters for handling user signup
     *
     * @param manager                 The {@link ViewModelManager} responsible for managing view models.
     * @param signupViewModel         The {@link SignupViewModel} associated with the signup Page
     * @param loginViewModel          The {@link LoginViewModel} associate with the login page
     * @param userDataAccessInterface A data access object implementing {@link UserDataAccessInterface}
     *                                for accessing user data.
     * @return An instance of {@link SignupView} configured with the necessary components.
     */
    public static SignupView createSignUpPage(
            ViewModelManager manager,
            SignupViewModel signupViewModel,
            LoginViewModel loginViewModel,
            UserDataAccessInterface userDataAccessInterface
    ) {
        SignupPresenter signupPresenter = new SignupPresenter(signupViewModel, loginViewModel, manager);
        SignupUCI signupUCI = new SignupUCI(userDataAccessInterface, signupPresenter, new AppUserFactory());
        SignupController signupController = new SignupController(signupUCI);
        CancelPresenter cancelPresenter = new CancelPresenter(loginViewModel, manager);
        CancelUCI cancelUCI = new CancelUCI(cancelPresenter);
        CancelController cancelController = new CancelController(cancelUCI);
        return new SignupView(signupViewModel, signupController, cancelController);
    }

}
