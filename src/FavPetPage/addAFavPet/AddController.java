package FavPetPage.addAFavPet;

public class AddController {
    private final AddIB uci;

    public AddController(AddIB addAFavPetUseCaseInteractor) {
        this.uci =addAFavPetUseCaseInteractor;
    }
    public void execute(String username, int petId){
        uci.execute(username, petId);
    }
}
