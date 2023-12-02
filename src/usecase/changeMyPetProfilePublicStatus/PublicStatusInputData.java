package usecase.changeMyPetProfilePublicStatus;

import entity.petProfile.PetProfile;

/**
 * Represents the input data for changing the public status of a pet profile.
 */
public class PublicStatusInputData {

    /** The desired public status: true for public, false for private. */
    private final boolean status;

    /** The pet profile for which the public status is being changed. */
    private final PetProfile petProfile;

    /**
     * Constructs a new {@code PublicStatusInputData} instance.
     *
     * @param status      The desired public status: {@code true} for public, {@code false} for private.
     * @param petProfile  The pet profile for which the public status is being changed.
     */
    public PublicStatusInputData(boolean status, PetProfile petProfile) {
        this.status = status;
        this.petProfile = petProfile;
    }

    /**
     * Gets the desired public status.
     *
     * @return {@code true} if the pet profile should be made public, {@code false} if it should be made private.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Gets the pet profile for which the public status is being changed.
     *
     * @return The pet profile.
     */
    public PetProfile getPf() {
        return petProfile;
    }
}