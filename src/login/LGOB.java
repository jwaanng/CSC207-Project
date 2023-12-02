package login;

/**
 * The LGOB (Login Output Boundary) interface defines the contract for presenting success or failure views.
 */
public interface LGOB {

    /**
     * Prepares the view for a successful login.
     *
     * @param outputData The output data containing information for the success view.
     */
    void prepareSuccessView(LGOPData outputData);

    /**
     * Prepares the view for a failed login.
     *
     * @param outputData The output data containing information for the fail view.
     */
    void prepareFailView(LGOPData outputData);
}