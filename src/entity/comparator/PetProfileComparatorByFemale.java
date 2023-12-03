package entity.comparator;

import entity.petProfile.PetProfile;

import java.util.Comparator;

public class PetProfileComparatorByFemale implements Comparator<PetProfile> {

    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        if (p1.getSex().equals(PetProfile.FEMALE) && !(p2.getSex().equals(PetProfile.FEMALE))) {
            return -1;
        } else if (!(p1.getSex().equals(PetProfile.FEMALE)) && p2.getSex().equals(PetProfile.FEMALE)){
            return 1;
        } else {
            return 0;
        }

    }
}
