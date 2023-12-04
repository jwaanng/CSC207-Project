package swipePage.newcomparator;

import entity.petProfile.DogProfile;

import java.util.Comparator;
class DogVaccinatedComparator implements Comparator<DogProfile> {
    private boolean idealVaccinated;

    public DogVaccinatedComparator(boolean idealVaccinated) {
        this.idealVaccinated = idealVaccinated;
    }

    @Override
    public int compare(DogProfile p1, DogProfile p2) {
        return Boolean.compare(p1.isVaccinated() == idealVaccinated,
                p2.isVaccinated() == idealVaccinated);
    }
}
