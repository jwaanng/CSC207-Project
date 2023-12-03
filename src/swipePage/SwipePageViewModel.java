package swipePage;

/**
 * The {@code SwipePageViewModel} class represents the view model for displaying pet profiles in a swipe page.
 */
public class SwipePageViewModel {

    private final String displayName;
    private final String displayBio;
    private final String displayPhotoUrl;

    /**
     * Constructs a {@code SwipePageViewModel} with the specified display name, bio, and photo URL.
     *
     * @param displayName      The name to be displayed.
     * @param displayBio       The bio to be displayed.
     * @param displayPhotoUrl  The URL of the photo to be displayed.
     */
    public SwipePageViewModel(String displayName, String displayBio, String displayPhotoUrl) {
        this.displayName = displayName;
        this.displayBio = displayBio;
        this.displayPhotoUrl = displayPhotoUrl;
    }

    /**
     * Gets the display name.
     *
     * @return The display name.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets the display bio.
     *
     * @return The display bio.
     */
    public String getDisplayBio() {
        return displayBio;
    }

    /**
     * Gets the display photo URL.
     *
     * @return The display photo URL.
     */
    public String getDisplayPhotoUrl() {
        return displayPhotoUrl;
    }
}