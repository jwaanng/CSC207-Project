package favPetPage.updateAFavPet;

/**
 * This interface specifies required methods for a updateAFavPet usecase interactor
 */
public interface UpdateIB {
    /***
     * an interactor of this usecase can execute to update a pet profile in the liked list
     */
    void execute(int petId);
}
