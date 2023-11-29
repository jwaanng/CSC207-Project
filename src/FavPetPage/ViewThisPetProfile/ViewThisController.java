package FavPetPage.ViewThisPetProfile;

public class ViewThisController {
    private ViewThisIB uci;

    public ViewThisController(ViewThisIB viewThisPetProfileUseCaseInteractor) {
        this.uci = viewThisPetProfileUseCaseInteractor;
    }

    public void execute(int petId){
        uci.execute(petId);
    }

}
