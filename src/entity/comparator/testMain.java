package entity.comparator;

import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.PetProfileDataAccessObject;
import entity.petProfile.PetProfile;

import java.util.Comparator;
import java.util.List;

public class testMain {
    public static void main(String[] args) {
        PetProfileDataAccessInterface daop = new PetProfileDataAccessObject();
        List<PetProfile> profiles = daop.getAllProfiles();
        Comparator<PetProfile> petProfileFemale = new PetProfileComparatorByFemale();
        Comparator<PetProfile> petProfileAge = new PetProfileComparatorByAge(1);
        profiles.sort(petProfileAge.thenComparing(petProfileFemale));
        for (PetProfile profile : profiles)
            System.out.println(profile);
        }
}

