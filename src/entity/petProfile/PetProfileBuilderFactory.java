package entity.petProfile;

/**
 * The PetProfileBuilderFactory class is responsible for creating instances of pet profile builders.
 */
public class PetProfileBuilderFactory {
    /*Must be valid system registered*/
    IDTracker idGenerator = new IDTracker();

    /**
     * Creates a DogProfileBuilder instance for building dog profiles.
     *
     * @param petOwnerName The name of the pet owner.
     * @return A DogProfileBuilder instance.
     */
    public DogProfileBuilder createDogProfile(String petOwnerName) {
        return new DogProfileBuilder(petOwnerName, idGenerator.getNextAvailableID());
    }
}
