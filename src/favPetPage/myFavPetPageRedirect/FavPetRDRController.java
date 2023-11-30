package favPetPage.myFavPetPageRedirect;

public class FavPetRDRController {
    private final FavPetRDRIB uci;

    public FavPetRDRController(FavPetRDRIB redirectUseCaseInteractor) {
        this.uci = redirectUseCaseInteractor;
    }

    public void execute(){
        uci.execute();
    }
}
