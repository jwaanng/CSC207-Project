package Entity.GeoCoordinates;

import Entity.GeoCoordinates.GeoCoordinate;

public class GeoCoordinatesCalculator {
    private final double EARTHR = 6371;
    public double calculateDistance(GeoCoordinate g1, GeoCoordinate g2){
        double dLat = Math.toRadians(g1.lat- g2.lat);
        double dLng = Math.toRadians(g1.lng - g2.lng);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(g1.lat)) *
                Math.cos(Math.toRadians(g2.lat)) * Math.sin(dLng/2) * Math.sin(dLng/2);
        return EARTHR * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    }
}
