package Entity.PetProfiles;
import static Entity.Constants.DOG;

public class PetProfileBuilderFactory{
    /*Must be valid system registered*/
    public DogProfileBuilder createDogProfile(String petOwnerName) {
        return new DogProfileBuilder(petOwnerName);
    }

}
