package configProfile;
import viewModel.ViewModelManager;
import usecase.ConfigProfile.ConfigProfileOutputBoundary;

public class ConfigProfilePresenter implements ConfigProfileOutputBoundary {
    private final ConfigProfileViewModel configProfileViewModel;
    private final ViewModelManager viewModelManager;

    public ConfigProfilePresenter(ConfigProfileViewModel configProfileViewModel, ViewModelManager viewModelManager) {
        this.configProfileViewModel = configProfileViewModel;
        this.viewModelManager = viewModelManager;
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println("PRESENTER: fail view executed  "+ error);
        ConfigProfileState configProfileState = configProfileViewModel.getState();
        configProfileState.setError(error);
        System.out.println("PRESENTER state: " + configProfileState.toString());
        configProfileViewModel.setState(configProfileState);
        configProfileViewModel.firePropertyChanged();

    }
}