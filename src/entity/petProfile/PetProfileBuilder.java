package entity.petProfile;

/**
 * The PetProfileBuilder class is an abstract builder class for constructing PetProfile objects.
 *
 * @param <T> The type of the concrete builder extending PetProfileBuilder.
 * @param <P> The type of the PetProfile that the builder constructs.
 */
public abstract class PetProfileBuilder<T extends PetProfileBuilder<T, P>, P extends PetProfile> {

    /**
     * The name of the pet.
     */
    String name;

    /**
     * The age of the pet.
     */
    int age;

    /**
     * The id of the pet.
     */
    final int petid;

    /**
     * The sex of the pet.
     */
    String sex;

    /**
     * The species of the pet.
     */
    String specie;

    /**
     * The size category of the pet.
     */
    String size;

    /**
     * The name of the pet owner.
     */
    final String petOwnerName;

    /**
     * The likes description of the pet.
     */
    String likeDescr;

    /**
     * The temperament description of the pet.
     */
    String temperDescr;

    /**
     * The general description of the pet.
     */
    String generalDescr;

    /**
     * Constructs a PetProfileBuilder with the specified pet owner's name.
     *
     * @param petOwnerName    The name of the pet owner.
     * @param nextAvailableId the next available id
     */
    PetProfileBuilder(String petOwnerName, int nextAvailableId) {
        this.petOwnerName = petOwnerName;
        this.petid = nextAvailableId;
    }

    /**
     * Builds a PetProfile object based on the provided information.
     *
     * @return A PetProfile object.
     */
    public abstract P build();

    /**
     * Returns the instance of the concrete builder for method chaining.
     *
     * @return The instance of the concrete builder.
     */
    private T self() {
        return (T) this;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name The name of the pet.
     * @return The concrete builder instance for method chaining.
     */
    public T withName(String name) {
        this.name = name;
        return self();
    }

    /**
     * Sets the size category of the pet to large.
     *
     * @return The concrete builder instance for method chaining.
     */
    public T isLargePet() {
        /*valid size char letter */
        this.size = PetProfile.LARGEPET;
        return self();
    }

    /**
     * Sets the size category of the pet to medium.
     *
     * @return The concrete builder instance for method chaining.
     */
    public T isMediumPet() {
        this.size = PetProfile.MEDIUMPET;
        return self();
    }

    /**
     * Sets the size category of the pet to small.
     *
     * @return The concrete builder instance for method chaining.
     */
    public T isSmallPet() {
        /*valid size char letter */
        this.size = PetProfile.SMALLPET;
        return self();
    }

    /**
     * Sets the age of the pet.
     *
     * @param age The age of the pet.
     * @return The concrete builder instance for method chaining.
     */
    public T withAge(int age) {
        this.age = age;
        return self();
    }

    /**
     * Sets the sex of the pet to male.
     *
     * @return The concrete builder instance for method chaining.
     */
    public T isMale() {
        /*valid sex char only*/
        this.sex = PetProfile.MALE;
        return self();
    }

    /**
     * Sets the sex of the pet to female.
     *
     * @return The concrete builder instance for method chaining.
     */
    public T isFemale() {
        this.sex = PetProfile.FEMALE;
        return self();
    }

    /**
     * Sets the temperament description of the pet.
     *
     * @param descr The temperament description of the pet.
     * @return The concrete builder instance for method chaining.
     */
    public T withTemperDescr(String descr) {
        this.temperDescr = descr;
        return self();
    }

    /**
     * Sets the likes description of the pet.
     *
     * @param descr The likes description of the pet.
     * @return The concrete builder instance for method chaining.
     */
    public T withLikedDescr(String descr) {
        this.likeDescr = descr;
        return self();
    }

    /**
     * Sets the general description of the pet.
     *
     * @param descr The general description of the pet.
     * @return The concrete builder instance for method chaining.
     */
    public T withGeneralDescr(String descr) {
        this.generalDescr = descr;
        return self();
    }
}