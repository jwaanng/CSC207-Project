package myProfilePage.myProfileRedirect;

public class MyProfileRDRUCI implements MyProfileRDRIB{


    private final MyProfileRDROB presenter;
    public MyProfileRDRUCI(MyProfileRDROB myProfileRDROB) {

    this.presenter = myProfileRDROB;



    }

    @Override
    public void execute() {
       presenter.prepareSuccessView();
    }
}
