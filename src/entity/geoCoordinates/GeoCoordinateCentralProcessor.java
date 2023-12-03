package entity.geoCoordinates;

import com.google.maps.errors.ApiException;

import java.io.IOException;

public class GeoCoordinateCentralProcessor {
    private final GeoLocationFinder finder = new GeoLocationFinder();
    private final GeoCoordinatesCalculator dcalculator = new GeoCoordinatesCalculator();

    private GeoCoordinate getAddressGeoCoordinate(String address) throws IOException, InterruptedException, ApiException {
        return finder.getAddressGeoCoordinate(address);
    }
    private double  calculateDistance(GeoCoordinate g1, GeoCoordinate g2){
        return dcalculator.calculateDistance(g1,g2);
    }
    /**
     * Calculates the distance between two addresses using their geographical coordinates.
     *
     * @param address1 The first address.
     * @param address2 The second address.
     * @return The distance between the two addresses.
     * @throws IOException If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     * @throws ApiException If an error occurs while retrieving the coordinates from the GeoLocationFinder.
     */
    public double calculateDistanceBetweenAddress(String address1, String address2) throws IOException, InterruptedException, ApiException {
        return dcalculator.calculateDistance(
                finder.getAddressGeoCoordinate(address1),
                finder.getAddressGeoCoordinate(address2)
        );
    }

    /**
     * Closes the connection to Google Maps used by the GeoLocationFinder.
     *
     * @throws IOException If an I/O error occurs while closing the connection.
     */
    public void closeConnectionToGoogleMaps() throws IOException {
        finder.closeConnectionToGoogleMaps();
    }
}
