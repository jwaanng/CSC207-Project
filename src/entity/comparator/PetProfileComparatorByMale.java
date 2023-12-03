package entity.comparator;

import entity.petProfile.PetProfile;

import java.util.Comparator;

class PetProfileComparatorByMale implements Comparator<PetProfile>{


    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        if (p1.getSex() == PetProfile.MALE && p2.getSex() != PetProfile.MALE) {
            return -1;
        } else if (p1.getSex() != PetProfile.MALE && p2.getSex() == PetProfile.MALE) {
            return 1;
        } else {
            return 0;
        }
    }


//    public Comparator<DogProfile> thenComparing(Comparator<? super DogProfile> comparator) {
//        return Comparator.comparing(DogProfile::getBreed).thenComparing(comparator);
//    }
}
