package Entity.Comparator;

import Entity.PetProfiles.DogProfile;

import java.util.Comparator;

class DogProfileComparatorBySex implements Comparator<DogProfile>{
    private final char preferredSex;
    public DogProfileComparatorBySex(char preferredSex) {
        this.preferredSex = preferredSex;
    }
    @Override
    public int compare(DogProfile p1, DogProfile p2) {
        if (p1.getSex() == preferredSex && p2.getSex() != preferredSex) {
            return -1;
        } else if (p1.getSex() != preferredSex && p2.getSex() == preferredSex) {
            return 1;
        } else {
            return 0;
        }
    }

    public Comparator<DogProfile> thenComparing(Comparator<? super DogProfile> comparator) {
        return Comparator.comparing(DogProfile::getBreed).thenComparing(comparator);
    }
}
