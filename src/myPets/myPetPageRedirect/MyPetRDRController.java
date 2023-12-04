package myPets.myPetPageRedirect;

public class MyPetRDRController {
    private final MyPetRDRIB uci;

    public MyPetRDRController(MyPetRDRIB redirectUseCaseInteractor) {
        this.uci = redirectUseCaseInteractor;
    }

    public void execute(){
        uci.execute();
    }
}
