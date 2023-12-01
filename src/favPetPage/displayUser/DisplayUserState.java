package favPetPage.displayUser;

import java.awt.*;

/**
 * This class stores the information on user that needs to can be seen by from the screen
 */
public class DisplayUserState {
    private String username = "";
    private Image photo = null;

    /**
     * Construct a DisplayUserState give a copy
     *
     * @param copy DisplayUserState copy
     */
    public DisplayUserState(DisplayUserState copy) {
        this.username = copy.username;
        this.photo = copy.photo;
    }

    /**
     * Construct an empty DeleteState
     */
    public DisplayUserState() {
    }

    /**
     * Get the user's username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Stores the user's username
     *
     * @param username the username of the user
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user's profile picture
     *
     * @return user's profile image
     */
    public Image getPhoto() {
        return photo;
    }

    /**
     * Stores the user's profile image
     *
     * @param photo user's profile image
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
