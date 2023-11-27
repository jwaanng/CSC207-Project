package favPetPage.displayUser;

public class DisplayUserState {
    private String username = "";
    private String profilePhotoUrl ="";
    public DisplayUserState(DisplayUserState copy){
        this.username = copy.username;
        this.profilePhotoUrl = copy.profilePhotoUrl;
    }
    public DisplayUserState() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
