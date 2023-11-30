package login;
import favPetPage.FavPetPageViewModel;
import favPetPage.addAFavPet.AddState;
import favPetPage.displayUser.DisplayUserState;
import viewModel.ViewModelManager;

public class LGPresenter implements LGOB{
    private final LGViewModel lgVM;
    private final FavPetPageViewModel fpVM;

    private final ViewModelManager manager;


    public LGPresenter(LGViewModel loginViewModel, FavPetPageViewModel favPetPageViewModel, ViewModelManager manager) {
        this.lgVM = loginViewModel;
        this.manager = manager;
        this.fpVM = favPetPageViewModel;
    }


    @Override
    public void prepareSuccessView(LGOPData outputData) {
        //login will automatically be redirected to the favPetPage
        DisplayUserState currState = fpVM.getDisplayUserModel().getState();
        currState.setUsername(outputData.username);
        currState.setProfilePhotoUrl(outputData.profileURL);
        fpVM.getDisplayUserModel().setState(currState);
        fpVM.getDisplayUserModel().firePropertyChanged();
        AddState state = new AddState(outputData);
        if (!state.getKeyEntries().isEmpty()){
        fpVM.getNoPetDisplayViewModel().firePropertyChanged();
        }
        else{
        fpVM.getAddViewModel().setState(state);
        fpVM.viewmodelsfirePropertyChanges();
        }
        manager.setActiveViewName(fpVM.getViewName()); //redirect to myPetPage through manager
        manager.firePropertyChange();



    }

    @Override
    public void prepareFailView(LGOPData outdata) {
            LGState state = new LGState();
            state.setError(outdata.error);
            lgVM.setState(state);
            lgVM.firePropertyChanged();
    }
}

