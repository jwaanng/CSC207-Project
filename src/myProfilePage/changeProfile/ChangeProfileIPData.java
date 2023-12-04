package myProfilePage.changeProfile;

import java.io.File;

public class ChangeProfileIPData {
    String username;
    File photofile;

    ChangeProfileIPData(String username, File photofile){
        this.photofile = photofile;
        this.username = username;
    }
}
