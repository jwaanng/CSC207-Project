package entity.petProfile;

import java.util.HashMap;

public class DogProfile extends PetProfile {
    public static final String SPECIE_NAME = "dog";
   private boolean neuter;
   private boolean vaccinated;
   private String breed;
  public DogProfile(DogProfileBuilder builder){
      super(builder);
      this.neuter = builder.neuter;
      this.vaccinated = builder.vaccinated;
      this.breed = builder.breed;
  }
    public boolean isNeuter() {
        return neuter;
    }

    public void setNeuter(boolean neuter) {
        this.neuter = neuter;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccineStatus(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public HashMap<String, String>  getDisplayAdditionalInformation(){
        HashMap<String, String> uniqueInfo = new HashMap<>();
            uniqueInfo.put("Breed", breed);
            uniqueInfo.put("Sterilized", String.valueOf(neuter));
            uniqueInfo.put("Vaccinated", String.valueOf(vaccinated));
        return uniqueInfo;
    }
}
