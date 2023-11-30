package favPetPage.displayUser;

public class DisplayUserPresenter implements  DisplayUserOB{
    private final DisplayUserModel displayVM;

    public DisplayUserPresenter(DisplayUserModel displayUserModel) {
        this.displayVM = displayUserModel;
    }

    @Override
    public void prepareSuccessView(DisplayUserOPData outputData) {
        DisplayUserState currState = displayVM.getState();
        if(!outputData.username.isEmpty()) {
            currState.setUsername(currState.getUsername());
        }
        if (!outputData.photoUrl.isEmpty()){
            currState.setProfilePhotoUrl(outputData.photoUrl);
        }
        displayVM.setState(currState);
        displayVM.firePropertyChanged();
    }
}
