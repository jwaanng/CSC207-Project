package myProfilePage.configProfile;

/**
 * Presenter class for configuring user profiles.
 *
 * This class implements the ConfigProfileOutputBoundary interface and is responsible for preparing
 * the view based on the outcomes of the user profile configuration feature, such as success or failure.
 */
public class ConfigProfilePresenter implements ConfigProfileOB {

    /**
     * The view model associated with the user profile configuration feature.
     */
    private final ConfigProfileViewModel configProfileViewModel;


    /**
     * Constructor for the ConfigProfilePresenter class.
     *
     * @param configProfileViewModel The view model associated with the user profile configuration feature.
     */
    public ConfigProfilePresenter(ConfigProfileViewModel configProfileViewModel) {
        this.configProfileViewModel = configProfileViewModel;
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

        ConfigProfileState configProfileState = configProfileViewModel.getState();
        configProfileState.setError(error);
        configProfileViewModel.setState(configProfileState);
        configProfileViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(ConfigProfileOPData outputData) {
        ConfigProfileState configProfileState = configProfileViewModel.getState();
        configProfileState.setUsername(outputData.name);
        configProfileState.setBio(outputData.bio);
        configProfileState.setAddress(outputData.address);
        configProfileState.setPreferredSex(outputData.preferredSex);
        configProfileState.setPreferredSize(outputData.preferredSize);
        configProfileViewModel.setState(configProfileState);
        configProfileViewModel.firePropertyChanged();
    }
}