package entity.petProfile;

import java.util.HashMap;

/**
 * The PetProfile class represents a profile for a pet, providing basic information and behavior.
 */
public abstract class PetProfile {
    public static final String MALE = "Male";
    private String str;

    /**
     * Identifier for female pets.
     */
    public static final String FEMALE = "Female";

    /**
     * Identifier for large-sized pets.
     */
    public static final String LARGEPET = "Large";

    /**
     * Identifier for medium-sized pets.
     */
    public static final String MEDIUMPET = "Medium";

    /**
     * Identifier for small-sized pets.
     */
    public static final String SMALLPET = "Small";


    /**
     * The unique identifier for the pet.
     */
    private int petId;

    /**
     * The name of the pet.
     */
    private String name;

    /**
     * The age of the pet.
     */
    private int age;

    /**
     * The sex of the pet.
     */
    private String sex;

    /**
     * The species of the pet.
     */
    private final String specie;

    /**
     * The size category of the pet.
     */
    private String size;

    /**
     * The name of the pet owner.
     */
    private final String petOwnerName;

    /**
     * The general description of the pet.
     */
    private String generalDescr;

    /**
     * The likes description of the pet.
     */
    private String likeDescr;

    /**
     * The temperament description of the pet.
     */
    private String temperDescr;

    /**
     * Indicates whether the pet's profile is public.
     */
    private boolean isPublic;

    /**
     * Constructs a PetProfile object using a builder.
     *
     * @param builder The builder used to construct the PetProfile.
     */
    protected PetProfile(PetProfileBuilder<? extends PetProfileBuilder<?, ?>, ? extends PetProfile> builder) {

        this.petId = builder.petid;
        this.petOwnerName = builder.petOwnerName;
        this.age = builder.age;
        this.name = builder.name;
        this.sex = builder.sex;
        this.size = builder.size;
        this.specie = builder.specie;
        this.isPublic = false;
        this.likeDescr = builder.likeDescr;
        this.temperDescr = builder.temperDescr;
        this.generalDescr = builder.generalDescr;
    }

    //==================================GETTERS, SETTERS======================================

    /**
     * Gets the species of the pet.
     *
     * @return The species of the pet.
     */
    public String getSpecie() {
        return specie;
    }

    /**
     * Gets the name of the pet owner.
     *
     * @return The name of the pet owner.
     */
    public String getPetOwnerName() {
        return petOwnerName;
    }

    /**
     * Gets the name of the pet.
     *
     * @return The name of the pet.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name The new name of the pet.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the pet.
     *
     * @return The age of the pet.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the pet.
     *
     * @param age The new age of the pet.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the sex of the pet.
     *
     * @return The sex of the pet.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the sex of the pet to female.
     */
    public void setFemale() {
        this.sex = FEMALE;
    }

    /**
     * Sets the sex of the pet to male.
     */
    public void setMale() {
        this.sex = MALE;
    }

    /**
     * Gets the size category of the pet.
     *
     * @return The size category of the pet.
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size category of the pet to medium.
     */
    public void setMediumSize() {
        this.size = MEDIUMPET;
    }

    /**
     * Sets the size category of the pet to large.
     */
    public void setLargeSize() {
        this.size = LARGEPET;
    }

    /**
     * Sets the size category of the pet to small.
     */
    public void setSmallSize() {
        this.size = SMALLPET;
    }

    /**
     * Placeholder method for deleting a photo of the pet.
     *
     * @param photo The photo to be deleted.
     */
    public void deletedPhoto(String photo) {
        // Implementation details would go here.
    }

    /**
     * Gets the likes description of the pet.
     *
     * @return The likes description of the pet.
     */
    public String getLikeDescr() {
        return likeDescr;
    }

    /**
     * Sets the likes description of the pet.
     *
     * @param likeDescr The new likes description of the pet.
     */
    public void setLikeDescr(String likeDescr) {
        this.likeDescr = likeDescr;
    }

    /**
     * Gets the temperament description of the pet.
     *
     * @return The temperament description of the pet.
     */
    public String getTemperDescr() {
        return temperDescr;
    }

    /**
     * Sets the temperament description of the pet.
     *
     * @param temperDescr The new temperament description of the pet.
     */
    public void setTemperDescr(String temperDescr) {
        this.temperDescr = temperDescr;
    }

    /**
     * Gets the public status of the pet's profile.
     *
     * @return True if the profile is public, false otherwise.
     */
    public boolean getPublicStatus() {
        return isPublic;
    }

    /**
     * Sets the profile as public.
     */
    public void setProfilePublic() {
        isPublic = true;
    }

    /**
     * Sets the profile as private.
     */
    public void setProfilePrivate() {
        isPublic = false;
    }

    /**
     * Gets the general description of the pet.
     *
     * @return The general description of the pet.
     */
    public String getGeneralDescr() {
        return generalDescr;
    }

    /**
     * Sets the general description of the pet.
     *
     * @param generalDescr The new general description of the pet.
     */
    public void setGeneralDescr(String generalDescr) {
        this.generalDescr = generalDescr;
    }

    /**
     * Gets the unique identifier for the pet.
     *
     * @return The unique identifier for the pet.
     */
    public int getId() {
        return petId;
    }


    /**
     * Gets additional information specific to the pet for display purposes.
     *
     * @return A HashMap containing additional information about the pet.
     */
    public abstract HashMap<String, String> getDisplayAdditionalInformation();
}