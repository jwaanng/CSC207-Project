package favPetPage.addAFavPet;

/**
 * A concrete implementation of {@link AddOB}
 * <p>
 * An implementation of the addAFavPet usecase presenter
 * Tasks with sending information on a new pet profile that is liked by the user
 */
public class AddPresenter implements AddOB {

    private final AddViewModel addUpdateVM;

    /**
     * Construct an AddPresenter object
     *
     * @param addAFavPetViewModel a viewmodel for the addAFavPet usecase.
     *                            <p>
     *                            This is called by the AddPresenter to store
     *                            information that a user screen should see;
     */
    public AddPresenter(AddViewModel addAFavPetViewModel) {
        this.addUpdateVM = addAFavPetViewModel;
    }

    /**
     * Send information to be displayed when the usecase failed
     *
     * @param outputData the AddOPData output data that stores this information
     */

    @Override
    public void prepareFailView(AddOPData outputData) {
        //TODO  browsePage fire propertychange and error;

    }

    /**
     * Send information to be displayed when the usecase is successful
     *
     * @param outputData the AddOPData output data that stores this information
     */
    @Override
    public void prepareSucessView(AddOPData outputData) {
        AddState curr = addUpdateVM.getState();
        curr.addPetNameAndPhoto(outputData.petID, outputData.petName, outputData.photo);
        //do not fire property change, this will be queued until user redirects to fav pet page
    }
}
