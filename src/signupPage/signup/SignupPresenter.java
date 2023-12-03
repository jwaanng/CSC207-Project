package signupPage.signup;

import login.LoginViewModel;
import signupPage.SignupViewModel;
import viewModel.ViewModelManager;

/**
 * Presenter class for user signup.
 * <p>
 * This class implements the {@link SignupOB}  and is responsible for preparing
 * the view based on the outcomes of the user signup feature, such as success or failure.
 */
public class SignupPresenter implements SignupOB {
    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewModelManager viewModelManager;

    /**
     * Constructor for the SignupPresenter class.
     *
     * @param signupViewModel  The {@link SignupViewModel} that stores all information associated with
     *                         the user signup feature.
     * @param loginViewModel   The {@link LoginViewModel}  that stores all information associated with login feature.
     * @param viewModelManager The {@link ViewModelManager} responsible for managing view models.
     */

    public SignupPresenter(SignupViewModel signupViewModel, LoginViewModel loginViewModel, ViewModelManager viewModelManager) {
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.viewModelManager = viewModelManager;
    }

    /**
     * Prepares the view for a successful execution of the user signup feature.
     * <p>
     * This method sets the active view name to the login view, notifies the view model manager
     * of the property change, and prints debugging information to the console.
     *
     * @param user The output data containing information about the signed-up user.
     */
    @Override
    public void prepareSignupSuccessView(SignupOPData user) {
        viewModelManager.setActiveViewName(loginViewModel.getViewName());
        viewModelManager.firePropertyChange();
    }

    /**
     * Prepares the view for a failed execution of the user signup feature.
     * <p>
     * This method sets the error message in the SignupViewModel's state, notifies the view model
     * of the property change
     *
     * @param error A message describing the reason for the failure which can be set formcont.
     */
    @Override
    public void prepareSignUpFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setError(error);
        signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
    }
}