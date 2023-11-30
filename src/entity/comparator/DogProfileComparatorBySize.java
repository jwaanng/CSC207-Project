package entity.comparator;

import entity.petProfile.DogProfile;

import java.util.Comparator;

class DogProfileComparatorBySize implements Comparator<DogProfile> {
    @Override
    public int compare(DogProfile p1, DogProfile p2) {

        return Character.compare(p1.getSize(), p2.getSize());
    }
    public Comparator<DogProfile> thenComparing(Comparator<? super DogProfile> comparator) {
        return Comparator.comparing(DogProfile::getBreed).thenComparing(comparator);
    }
}
