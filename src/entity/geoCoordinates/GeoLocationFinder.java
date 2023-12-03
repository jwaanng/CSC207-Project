package entity.geoCoordinates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

/**
 * The GeoLocationFinder class provides methods for interacting with Google Maps API to retrieve geographical coordinates.
 */
public class GeoLocationFinder {

    /**
     * The GeoApiContext instance for interacting with the Google Maps API.
     */
    private final GeoApiContext context = new GeoApiContext.Builder().apiKey("...").build();

    /**
     * Closes the connection to Google Maps API.
     *
     * @throws IOException If an I/O error occurs while closing the connection.
     */
    public void closeConnectionToGoogleMaps() throws IOException {
        context.close();
    }

    /**
     * Retrieves the geographical coordinates (latitude and longitude) for a given address using the Google Maps API.
     *
     * @param address The address for which to retrieve the geographical coordinates.
     * @return A GeoCoordinate object representing the latitude and longitude of the given address.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     * @throws ApiException         If an error occurs while retrieving the coordinates from the Google Maps API.
     */
    public GeoCoordinate getAddressGeoCoordinate(String address) throws IOException, InterruptedException, ApiException {
        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String geoCordsGson = gson.toJson(results[0].geometry.location);
        GeoCoordinate geoCords = gson.fromJson(geoCordsGson, GeoCoordinate.class);
        context.shutdown();
        return geoCords;
    }
}