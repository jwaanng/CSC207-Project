package swipePage;

import java.awt.*;
public class SwipePageViewModel {
    private String displayName;
    private String displayBio;
    private Image displayPhoto;

    public SwipePageViewModel(String displayName, String displayBio, Image displayPhoto) {
        this.displayName = displayName;
        this.displayBio = displayBio;
        this.displayPhoto = displayPhoto;
    }

    // Getters
    public String getDisplayName() {
        return displayName;
    }
    public String getDisplayBio() {
        return displayBio;
    }
    public Image getDisplayPhoto() {
        return displayPhoto;
    }
}
