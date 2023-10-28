package usecase.ChangeMyPetProfilePublicStatus;

import Entity.PetProfiles.PetProfile;

public interface DataAccessInterface {
    PetProfile retrieve();
    void save(PetProfile profile);
}
