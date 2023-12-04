package myPets.updateMyPet;

import dataAccessObject.PetProfileDataAccessObject;
import dataAccessObject.ProfilePictureDataAccessInterface;
import entity.petProfile.PetProfile;

public class UpdateMyPetsUCI implements UpdateMyPetsIB {
    private final UpdateMyPetsOB presenter;
    private final PetProfileDataAccessObject daop;
    private final ProfilePictureDataAccessInterface daoPic;

    public UpdateMyPetsUCI(UpdateMyPetsOB updatePresenter, PetProfileDataAccessObject petProfileDataAccessObject, ProfilePictureDataAccessInterface profilePictureDataAccessObject) {
        this.presenter = updatePresenter;
        this.daop = petProfileDataAccessObject;
        this.daoPic = profilePictureDataAccessObject;
    }

    @Override
    public void execute(int petId) {
        PetProfile pet = daop.getProfile(petId);
        UpdateMyPetsOPData outputData = new UpdateMyPetsOPData();
        outputData.petName = pet.getName();
        outputData.photo = daoPic.retrievePetProfile(petId);
        outputData.petId = pet.getId();
        presenter.prepareSuccessView(outputData);
    }
}
