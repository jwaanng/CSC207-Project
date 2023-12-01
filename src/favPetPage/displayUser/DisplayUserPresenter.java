package favPetPage.displayUser;

/**
 * An implementation of the displayUser usecase presenter
 * Tasks with sending information related to a user
 */
public class DisplayUserPresenter implements DisplayUserOB {
    private final DisplayUserViewModel displayVM;

    /**
     * Construct a DisplayUserPresenter
     *
     * @param displayUserViewModel a viewmodel for the diplayUser usecase. This is called by the DisplayUserPresenter
     *                             to store information that a user screen should see;
     */
    public DisplayUserPresenter(DisplayUserViewModel displayUserViewModel) {
        this.displayVM = displayUserViewModel;
    }

    /**
     * Send information on user to be displayed when the usecase is finished
     *
     * @param outputData the DisplayUserOPData output data that stores this information
     */
    @Override
    public void prepareSuccessView(DisplayUserOPData outputData) {
        DisplayUserState currState = displayVM.getState();
        if (!outputData.username.isEmpty()) {
            currState.setUsername(currState.getUsername());
        }
        if (!(outputData.photo == null)) {
            currState.setPhoto(outputData.photo);
        }
        displayVM.setState(currState);
        displayVM.firePropertyChanged();
    }
}
