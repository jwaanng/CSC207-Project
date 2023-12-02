package configProfile;
import browsePage.BrowsePageViewModel;
import signUp.SignupState;
import usecase.ConfigProfile.ConfigProfileOutputBoundary;
import usecase.ConfigProfile.ConfigProfileOutputData;
import viewModel.ViewModelManager;

public class ConfigProfilePresenter implements ConfigProfileOutputBoundary {
    private final ConfigProfileViewModel configProfileViewModel;
    private final ViewModelManager viewModelManager;
    private final BrowsePageViewModel browsePageViewModel;
    public ConfigProfilePresenter(ConfigProfileViewModel configProfileViewModel, BrowsePageViewModel browsePageViewModel, ViewModelManager viewModelManager) {
        this.configProfileViewModel = configProfileViewModel;
        this.viewModelManager = viewModelManager;
        this.browsePageViewModel = browsePageViewModel;
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
