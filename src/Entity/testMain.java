package Entity;

import Entity.GeoCoordinates.GeoCoordinate;
import Entity.GeoCoordinates.GeoCoordinatesCalculator;
import Entity.GeoCoordinates.GeoLocationFinder;
import com.google.maps.errors.ApiException;

import java.io.IOException;

public class testMain {
    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        GeoLocationFinder finder = new GeoLocationFinder();
        System.out.println(finder.getAddressGeoCoordinate("197 Yonge St, Toronto, ON M5B 0C1"));
        finder.closeConnectionToGoogleMaps();
        GeoCoordinatesCalculator calculator = new GeoCoordinatesCalculator();
        System.out.println(calculator.calculateDistance(new GeoCoordinate(40.123124,-23.123123), new GeoCoordinate(23.213213,31.021321)));
    }
}
