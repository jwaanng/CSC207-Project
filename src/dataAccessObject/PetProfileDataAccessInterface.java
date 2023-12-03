package dataAccessObject;

import entity.petProfile.PetProfile;

import java.util.List;

/**
 * Interface defining methods for accessing and manipulating pet profile data.
 */
public interface PetProfileDataAccessInterface {

    /**
     * Adds a new pet profile to the data source.
     *
     * @param profile The PetProfile object representing the pet profile to be added.
     */
    void add(PetProfile profile);

    /**
     * Updates an existing pet profile in the data source.
     *
     * @param profile The PetProfile object representing the pet profile to be updated.
     */
    void update(PetProfile profile);

    /**
     * Retrieves a pet profile from the data source based on its unique identifier.
     *
     * @param id The unique identifier of the pet profile to be retrieved.
     * @return The PetProfile object representing the retrieved pet profile.
     */
    PetProfile getProfile(int id);

    /**
     * Deletes an existing pet profile from the data source based on its unique identifier.
     *
     * @param id The unique identifier of the pet profile to be deleted.
     */
    void delete(int id);

    /**
     * Checks the existence of a pet profile in the data source based on its unique identifier.
     *
     * @param id The unique identifier of the pet profile to be checked for existence.
     * @return true if the pet profile exists, false otherwise.
     */
    boolean exists(int id);

    List<PetProfile> getAllProfiles();
}