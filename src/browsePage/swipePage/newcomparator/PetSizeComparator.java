package browsePage.swipePage.newcomparator;

import entity.petProfile.PetProfile;

import java.util.Comparator;

class PetSizeComparator implements Comparator<PetProfile> {
    private String idealSize;

    public PetSizeComparator(String idealSize) {
        this.idealSize = idealSize;
    }

    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        return Integer.compare(sizeToInt(p1.getSize()), sizeToInt(p2.getSize()));
    }

    private int sizeToInt(String size) {
        switch (size) {
            case "Small": return 1;
            case "Medium": return 2;
            case "Large": return 3;
            default: return 0; // default case
        }
    }
}
