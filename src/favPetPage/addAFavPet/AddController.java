package favPetPage.addAFavPet;

/**
 * The AddController class send input data to the backend after user performs action of liking a pet profile
 */
public class AddController {
    private final AddIB uci;

    /**
     * Construct an AddController object
     *
     * @param addAFavPetInputBoundary an usecase interactor for the addAFavPet useCase
     */
    public AddController(AddIB addAFavPetInputBoundary) {
        this.uci = addAFavPetInputBoundary;
    }

    /**
     * Call usecase interactor to perform usecase
     *
     * @param username an existing username
     * @param petId    an existing id of a public pet profile
     */
    public void execute(String username, int petId) {
        uci.execute(username, petId);
    }
}
