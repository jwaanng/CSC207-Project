package Entity.GeoCoordinates;

public class GeoCoordinate {

    double lat;
    double lng;


    public GeoCoordinate(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }
    @Override
    public String toString() {
        return "latitude: " + lat + "\nlongitude: " + lng;
    }
}
