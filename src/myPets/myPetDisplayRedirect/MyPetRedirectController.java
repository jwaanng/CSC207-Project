package myPets.myPetDisplayRedirect;

public class MyPetRedirectController {
    private final MyPetRedirectIB uci;

    public MyPetRedirectController(MyPetRedirectIB redirectUseCaseInteractor) {
        this.uci = redirectUseCaseInteractor;
    }

    public void execute(){
        uci.execute();
    }
}
