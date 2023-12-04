package browsePage.swipePage.newcomparator;

import entity.petProfile.PetProfile;

import java.util.Comparator;

class PetAgeComparator implements Comparator<PetProfile> {
    private int idealAge;

    public PetAgeComparator(int idealAge) {
        this.idealAge = idealAge;
    }

    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        return Integer.compare(Math.abs(p1.getAge() - idealAge),
                Math.abs(p2.getAge() - idealAge));
    }
}