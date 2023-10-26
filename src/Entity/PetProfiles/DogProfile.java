package Entity.PetProfiles;

public class DogProfile extends PetProfile {
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
    public String toString() {
        return "bark!, my name is " + getName() + ". I am a " + getSex() + " " + getBreed() + " hiahiahia! I am " + getAge() + " old!";
    }
//    @Override
//    public
}
