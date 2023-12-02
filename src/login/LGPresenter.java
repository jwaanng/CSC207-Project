package login;
import configProfile.ConfigProfileState;
import configProfile.ConfigProfileViewModel;
import favPetPage.FavPetPageViewModel;
import favPetPage.addAFavPet.AddState;
import favPetPage.displayUser.DisplayUserState;
import viewModel.ViewModelManager;

/**
 * The {@code LGPresenter} class handles the presentation logic for the login feature, coordinating with
 * various view models and managing the transition between different states in the application.
 */
public class LGPresenter implements LGOB{
    private final LGViewModel lgVM;
    private final FavPetPageViewModel fpVM;

    private final ViewModelManager manager;

    private final ConfigProfileViewModel configProfileViewModel;


    /**
     * Constructs an {@code LGPresenter} instance with the specified view models and manager.
     *
     * @param loginViewModel         The view model for the login feature.
     * @param favPetPageViewModel    The view model for the favorite pet page feature.
     * @param viewModelManager       The manager for handling different view models in the application.
     * @param configProfileViewModel The view model for the configuration profile feature.
     */
    public LGPresenter(LGViewModel loginViewModel, FavPetPageViewModel favPetPageViewModel,
                       ViewModelManager viewModelManager, ConfigProfileViewModel configProfileViewModel) {
        this.lgVM = loginViewModel;
        this.manager = viewModelManager;
        this.fpVM = favPetPageViewModel;
        this.configProfileViewModel = configProfileViewModel;
    }

    /**
     * Prepares the view for a successful login by updating the state of the favorite pet page and
     * triggering necessary property changes in the view models.
     *
     * @param outputData The output data containing information for the success view.
     */
    @Override
    public void prepareSuccessView(LGOPData outputData) {
        // Logic to prepare the view for a successful login

        // Redirect to the favorite pet page
        DisplayUserState currState = fpVM.getDisplayUserModel().getState();
        currState.setUsername(outputData.username);
        currState.setPhoto(outputData.profile);
        fpVM.getDisplayUserModel().setState(currState);
        fpVM.getDisplayUserModel().firePropertyChanged();

        AddState state = new AddState(outputData);
        if (!state.getKeyEntries().isEmpty()) {
            fpVM.getNoPetDisplayViewModel().firePropertyChanged();
        } else {
            fpVM.getAddViewModel().setState(state);
            fpVM.viewmodelsfirePropertyChanges();
        }

        manager.setActiveViewName(fpVM.getViewName()); // Redirect to the favorite pet page through manager
        manager.firePropertyChange();

        // Update the configuration profile state with the username
        ConfigProfileState configProfileState = configProfileViewModel.getState();
        configProfileState.setUsername(outputData.username);
    }

    /**
     * Prepares the view for a failed login by updating the state of the login view and triggering
     * necessary property changes in the view model.
     *
     * @param outData The output data containing information for the fail view.
     */
    @Override
    public void prepareFailView(LGOPData outData) {
        // Logic to prepare the view for a failed login

        LGState state = new LGState();
        state.setError(outData.error);
        lgVM.setState(state);
        lgVM.firePropertyChanged();
    }
}