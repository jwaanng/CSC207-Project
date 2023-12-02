package entity.petProfile;


/**
 * The PetProfileBuilderFactory class is responsible for creating instances of pet profile builders.
 */
public class PetProfileBuilderFactory {

    /**
     * Creates a DogProfileBuilder instance for building dog profiles.
     *
     * @param petOwnerName The name of the pet owner.
     * @return A DogProfileBuilder instance.
     */
    public DogProfileBuilder createDogProfile(String petOwnerName) {
        return new DogProfileBuilder(petOwnerName);
    }
}
