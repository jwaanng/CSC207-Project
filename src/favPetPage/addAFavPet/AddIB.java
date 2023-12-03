package favPetPage.addAFavPet;

/**
 * This interface specifies required methods for an addAFavPet usecase interactor
 */
public interface AddIB {
    /***
     * an interactor of this usecase can execute to add a favorite pet
     */
    void execute(String username, int petId);
}
