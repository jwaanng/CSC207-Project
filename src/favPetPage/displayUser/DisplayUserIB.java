package favPetPage.displayUser;

import java.awt.*;

/**
 * This interface specifies required methods for a displayUser usecase interactor
 */
public interface DisplayUserIB {
    /***
     * an interactor of this usecase can execute to display a user's username and profile picture
     */
    void execute(String username);
}
