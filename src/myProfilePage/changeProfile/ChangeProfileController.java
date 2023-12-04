package myProfilePage.changeProfile;

import java.io.File;

public class ChangeProfileController {
    private final ChangeProfileIB uci;

    public ChangeProfileController(ChangeProfileIB uci) {
        this.uci = uci;
    }
    public void execute(String name, File newProfile){
        uci.execute(new ChangeProfileIPData(name, newProfile));
    }
}
