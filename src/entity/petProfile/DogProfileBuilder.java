package entity.petProfile;

/**
 * The DogProfileBuilder class is responsible for building DogProfile objects.
 */
public class DogProfileBuilder extends PetProfileBuilder<DogProfileBuilder, DogProfile> {

    /**
     * Indicates whether the dog is neutered.
     */
    boolean neuter;

    /**
     * Indicates whether the dog is vaccinated.
     */
    boolean vaccinated;

    /**
     * The breed of the dog.
     */
    String breed;

    /**
     * Constructs a DogProfileBuilder with the specified pet owner's name.
     *
     * @param petOwnerName The name of the pet owner.
     */
    public DogProfileBuilder(String petOwnerName) {
        super(petOwnerName);
        this.specie = DogProfile.specieName;
    }

    /**
     * Builds a DogProfile object based on the provided information.
     *
     * @return A DogProfile object.
     */
    @Override
    public DogProfile build() {
        return new DogProfile(this);
    }

    /**
     * Sets the breed of the dog.
     *
     * @param breed The breed of the dog.
     * @return The DogProfileBuilder instance for method chaining.
     */
    public DogProfileBuilder withBreed(String breed) {
        this.breed = breed;
        return this;
    }

    /**
     * Sets the sex of the dog.
     *
     * @param sex The sex of the dog.
     * @return The DogProfileBuilder instance for method chaining.
     */
    public DogProfileBuilder withSex(String sex) {
        this.sex = sex;
        return this;
    }

    /**
     * Sets the vaccination status of the dog.
     *
     * @param vaccinated True if the dog is vaccinated, false otherwise.
     * @return The DogProfileBuilder instance for method chaining.
     */
    public DogProfileBuilder vaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
        return this;
    }

    /**
     * Sets the neuter status of the dog.
     *
     * @param neuter True if the dog is neutered, false otherwise.
     * @return The DogProfileBuilder instance for method chaining.
     */
    public DogProfileBuilder neutered(boolean neuter) {
        this.neuter = neuter;
        return this;
    }
}