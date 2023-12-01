package favPetPage.updateAFavPet;

/**
 * The UpdateController class send input data to the backend after a petowner performs the action of editing a
 * pet profile's pet name and pet profile photo
 */
public class UpdateController {
    private final UpdateIB uci;

    /**
     * Construct an UpdateController
     *
     * @param updateInputBoundaryt an usecase interactor for the updateAFavPet useCase
     */
    public UpdateController(UpdateIB updateInputBoundaryt) {
        this.uci = updateInputBoundaryt;
    }

    /**
     * Call usecase interactor to perform usecase
     *
     * @param petId an existing id of a public pet profile liked by the user
     */
    public void execute(int petId) {
        uci.execute(petId);
    }
}
