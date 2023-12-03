package entity.comparator;

import entity.petProfile.DogProfile;

import java.util.Comparator;

class DogProfileComparatorByVaccined implements Comparator<DogProfile> {
    @Override
    public int compare(DogProfile p1, DogProfile p2) {
            return Boolean.compare(p2.isVaccinated(), p1.isVaccinated() );
        //order matters
    }

//    public Comparator<DogProfile> thenComparing(Comparator<? super DogProfile> comparator) {
//        return Comparator.comparing(DogProfile::getBreed).thenComparing(comparator);
//    }
}
