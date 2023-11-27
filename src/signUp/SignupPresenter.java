package signUp;

import login.LGViewModel;
import viewModel.ViewModelManager;
import usecase.SignUp.SignupOutputBound;
import usecase.SignUp.SignupOutputData;

public class SignupPresenter implements SignupOutputBound {
    private final SignupViewModel signupViewModel;

    private final LGViewModel loginViewModel;
    private final ViewModelManager viewModelManager;

    public SignupPresenter(SignupViewModel signupViewModel, LGViewModel loginViewModel, ViewModelManager viewModelManager) {
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
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}