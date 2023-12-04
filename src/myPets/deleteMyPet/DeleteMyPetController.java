package myPets.deleteMyPet;

public class DeleteMyPetController {
    private DeleteMyPetIB uci;

    public DeleteMyPetController(DeleteMyPetIB deleteMyPetUsecaseInteractor) {
        this.uci = deleteMyPetUsecaseInteractor;
    }
    public void execute(String username, int petId){
        uci.execute(new DeleteMyPetData(username,petId));
    }
}
