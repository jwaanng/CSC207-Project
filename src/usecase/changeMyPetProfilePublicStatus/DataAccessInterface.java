package usecase.changeMyPetProfilePublicStatus;

import entity.petProfile.PetProfile;

/**
 * The {@code DataAccessInterface} defines methods for retrieving and saving pet profiles.
 */
public interface DataAccessInterface {

    /**
     * Retrieves a pet profile.
     *
     * @return The retrieved pet profile.
     */
    PetProfile retrievePetProfile();

    /**
     * Saves a pet profile.
     *
     * @param profile The pet profile to be saved.
     */
    void savePetProfile(PetProfile profile);
}