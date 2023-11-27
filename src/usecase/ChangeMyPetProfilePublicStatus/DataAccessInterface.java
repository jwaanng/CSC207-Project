package usecase.ChangeMyPetProfilePublicStatus;

import entity.PetProfiles.PetProfile;

public interface DataAccessInterface {
    PetProfile retrieve();
    void save(PetProfile profile);
}
