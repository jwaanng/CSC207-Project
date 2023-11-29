package FavPetPage.updateAFavPet;

public class UpdateController {
    private final UpdateIB uci;

    public UpdateController(UpdateIB updateUseCaseInteractor) {
        this.uci = updateUseCaseInteractor;
    }
    public void execute(int petId){
        uci.execute(petId);
    }
}
