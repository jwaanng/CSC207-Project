package myPets.updateMyPet;

public class UpdateMyPetsController {
    private final UpdateMyPetsIB uci;

    public UpdateMyPetsController(UpdateMyPetsIB updateUseCaseInteractor) {
        this.uci = updateUseCaseInteractor;
    }
    public void execute(int petId){
        uci.execute(petId);
    }
}
