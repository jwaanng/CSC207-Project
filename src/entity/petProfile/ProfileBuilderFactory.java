package entity.petProfile;


import entity.other.IDTracker;

public interface ProfileBuilderFactory {

    /*Must be valid system registered*/
    DogProfileBuilder createDogProfile(String petOwnerName);
}
