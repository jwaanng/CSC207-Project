package signUp;

import login.LGViewModel;
import viewModel.ViewModelManager;
import usecase.signUp.SignupOutputBound;
import usecase.signUp.SignupOutputData;

/**
 * Presenter class for user signup.
 *
 * This class implements the SignupOutputBound interface and is responsible for preparing
 * the view based on the outcomes of the user signup feature, such as success or failure.
 */
public class SignupPresenter implements SignupOutputBound {
    private final SignupViewModel signupViewModel;
    private final LGViewModel loginViewModel;
    private final ViewModelManager viewModelManager;

    /**
     * Constructor for the SignupPresenter class.
     *
     * @param signupViewModel   The view model associated with the user signup feature.
     * @param loginViewModel    The view model associated with the login feature.
     * @param viewModelManager  The manager responsible for managing view models.
     */
    public SignupPresenter(SignupViewModel signupViewModel, LGViewModel loginViewModel, ViewModelManager viewModelManager) {
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.viewModelManager = viewModelManager;
    }

    /**
     * Prepares the view for a successful execution of the user signup feature.
     *
     * This method sets the active view name to the login view, notifies the view model manager
     * of the property change, and prints debugging information to the console.
     *
     * @param user The output data containing information about the signed-up user.
     */
    @Override
    public void prepareSignupSuccessView(SignupOutputData user) {
        viewModelManager.setActiveViewName(loginViewModel.getViewName());
        viewModelManager.firePropertyChange();
    }

    /**
     * Prepares the view for a failed execution of the user signup feature.
     *
     * This method sets the error message in the SignupViewModel's state, notifies the view model
     * of the property change
     *
     * @param error A message describing the reason for the failure which can be set formcont.
     */
    @Override
    public void prepareSignUpFailView(String error) {
        System.out.println("PRESENTER: fail view executed  " + error);
        SignupState signupState = signupViewModel.getState();
        signupState.setError(error);
        System.out.println("PRESENTER state: " + signupState.toString());
        signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
    }
}