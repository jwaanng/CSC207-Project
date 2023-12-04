package browsePage.swipe.newcomparator;

import entity.petProfile.PetProfile;
import entity.user.AppUser;

import java.util.Comparator;

class PetSizeComparator implements Comparator<PetProfile> {
    private String idealSize;

    public PetSizeComparator(String idealSize) {
        this.idealSize = idealSize;
    }
    private int sizeToInt(String size) {
        // Handle the case where size is null or None, meaning no preference
        if (size == null || size.equalsIgnoreCase("None")) {
            return -1; // Return -1 or any other appropriate default value indicating no preference
        }

        switch (size) {
            case PetProfile.SMALLPET:
                return 1;
            case PetProfile.MEDIUMPET:
                return 2;
            case PetProfile.LARGEPET:
                return 3;
            default:
                // Handle unexpected size value
                throw new IllegalArgumentException("Invalid size value: " + size);
        }
    }
    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        int size1 = sizeToInt(p1.getSize());
        int size2 = sizeToInt(p2.getSize());
        int ideal = sizeToInt(this.idealSize);

        // If there is no ideal size, compare based on the actual sizes only
        if (ideal == -1) {
            return Integer.compare(size1, size2);
        }

        // If both pets are of the ideal size, they are equal in terms of this comparator
        if (size1 == ideal && size2 == ideal) {
            return 0;
        }

        // A pet of the ideal size is considered closer than one that is not
        else if (size1 == ideal) {
            return -1;
        } else if (size2 == ideal) {
            return 1;
        } else return 0;
    }

}
