package SwipePage;

public class SwipePageViewModel {
    private String displayName;
    private String displaySize;
    private String displayPhotos;

    public SwipePageViewModel(String displayName, String displaySize, String displayPhotos) {
        this.displayName = displayName;
        this.displaySize = displaySize;
        this.displayPhotos = displayPhotos;
    }

    // Getters
    public String getDisplayName() { return displayName; }
    public String getDisplaySize() { return displaySize; }
    public String getDisplayPhotos() { return displayPhotos; }
}
