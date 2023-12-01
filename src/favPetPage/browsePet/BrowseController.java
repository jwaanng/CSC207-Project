package favPetPage.browsePet;

/**
 * The BrowseController class send input data to the backend after a user with no liked pets  performs
 * clicks to desire to browse some pets
 */
public class BrowseController {
    private final BrowseIB uci;

    /**
     * Construct a BrowseController
     *
     * @param browsePetInputBoundary an usecase interactor for the browsePet usecase
     */
    public BrowseController(BrowseIB browsePetInputBoundary) {
        uci = browsePetInputBoundary;
    }

    /**
     * Call usecase interactor to perform usecase
     */
    public void execute() {
        uci.execute();
    }
}
