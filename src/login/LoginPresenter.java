package login;
import configProfile.ConfigProfileState;
import configProfile.ConfigProfileViewModel;
import favPetPage.FavPetPageViewModel;
import favPetPage.addAFavPet.AddState;
import favPetPage.displayUser.DisplayUserState;
import viewModel.ViewModelManager;

public class LoginPresenter implements LoginOB {
    private final LoginViewModel lgVM;
    private final FavPetPageViewModel fpVM;

    private final ViewModelManager manager;

    private final ConfigProfileViewModel configProfileViewModel;


    public LoginPresenter(LoginViewModel loginViewModel, FavPetPageViewModel favPetPageViewModel,
                          ViewModelManager manager,
                          ConfigProfileViewModel configProfileViewModel) {
        this.lgVM = loginViewModel;
        this.manager = manager;
        this.fpVM = favPetPageViewModel;
        this.configProfileViewModel = configProfileViewModel;
    }


    @Override
    public void prepareSuccessView(LoginOPData outputData) {
        //login will automatically be redirected to the favPetPage
        DisplayUserState currState = fpVM.getDisplayUserModel().getState();
        currState.setUsername(outputData.username);
        currState.setPhoto(outputData.profile);
        fpVM.getDisplayUserModel().setState(currState);
        fpVM.getDisplayUserModel().firePropertyChanged();
        AddState state = new AddState(outputData);
        if (state.getKeyEntries().isEmpty()){
        fpVM.getNoPetDisplayViewModel().firePropertyChanged();
        }
        else{
        fpVM.getAddViewModel().setState(state);
        fpVM.viewmodelsfirePropertyChanges();
        }
        manager.setActiveViewName(fpVM.getViewName()); //redirect to myPetPage through manager
        manager.firePropertyChange();

        ConfigProfileState configProfileState = configProfileViewModel.getState();
        configProfileState.setUsername(outputData.username);




    }

    @Override
    public void prepareFailView(LoginOPData outdata) {
            LoginState state = new LoginState();
            state.setError(outdata.error);
            lgVM.setState(state);
            lgVM.firePropertyChanged();
    }
}

