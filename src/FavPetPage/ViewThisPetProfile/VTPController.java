package FavPetPage.ViewThisPetProfile;

public class VTPController {
    private VTPIB uci;

    public VTPController(VTPIB viewThisPetProfileUseCaseInteractor) {
        this.uci = viewThisPetProfileUseCaseInteractor;
    }

    public void execute(int petId){
        uci.execute(petId);
    }

}
