package Entity.Comparator;

import Entity.PetProfiles.DogProfile;

import java.util.Comparator;

class ProfileComparatorByGeoCoord implements Comparator<DogProfile> {
    double latitude;
    double longitude;

    public ProfileComparatorByGeoCoord(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int compare(DogProfile p1, DogProfile p2) {
        return 0;
    }

    public Comparator<DogProfile> thenComparing(Comparator<? super DogProfile> comparator) {
        return null;
    }

    // Define the distance method and other necessary methods here
}
