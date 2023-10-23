package Entity.GeoCoordinates;

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
    public double calculateDistanceBetweenAddress(String address1, String address2) throws IOException, InterruptedException, ApiException{
        return dcalculator.calculateDistance(finder.getAddressGeoCoordinate(address1), finder.getAddressGeoCoordinate(address2));
    }
    public void closeConnectionToGoogleMaps() throws IOException{
        finder.closeConnectionToGoogleMaps();
    }
}
