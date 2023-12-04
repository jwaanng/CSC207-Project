package configProfile;
import browsePage.BrowsePageViewModel;

import usecase.configProfile.ConfigProfileOutputBoundary;
import viewModel.ViewModelManager;

/**
 * Presenter class for configuring user profiles.
 *
 * This class implements the ConfigProfileOutputBoundary interface and is responsible for preparing
 * the view based on the outcomes of the user profile configuration feature, such as success or failure.
 */
public class ConfigProfilePresenter implements ConfigProfileOutputBoundary {

    /**
     * The view model associated with the user profile configuration feature.
     */
    private final ConfigProfileViewModel configProfileViewModel;

    /**
     * The view model associated with the Browse Page feature.
     */
    private final BrowsePageViewModel browsePageViewModel;

    /**
     * The manager responsible for managing view models.
     */
    private final ViewModelManager viewModelManager;

    /**
     * Constructor for the ConfigProfilePresenter class.
     *
     * @param configProfileViewModel The view model associated with the user profile configuration feature.
     * @param browsePageViewModel    The view model associated with the Browse Page feature.
     * @param viewModelManager       The manager responsible for managing view models.
     */
    public ConfigProfilePresenter(ConfigProfileViewModel configProfileViewModel, BrowsePageViewModel browsePageViewModel, ViewModelManager viewModelManager) {
        this.configProfileViewModel = configProfileViewModel;
        this.viewModelManager = viewModelManager;
        this.browsePageViewModel = browsePageViewModel;
    }

    /**
     * Prepares the view for a failed execution of the user profile configuration feature.
     *
     * This method sets the error message in the ConfigProfileViewModel's state, notifies the view model
     * of the property change.
     *
     * @param error A message describing the reason for the failure - this can be set in con.
     */
    @Override
    public void prepareFailView(String error) {
        System.out.println("PRESENTER: fail view executed  " + error);
        ConfigProfileState configProfileState = configProfileViewModel.getState();
        configProfileState.setError(error);
        System.out.println("PRESENTER state: " + configProfileState.toString());
        configProfileViewModel.setState(configProfileState);
        configProfileViewModel.firePropertyChanged();
    }
}