package entity.Comparator;

import entity.PetProfiles.DogProfile;

import java.util.Comparator;

class DogProfileComparatorByVaccined implements Comparator<DogProfile> {
    @Override
    public int compare(DogProfile p1, DogProfile p2) {
        if (p1 != null && p2 != null) {
            return Boolean.compare(p1.isVaccinated(), p2.isVaccinated());
        }
        return 0;
    }

    public Comparator<DogProfile> thenComparing(Comparator<? super DogProfile> comparator) {
        return Comparator.comparing(DogProfile::getBreed).thenComparing(comparator);
    }
}
