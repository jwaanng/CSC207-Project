package browsePage.swipe.newcomparator;

import entity.petProfile.PetProfile;

import java.util.Comparator;

public class PetProfileComparator implements Comparator<PetProfile> {
    private final String idealSize;
//    private boolean idealVaccinated;
//    private final int idealAge;
    private final String idealSex;

    public PetProfileComparator(String idealSize, String idealSex) {
        this.idealSize = idealSize;
//        this.idealAge = idealAge;
        this.idealSex = idealSex;
    }
    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        Comparator<PetProfile> compositeComparator =
                new PetSizeComparator(idealSize)
//                .thenComparing(new PetAgeComparator(idealAge))
                .thenComparing(new PetSexComparator(idealSex));

        //geocoordinates comparator

        return compositeComparator.compare(p1, p2);
    }
}