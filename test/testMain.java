package Entity;

import Entity.GeoCoordinates.GeoCoordinate;
import Entity.GeoCoordinates.GeoCoordinatesCalculator;
import Entity.GeoCoordinates.GeoLocationFinder;
import Entity.Constants;
import com.google.maps.errors.ApiException;
import Entity.PetProfiles.*;

import java.io.IOException;
import java.util.ArrayList;

import static Entity.Constants.MALE;

public class testMain {
    public static void main(String[] args) throws IOException, InterruptedException, ApiException {

        //GEOLOCATIONPACKAGE TEST
        GeoLocationFinder finder = new GeoLocationFinder();
        System.out.println(finder.getAddressGeoCoordinate("197 Yonge St, Toronto, ON M5B 0C1"));
        finder.closeConnectionToGoogleMaps();
        GeoCoordinatesCalculator calculator = new GeoCoordinatesCalculator();
        System.out.println(calculator.calculateDistance(new GeoCoordinate(40.123124,-23.123123), new GeoCoordinate(23.213213,31.021321)));
        //PETPROFILEGENERATION TEST
        PetProfileBuilderFactory factory = new PetProfileBuilderFactory();
        DogProfile katie =  factory.createDogProfile("Michael").withName("Kookie").withBreed("golden retriever").withAge(10).withSex(MALE).build();
        System.out.println(katie);
        DogProfile cookie = factory.createDogProfile("Ming").withBreed("labarodo").build();
        System.out.println(cookie);



    }


}
