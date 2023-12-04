package myProfilePage.changeProfile;

import java.awt.*;

public class ChangeProfileState {
    private Image image;
    private String error = "";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
