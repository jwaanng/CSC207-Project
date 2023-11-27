package entity.Comparator;

import entity.PetProfiles.DogProfile;

import java.util.Comparator;

class DogProfileComparatorByAge implements Comparator<DogProfile> {
    @Override
    public int compare(DogProfile p1, DogProfile p2)
    {
        return 0;
    }

    public Comparator<DogProfile> thenComparing(Comparator<? super DogProfile> comparator) {
        return null;
    }
}
