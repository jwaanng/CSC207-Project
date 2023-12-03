package entity;

import entity.geoCoordinates.GeoCoordinate;
import entity.geoCoordinates.GeoCoordinatesCalculator;
import entity.geoCoordinates.GeoLocationFinder;
import com.google.maps.errors.ApiException;
import entity.petProfile.*;

import java.io.IOException;

//import static entity.Constants.MALE;

public class testMain {

    private static String MALE = "male";
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
