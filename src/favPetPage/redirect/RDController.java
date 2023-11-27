package favPetPage.redirect;

public class RDController {
    private final RDIB uci;

    public RDController(RDIB redirectUseCaseInteractor) {
        this.uci = redirectUseCaseInteractor;
    }

    public void execute(String ToBeRedirectedViewName){
        uci.execute(new RDIPData(ToBeRedirectedViewName));
    }
}
