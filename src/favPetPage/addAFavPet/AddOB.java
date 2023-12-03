package favPetPage.addAFavPet;

/**
 * This interface specifies required methods for an addAFavPet usecase presenter
 */
public interface AddOB {
    /***
     * a presenter of this usecase can tell the screen that adding a pet failed
     */
    void prepareFailView(AddOPData outputData);

    /***
     * a presenter of this usecase can tell the screen to change when adding a pet succeed
     */
    void prepareSucessView(AddOPData outputData);
}
