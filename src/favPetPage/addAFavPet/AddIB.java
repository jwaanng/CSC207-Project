package favPetPage.addAFavPet;

/**
 * This interface specifies required methods for an addAFavPet usecase interactor
 */
public interface AddIB {
    void execute(String username, int petId);
}
