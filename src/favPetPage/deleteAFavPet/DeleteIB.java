package favPetPage.deleteAFavPet;

/**
 * This interface specifies required methods for a deleteAFavPet usecase interactor
 */
public interface DeleteIB {
    /***
     * an interactor of this usecase can execute to remove an unliked pet profile
     */
    void execute(DeleteIPData inputData);
}
