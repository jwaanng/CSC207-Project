package entity.geoCoordinates;

/**
 * The GeoCoordinatesCalculator class provides methods for calculating distances between geographical coordinates.
 */
public class GeoCoordinatesCalculator {
    private final double EARTHR = 6371;

    /**
     * Calculates the distance between two geographical coordinates using the Haversine formula.
     *
     * @param g1 The first GeoCoordinate.
     * @param g2 The second GeoCoordinate.
     * @return The distance between the two coordinates in kilometers.
     */
    public double calculateDistance(GeoCoordinate g1, GeoCoordinate g2) {
        double dLat = Math.toRadians(g1.lat - g2.lat);
        double dLng = Math.toRadians(g1.lng - g2.lng);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(g1.lat)) *
                Math.cos(Math.toRadians(g2.lat)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
        return EARTHR * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }
}
