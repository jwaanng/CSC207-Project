package bePetOwner;

/**
 * Controller class for the Be Pet Owner (BPO) feature.
 *
 * This class acts as a controller in the Model-View-Controller (MVC) compoent of CA] for the
 * Be Pet Owner feature. It interacts with the corresponding interactor (BPOIB) to execute
 * the necessary actions based on user input.
 */
public class BPOController {

    /**
     * The interactor responsible for handling the business logic associated with the Be Pet Owner feature.
     */
    final BPOIB interactor;

    /**
     * Constructor for the BPOController class.
     *
     * @param interactor The interactor associated with this controller.
     */
    BPOController(BPOIB interactor){
        this.interactor = interactor;
    }

    /**
     * Executes the Be Pet Owner feature.
     *
     * This method delegates the execution of the Be Pet Owner feature to the associated interactor,
     * passing the provided username as a parameter.
     *
     * @param username The username of the user initiating the Be Pet Owner feature.
     */
    public void execute(String username){
        interactor.execute(username);
    }
}
