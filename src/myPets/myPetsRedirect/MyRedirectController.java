package myPets.myPetsRedirect;

public class MyRedirectController {
    private final MyRedirectIB uci;

    public MyRedirectController(MyRedirectIB redirectUseCaseInteractor) {
        this.uci = redirectUseCaseInteractor;
    }

    public void execute(){
        uci.execute();
    }
}
