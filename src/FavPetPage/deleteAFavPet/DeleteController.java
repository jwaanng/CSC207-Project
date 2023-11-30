package favPetPage.deleteAFavPet;

public class DeleteController {
    private DeleteIB uci;

    public DeleteController(DeleteIB deleteAFavoritePetUsecaseInteractor) {
        this.uci = deleteAFavoritePetUsecaseInteractor;
    }
    public void execute(String username, int petId){
        uci.execute(new DeleteData(username,petId));
    }
}
