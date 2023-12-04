package browsePage.swipePage.newcomparator;

import entity.petProfile.PetProfile;

import java.util.Comparator;

public class PetProfileComparator implements Comparator<PetProfile> {
    private String idealSize;
//    private boolean idealVaccinated;
    private int idealAge;
    private String idealSex;

    public PetProfileComparator(int idealAge, String idealSex) {
//        this.idealSize = idealSize;
        this.idealAge = idealAge;
        this.idealSex = idealSex;
    }

    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        Comparator<PetProfile> compositeComparator =
//                new PetSizeComparator(idealSize)
//                .thenComparing(new PetAgeComparator(idealAge))
//                .thenComparing(new PetSexComparator(idealSex));

                new PetAgeComparator(idealAge)
                .thenComparing(new PetSexComparator(idealSex));

        return compositeComparator.compare(p1, p2);
    }
}