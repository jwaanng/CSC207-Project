package myPets.deleteMyPet;

import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;

public class DeleteMyPetUCI implements DeleteMyPetIB {
    private PetProfileDataAccessInterface daop;
    private DeleteMyPetOB presenter;
    private ProfilePictureDataAccessInterface daoPic;

    public DeleteMyPetUCI(PetProfileDataAccessInterface petProfileDataAccessObject, DeleteMyPetOB deleteFavoritePetPresenter) {
        this.daop = petProfileDataAccessObject;
        this.presenter = deleteFavoritePetPresenter;
    }

    @Override
    public void execute(DeleteMyPetData inputData) {
        //precondition, inputData must contain a petID that is indeed a petId of the user's saved pet profile
        String username = inputData.username;
        int petId = inputData.id;
        System.out.println(petId);
        daop.delete(petId);
        presenter.prepareSuccessView(petId);
    }
}
