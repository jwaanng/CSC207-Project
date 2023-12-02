package entity.petProfile;

public class PetProfileBuilderFactory{
    /*Must be valid system registered*/

    IDTracker idGenerator = new IDTracker();
    public DogProfileBuilder createDogProfile(String petOwnerName) {
        return new DogProfileBuilder(petOwnerName,idGenerator.getNextAvailableID());
    }

}
