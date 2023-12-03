package favPetPage.deleteAFavPet;

/**
 * This interface specifies required methods for a deleteAFavPet usecase presenter
 */
public interface DeleteOB {
    /***
     * a presenter of this usecase can tell the screen to remove an unliked pet profile
     */
    void prepareSuccessView(int deletedId);
}
