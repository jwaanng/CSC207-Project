package usecase.ChangeMyPetProfilePublicStatus;

import entity.petProfile.PetProfile;

public interface DataAccessInterface {
    PetProfile retrieve();
    void save(PetProfile profile);
}
