package signupPage.cancel;

/**
 * CancelController sends input data to the backend after existing user performs the action of pressing the cancel
 * button at signup page to go back to login page
 * */
public class CancelController {
    private final CancelIB uci;
    /**
     * Initiates a CancelController
     * @param cancelInputBoundary the usecase interactor for the cancel usecse
     * */
    public CancelController(CancelIB cancelInputBoundary){
        this.uci = cancelInputBoundary;
    }
    /**
     * Tells backend that user want to go back to login page
     * */
    public void execute(){
        uci.execute();
    }
}
