package favPetPage.displayUser;

public class DisplayUserController {
    private final DisplayUserIB uci;

    public DisplayUserController(DisplayUserIB displayUserUseCaseInteractor) {
        this.uci = displayUserUseCaseInteractor;
    }

    void execute(String name, String profilePhotoUrl){
        uci.execute(name, profilePhotoUrl);
    }
}
