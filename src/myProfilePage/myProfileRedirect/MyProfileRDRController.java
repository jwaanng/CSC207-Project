package myProfilePage.myProfileRedirect;

public class MyProfileRDRController {
    private final MyProfileRDRIB uci;

    public MyProfileRDRController(MyProfileRDRIB myProfileRDRIB) {
        this.uci = myProfileRDRIB;
    }
    public void execute(){
        uci.execute();
    }
}
