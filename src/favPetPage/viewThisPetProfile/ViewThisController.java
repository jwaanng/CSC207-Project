package favPetPage.viewThisPetProfile;

public class ViewThisController {
    /**
     * The ViewThisController class send input data to the backend after user performs action of clicking on a liked
     * pet profile
     */
    private ViewThisIB uci;

    /**
     * Construct an AddController
     *
     * @param viewThisInputBoundary an usecase interactor for viewThisPetProfile useCase
     */
    public ViewThisController(ViewThisIB viewThisInputBoundary) {
        this.uci = viewThisInputBoundary;
    }

    /**
     * Call usecase interactor to perform usecase
     *
     * @param petId an existing id of a public pet profile that is liked by the user
     */
    public void execute(int petId) {
        uci.execute(petId);
    }

}
