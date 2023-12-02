package bePetOwner;

/**
 * Presenter class for the Be Pet Owner (BPO) feature.
 *
 * This class serves as a presenter in the Model-View-Presenter (MVP) part of clean CA architecture for the
 * Be Pet Owner feature. It is responsible for preparing the view based on the outcomes of the
 * Be Pet Owner feature, such as success or failure.
 */
public class BPOPresenter implements BPOOB {

    final BPOViewModel BPOvm;

    /**
     * Constructor for the BPOPresenter class.
     *
     * @param BPOvm The view model associated with the Be Pet Owner feature.
     */
    public BPOPresenter(BPOViewModel BPOvm) {
        this.BPOvm = BPOvm;
    }

    /**
     * Prepares the view for a successful execution of the Be Pet Owner feature.
     *
     * Implementing classes should define the specific actions to be taken when the Be Pet Owner
     * feature is executed successfully.
     */
    @Override
    public void prepareSuccessView() {
        // Implementation details...
    }

    /**
     * Prepares the view for a failed execution of the Be Pet Owner feature.
     *
     * Implementing classes should define the specific actions to be taken when the Be Pet Owner
     * feature encounters an error or fails to execute.
     *
     * @param errorMessage A message describing the reason for the failure.
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // Implementation details...
    }
}
