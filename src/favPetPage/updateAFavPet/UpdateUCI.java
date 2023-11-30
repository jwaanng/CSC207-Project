package favPetPage.updateAFavPet;

import dataAcessObject.PetProfileDataAccessObject;
import entity.petProfile.PetProfile;

public class UpdateUCI implements UpdateIB{
    private final UpdateOB presenter;
    private final PetProfileDataAccessObject daop;

    public UpdateUCI(UpdateOB updatePresenter, PetProfileDataAccessObject petProfileDataAccessObject) {
        this.presenter = updatePresenter;
        this.daop = petProfileDataAccessObject;
    }

    @Override
    public void execute(int petId) {
        PetProfile pet = daop.getProfile(petId);
        UpdateOPData outputData = new UpdateOPData();
        outputData.petName = pet.getName();
        outputData.petPhotoUrl = pet.getPetPhotoLink();
        outputData.petId = pet.getId();
        presenter.prepareSuccessView(outputData);
    }
}
