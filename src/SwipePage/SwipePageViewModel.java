package SwipePage;

public class SwipePageViewModel {
    private String displayName;
    private String displayBio;
    private String displayPhotoUrl;

    public SwipePageViewModel(String displayName, String displayBio, String displayPhotoUrl) {
        this.displayName = displayName;
        this.displayBio = displayBio;
        this.displayPhotoUrl = displayPhotoUrl;
    }

    // Getters
    public String getDisplayName() { return displayName; }
    public String getDisplayBio() { return displayBio; }
    public String getDisplayPhotoUrl() { return displayPhotoUrl; }
}
