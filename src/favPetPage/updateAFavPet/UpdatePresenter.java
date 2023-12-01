package favPetPage.updateAFavPet;

/**
 * An implementation of the updateAFavPet usecase presenter
 * Tasks with sending information on an existing pet profile that is liked by the user
 */
public class UpdatePresenter implements UpdateOB {
    private final UpdateViewModel updateVM;

    /**
     * Construct UpdatePresenter
     *
     * @param updateViewModel a viewmodel for the updateAFavPet usecase. This is called by the UpdatePresenter to store
     *                        information that a user screen should see;
     */
    public UpdatePresenter(UpdateViewModel updateViewModel) {
        this.updateVM = updateViewModel;
    }

    /**
     * Send information on pet profile that needs to be updated
     *
     * @param outputData the UpdateOPData that stores this information
     */
    @Override
    public void prepareSuccessView(UpdateOPData outputData) {
        UpdateState curr = updateVM.getState();
        curr.addPetNameAndPhoto(outputData.petId, outputData.name, outputData.photo);
        updateVM.setState(curr);
        //Do not fire property change, queued until next time redirects to fav pet page
    }
}
