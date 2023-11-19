package Login;

import FavPetPage.FavPetPageState;
import FavPetPage.FavPetViewModel;
import ViewModel.ViewModelManager;

public class LGPresenter implements LGOB{
    private final LGViewModel lgvm;
    private final FavPetViewModel pvm;


    private final ViewModelManager manager;


    public LGPresenter(LGViewModel loginViewModel, FavPetViewModel myFavPetPageViewModel, ViewModelManager manager) {
        this.lgvm = loginViewModel;
        this.manager = manager;
        this.pvm = myFavPetPageViewModel;
    }


    @Override
    public void prepareSuccessView(LGOPData outputData) {
        //login will automatically be redirected to the favPetPage
        //precondition outputData is of type success data
        String username = outputData.getUsername();
        FavPetPageState state = new FavPetPageState(outputData);
        pvm.setState(state); //viewModel now contain information about the user's name
        pvm.firePropertyChanged();
        manager.setActiveViewName(pvm.getViewName()); //redirect to myPetPage through manager
        manager.firePropertyChange();


    }

    @Override
    public void prepareFailView(LGOPData outdata) {
            LGState state = new LGState();
            state.setError(outdata.getError());
            lgvm.setState(state);
            lgvm.firePropertyChanged();
    }
}

