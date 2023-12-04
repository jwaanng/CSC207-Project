package myPets.createRedirect;

public class CreateRedirectController {
    private final createRedirecIB uci;

    public CreateRedirectController(createRedirecIB redirectUseCaseInteractor) {
        this.uci = redirectUseCaseInteractor;
    }

    public void execute(){
        uci.execute();
    }
}
