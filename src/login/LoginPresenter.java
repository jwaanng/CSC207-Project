package login;

import configProfile.ConfigProfileState;
import configProfile.ConfigProfileViewModel;
import favPetPage.FavPetPageViewModel;
import favPetPage.addAFavPet.AddState;
import favPetPage.displayUser.DisplayUserState;
import viewModel.ViewModelManager;

/**
 * The {@code LoginPresenter} class handles the presentation logic for the login feature, coordinating with
 * various view models and managing the transition between different states in the application.
 */

public class LoginPresenter implements LoginOB {
    private final LoginViewModel lgVM;
    private final FavPetPageViewModel fpVM;

    private final ViewModelManager manager;

    private final ConfigProfileViewModel configProfileViewModel;


    /**
     * Constructs an {@code LGPresenter} instance with the specified view models and manager.
     *
     * @param loginViewModel         The view model for the login feature.
     * @param favPetPageViewModel    The view model for the favorite pet page feature.
     * @param manager                The manager for handling different view models in the application.
     * @param configProfileViewModel The view model for the configuration profile feature.
     */
    public LoginPresenter(LoginViewModel loginViewModel, FavPetPageViewModel favPetPageViewModel,
                          ViewModelManager manager,
                          ConfigProfileViewModel configProfileViewModel) {
        this.lgVM = loginViewModel;
        this.manager = manager;
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

    public void prepareSuccessView(LoginOPData outputData) {
        //login will automatically be redirected to the favPetPage

        DisplayUserState currState = fpVM.getDisplayUserModel().getState();
        currState.setUsername(outputData.username);
        currState.setPhoto(outputData.profile);
        fpVM.getDisplayUserModel().setState(currState);
        fpVM.getDisplayUserModel().firePropertyChanged();

        AddState state = new AddState(outputData);
        if (state.getKeyEntries().isEmpty()) {
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
     * @param outputData The output data containing information for the fail view.
     */
    @Override
    public void prepareFailView(LoginOPData outputData) {
        LoginState state = new LoginState();
        state.setError(outputData.error);
        lgVM.setState(state);
        lgVM.firePropertyChanged();
    }
}
