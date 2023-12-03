package favPetPage.viewThisPetProfile;

/**
 * This interface specifies required methods for a viewThisPetProfile usecase presenter
 */
public interface ViewThisOB {
    /***
     * a presenter of this usecase can tell the screen when
     * the pet owner just deleted the pet profile while the user who liked the pet profile  tries to view it
     */
    void prepareSuccessView(ViewThisOPData outputData);
    /***
     * a presenter of this usecase can tell the screen to display a liked pet profile
     */
    void prepareFailView(ViewThisOPData outputData);
}
