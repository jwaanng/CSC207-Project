package favPetPage.updateAFavPet;

/**
 * This interface specifies required methods for a updateAFavPet usecase presenter
 */
public interface UpdateOB {
    /***
     * a presenter of this usecase can tell the screen to update a pet profile's display
     */
    void prepareSuccessView(UpdateOPData outputData);
}
