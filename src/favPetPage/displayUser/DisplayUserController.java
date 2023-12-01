package favPetPage.displayUser;

import java.awt.*;

/**
 * The DisplayUserController class send input data to the backend to complete the initialization of the fav pet page
 * after a user logins or to update a user's profile picture
 */

public class DisplayUserController {
    private final DisplayUserIB uci;

    /**
     * Construct an DisplayUserController
     *
     * @param displayUserInputBoundary an usecase interactor for the displayUser useCase
     */
    public DisplayUserController(DisplayUserIB displayUserInputBoundary) {
        this.uci = displayUserInputBoundary;
    }

    /**
     * Call usecase interactor to perform usecase
     *
     * @param username an existing username
     */
    public void execute(String username) {
        uci.execute(username);
    }
}
