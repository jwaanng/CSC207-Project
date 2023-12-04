package myProfilePage.changeProfile;

import java.awt.*;

public interface ChangeProfileOB {
    void prepareFailView(String error);
    void prepareSuccessView(Image newProfile);
}
