package entity.petProfile;

/**
 * The ProfileBuilderFactory interface declares methods for creating instances of pet profile builders.
 */
public interface ProfileBuilderFactory {

    /**
     * Creates a DogProfileBuilder instance for building dog profiles.
     *
     * @param petOwnerName The name of the pet owner.
     * @return A DogProfileBuilder instance.
     */
    DogProfileBuilder createDogProfile(String petOwnerName);
}