package entity.petProfile;

import entity.user.AppUser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class IDTracker {
    private final String collection = "petIDTracker";

    private int nextid;
    private final String database = "207DataBase";
    private final String dataSource = "ClusterCSC207Pro";
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private final String apikey = "HIsUO9Tj20CJ8tURPbLMxlEBiFvqXwl0LFCenXsq2HWR0LAhhmdotFfqM2aLDSNp";
    private final String baseURL = "https://us-east-2.aws.data.mongodb-api.com/app/data-xfyvk/endpoint/data/v1/action/";


    IDTracker() {
        JSONObject dataLoadingJson = new JSONObject();
        JSONObject compFilt = new JSONObject();
        compFilt.put("value", "nextPetId");
        dataLoadingJson.put("collection", collection);
        dataLoadingJson.put("database", database);
        dataLoadingJson.put("dataSource", dataSource);
        dataLoadingJson.put("filter", compFilt);
        JSONObject compProj = new JSONObject();
        compProj.put("value", 0);
        compProj.put("_id", 0);

        dataLoadingJson.put("projection", compProj);
        RequestBody body = RequestBody.create(dataLoadingJson.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().
                url(baseURL + "findOne")
                .addHeader("api-key", apikey)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException(response.body().string());
            } else {
                JSONObject document = new JSONObject(response.body().string());
                nextid = (int) ((JSONObject) document.get("document")).get("nextId");
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());

        }

    }

    int getNextAvailableID(){
        JSONObject dataLoadingJson = new JSONObject();
        JSONObject compFilt = new JSONObject();
        compFilt.put("value", "nextPetId");
        dataLoadingJson.put("collection", collection);
        dataLoadingJson.put("database", database);
        dataLoadingJson.put("dataSource", dataSource);
        dataLoadingJson.put("filter", compFilt);
        JSONObject compUpdate = new JSONObject("{\"$inc\": {\n" +
               "\"nextId\": 1 }}");
        dataLoadingJson.put("update", compUpdate);
        RequestBody body = RequestBody.create(dataLoadingJson.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().
                url(baseURL + "updateOne")
                .addHeader("api-key", apikey)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException(response.body().string());
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        int currid = nextid;
        nextid++;
        return currid;
    }

}
