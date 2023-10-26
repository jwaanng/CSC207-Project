package Entity.GeoCoordinates;

import Entity.GeoCoordinates.GeoCoordinate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

public class GeoLocationFinder {
    private final GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBnRlmF3KqbWJ9BPh3DMbiKxa_ugVx17tA").build();

    public void closeConnectionToGoogleMaps() throws IOException {
        context.close();
    }

    public GeoCoordinate getAddressGeoCoordinate(String address) throws IOException, InterruptedException, ApiException {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String geoCordsGson = gson.toJson(results[0].geometry.location);
            //System.out.println(geoCordsGson);
            GeoCoordinate geoCords= gson.fromJson(geoCordsGson, GeoCoordinate.class);
            context.shutdown();
            return geoCords;


    }
}
