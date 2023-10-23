import com.google.maps.GeoApiContext;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search?format=json&limit=10")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String responsebody = response.body().string();
        System.out.println(responsebody);
    }


}
