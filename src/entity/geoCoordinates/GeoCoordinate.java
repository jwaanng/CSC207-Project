package entity.geoCoordinates;


/**
 * The GeoCoordinate class represents a geographical coordinate point with latitude and longitude values.
 */
public class GeoCoordinate {

    /**
     * The latitude of the GeoCoordinate.
     */
    double lat;

    /**
     * The longitude of the GeoCoordinate.
     */
    double lng;

    /**
     * Constructs a new GeoCoordinate with default latitude and longitude values (0.0, 0.0).
     */
    public GeoCoordinate(){}

    /**
     * Constructs a new GeoCoordinate with the specified latitude and longitude.
     *
     * @param lat The latitude of the GeoCoordinate.
     * @param lng The longitude of the GeoCoordinate.
     */
    public GeoCoordinate(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Returns a string representation of the GeoCoordinate.
     *
     * @return A string containing the latitude and longitude values.
     */
    @Override
    public String toString() {
        return "latitude: " + lat + "\nlongitude: " + lng;
    }
}