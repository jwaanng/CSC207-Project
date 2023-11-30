package SignUp;

import Login.LGViewModel;
import ViewModel.ViewModelManager;
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
        System.out.println("PRESENTER: fail view executed  "+ error);
        SignupState signupState = signupViewModel.getState();
        signupState.setError(error);
        System.out.println("PRESENTER state: " + signupState.toString());
        signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
    }
}