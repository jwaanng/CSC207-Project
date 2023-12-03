package favPetPage.viewThisPetProfile;

/**
 * A concrete implementation of {@link ViewThisOB}
 *
 * An implementation of the ViewThisPetProfile usecase presenter
 * Tasks with redirecting user to a popup window where a detail description of pet profile is displayed
 */
public class ViewThisPresenter implements ViewThisOB {
    private final ViewThisViewModel vm;
    /**
     * Construct an BrowsePresenter object
     *
     * @param viewThisViewModel a viewmodel for the viewThisPetProfile usecase.
     *                            <p>
     *                            This is called by the ViewThisPresenter to
     *                            view the detailed pet profile
     *
     */
    public ViewThisPresenter(ViewThisViewModel viewThisViewModel) {
        vm = viewThisViewModel;
    }

    /**
     * Send information to be displayed when the usecase success
     *
     * @param outputData the ViewThisOPData output data that stores this information
     */
    @Override
    public void prepareSuccessView(ViewThisOPData outputData) {
        ViewThisState state = new ViewThisState(outputData);
        vm.setState(state);
        vm.firePropertyChanged();

    }

    /**
     * Send information to be displayed when the usecase failed
     *
     * @param outputData the ViewThisOPData output data that stores this information
     */
    @Override
    public void prepareFailView(ViewThisOPData outputData) {
        ViewThisState state = new ViewThisState(outputData);
        vm.setState(state);
        vm.firePropertyChanged();
    }
}
