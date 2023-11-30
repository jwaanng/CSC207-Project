package SwipePage;

public class SwipePageViewModel {
    private String displayName;
    private String displaySize;
    private String displayPhotoUrl;

    public SwipePageViewModel(String displayName, String displaySize, String displayPhotoUrl) {
        this.displayName = displayName;
        this.displaySize = displaySize;
        this.displayPhotoUrl = displayPhotoUrl;
    }

    // Getters
    public String getDisplayName() { return displayName; }
    public String getDisplaySize() { return displaySize; }
    public String getDisplayPhotoUrl() { return displayPhotoUrl; }
}
