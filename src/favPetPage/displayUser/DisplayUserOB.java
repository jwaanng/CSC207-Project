package favPetPage.displayUser;

/**
 * This interface specifies required methods for a diplsayUser usecase presenter
 */
public interface DisplayUserOB {
    /***
     * a presenter of this usecase can tell the screen to display  a username and profile picture
     */

    void prepareSuccessView(DisplayUserOPData outputData);
}

