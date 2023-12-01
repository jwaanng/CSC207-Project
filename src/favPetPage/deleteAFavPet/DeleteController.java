package favPetPage.deleteAFavPet;

/**
 * The DeleteController class send input data to the backend after user performs action of unlike a favorite pet profile
 */
public class DeleteController {
    private final DeleteIB uci;

    /**
     * Construct an DeleteController
     *
     * @param deleteAFavoritePetInputBoundary an usecase interactor for the deleteAFavPet usecase
     */
    public DeleteController(DeleteIB deleteAFavoritePetInputBoundary) {
        this.uci = deleteAFavoritePetInputBoundary;
    }

    /**
     * Call usecase interactor to perform usecase
     *
     * @param username an existing username
     * @param petId    an existing id of a public pet profile that is liked/marked favorite by the user
     */
    public void execute(String username, int petId) {
        DeleteIPData data = new DeleteIPData();
        data.username = username;
        data.id = petId;
        uci.execute(data);
    }
}
