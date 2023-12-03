package favPetPage.myFavPetPageRedirect;


/**
 * The FavPetRDRController class initiates the myFavPetPageRedirect usecase when user switch from other main pages into
 * the favorite pet page
 */
public class FavPetRDRController {
    private final FavPetRDRIB uci;

    /**
     * Construct an FavPetRDRController object
     *
     * @param favPetRDRInputBoundary an usecase interactor for the myFavPetPageRedirect useCase
     */
    public FavPetRDRController(FavPetRDRIB favPetRDRInputBoundary) {
        this.uci = favPetRDRInputBoundary;
    }

    public void execute() {
        uci.execute();
    }
}
