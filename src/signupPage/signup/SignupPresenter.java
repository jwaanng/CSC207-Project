package signupPage.signup;

import login.LoginViewModel;
import signupPage.SignupViewModel;
import viewModel.ViewModelManager;

public class SignupPresenter implements SignupOutputBound {
    private final SignupViewModel signupViewModel;

    private final LoginViewModel loginViewModel;
    private final ViewModelManager viewModelManager;

    public SignupPresenter(SignupViewModel signupViewModel, LoginViewModel loginViewModel, ViewModelManager viewModelManager) {
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.viewModelManager = viewModelManager;
    }

    @Override
    public void prepareSignupSuccessView(SignupOutputData user) {
        viewModelManager.setActiveViewName(loginViewModel.getViewName());
        viewModelManager.firePropertyChange();

    }

    @Override
    public void prepareSignUpFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setError(error);
        signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
    }
}