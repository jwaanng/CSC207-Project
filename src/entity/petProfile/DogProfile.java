package entity.petProfile;

import java.util.HashMap;

/**
 * The DogProfile class represents a profile for a dog, extending the PetProfile class.
 */
public class DogProfile extends PetProfile {
    public static final String SPECIE_NAME = "dog";
    private boolean neuter;
    private boolean vaccinated;
    private String breed;

    /**
     * Constructs a DogProfile object using the DogProfileBuilder.
     *
     * @param builder The builder used to construct the DogProfile.
     */
  public DogProfile(DogProfileBuilder builder){
      super(builder);
      this.neuter = builder.neuter;
      this.vaccinated = builder.vaccinated;
      this.breed = builder.breed;
  }
    public boolean isNeuter() {
        return neuter;
    }

    /**
     * Sets the neuter status of the dog.
     *
     * @param neuter True if the dog is neutered, false otherwise.
     */
    public void setNeuter(boolean neuter) {
        this.neuter = neuter;
    }

    /**
     * Checks if the dog is vaccinated.
     *
     * @return True if the dog is vaccinated, false otherwise.
     */
    public boolean isVaccinated() {
        return vaccinated;
    }

    /**
     * Sets the vaccination status of the dog.
     *
     * @param vaccinated True if the dog is vaccinated, false otherwise.
     */
    public void setVaccineStatus(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    /**
     * Gets the breed of the dog.
     *
     * @return The breed of the dog.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the breed of the dog.
     *
     * @param breed The breed of the dog.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Returns additional information specific to the dog for display purposes.
     *
     * @return A HashMap containing additional information about the dog.
     */
    @Override
    public HashMap<String, String> getDisplayAdditionalInformation() {
        HashMap<String, String> uniqueInfo = new HashMap<>();
        uniqueInfo.put("Breed", breed);
        uniqueInfo.put("Sterilized", String.valueOf(neuter));
        uniqueInfo.put("Vaccinated", String.valueOf(vaccinated));
        return uniqueInfo;
    }
}