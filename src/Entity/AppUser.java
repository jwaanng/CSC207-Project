package Entity;

import java.util.List;

public class AppUser {
    private String username;
    private final int id;
    private String bio;
    private String password;

    private List<PetProfile> pet;
    private boolean isOwner = false;

    public AppUser(String username, int id, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void SetToPetOwner() {
        isOwner = true;
    }

    public boolean getOwnerStatus() {
        return isOwner;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}