package favPetPage.deleteAFavPet;

public class DFPController {

    private DFPIB uci;

    public DFPController(DFPIB deleteAFavoritePetUsecaseInteractor) {
        this.uci = deleteAFavoritePetUsecaseInteractor;
    }

    public void execute(String username, int petId){
        uci.execute(new DFPIPData(username,petId));
    }
}
