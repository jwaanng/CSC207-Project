package signupPage.cancel;

import login.LoginViewModel;
import viewModel.ViewModelManager;
/**
 * An implementation of a cancel usecase presenter
 * */
public class CancelPresenter implements CancelOB{

    private final LoginViewModel loginViewModel;

    private final ViewModelManager manager;
    /**
     *  Constructs a cancelPresenter
     * @param loginViewModel the viewmodel that stores all information about the login page
     * @param manager the object tasks with switching from sign up page to login page
     * */
    public CancelPresenter(LoginViewModel loginViewModel, ViewModelManager manager) {
        this.loginViewModel = loginViewModel;
        this.manager = manager;
    }

    /**
     * Command to switch to the login view
     * */
    @Override
    public void prepareSuccessView() {
        manager.setActiveViewName(loginViewModel.getViewName());
        manager.firePropertyChange();
    }
}
