package DataAcessObject;

import Entity.PetProfiles.DogProfile;
import Entity.PetProfiles.PetProfile;
import Entity.User.AppUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import static Entity.Constants.DOG;
import static Entity.Constants.get;

public class PetProfileDataAccessObject implements PetProfileDataAccessInterface{
    private final String add = "add";
    private final String update = "update";

    private final String collection = "petprofiles";
    private final String database = "207DataBase";
    private final String dataSource = "ClusterCSC207Pro";
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private final String apikey = "HIsUO9Tj20CJ8tURPbLMxlEBiFvqXwl0LFCenXsq2HWR0LAhhmdotFfqM2aLDSNp";
    private final ArrayList<PetProfile> profiles = new ArrayList<>();

    private final String baseURL = "https://us-east-2.aws.data.mongodb-api.com/app/data-xfyvk/endpoint/data/v1/action/";
    public PetProfileDataAccessObject(){
        ArrayList<PetProfile> petProfiles = retrieveAllProfiles();
        profiles.addAll(petProfiles);
    }
    //Helper
    private String retrieveAll() {
        String json = getAllconvertMongoMatchJsonFormat();
        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().
                url(baseURL + "find")
                .addHeader("api-key", apikey)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException(String.valueOf(response));
            }
            return response.body().string();
        } catch (IOException e) {
            return e.getMessage();
        }

    }
    private ArrayList<PetProfile> retrieveAllProfiles(){
        String profiles = new JSONObject(retrieveAll()).getJSONArray("documents").toString();
        Type listProfiles = new TypeToken<ArrayList<? extends PetProfile>>(){}.getType();
        Gson gson = new Gson();
        return gson.fromJson(profiles, listProfiles);
    }

    private String convertMongodMatchJsonFormat(PetProfile profile, String operation) {
        String profileStr = "";
        if (profile.getSpecie().equals(DOG)){
            profileStr = new Gson().toJson((DogProfile)profile);
        }

        JSONObject profileJson = new JSONObject(profileStr);
        JSONObject dataLoadingJson = new JSONObject();
        dataLoadingJson.put("collection", collection);
        dataLoadingJson.put("database", database);
        dataLoadingJson.put("dataSource", dataSource);
        if (operation.equals(add)) {
            dataLoadingJson.put("document", profileJson);
        } else if (operation.equals(update)) {
            JSONObject compFilt1 = new JSONObject();
            compFilt1.put("petOwnerName", profile.getPetOwnerName());
            JSONObject compFilt2 = new JSONObject();
            compFilt2.put("name", profile.getName());
            JSONObject compFilt3 = new JSONObject();
            compFilt3.put("specie", profile.getSpecie());
            JSONArray filters = new JSONArray();
            filters.put(compFilt1);
            filters.put(compFilt2);
            filters.put(compFilt3);
            dataLoadingJson.put("filter", filters);
            JSONObject compUpda = new JSONObject();
            compUpda.put("$set", profileJson);
            dataLoadingJson.put("update", compUpda);

        }
        return dataLoadingJson.toString();


    }

    private String deleteconvertMongoMatchJsonFormat(String name, String petOwnerName, String specie) {
        JSONObject dataLoadingJson = new JSONObject();
        dataLoadingJson.put("collection", collection);
        dataLoadingJson.put("database", database);
        dataLoadingJson.put("dataSource", dataSource);
        JSONObject compFilt1 = new JSONObject();
        compFilt1.put("petOwnerName", petOwnerName);
        JSONObject compFilt2 = new JSONObject();
        compFilt2.put("name", name);
        JSONObject compFilt3 = new JSONObject();
        compFilt3.put("specie", specie);
        JSONArray filters = new JSONArray();
        filters.put(compFilt1);
        filters.put(compFilt2);
        filters.put(compFilt3);
        dataLoadingJson.put("filter", filters);
        return dataLoadingJson.toString();
    }

    private String getAllconvertMongoMatchJsonFormat() {
        JSONObject dataLoadingJson = new JSONObject();
        dataLoadingJson.put("collection", collection);
        dataLoadingJson.put("database", database);
        dataLoadingJson.put("dataSource", dataSource);
        dataLoadingJson.put("filter", JSONObject.NULL);
        JSONObject compProj = new JSONObject();
        compProj.put("_id", 0);
        dataLoadingJson.put("projection", compProj);
        return dataLoadingJson.toString();
    }
    @Override
    public void add(PetProfile profile) {
        if (profiles.contains(profile)){ //calls on equals method
            throw new RuntimeException("Petprofile already exists");
        }
        String json = convertMongodMatchJsonFormat(profile, add);
        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(baseURL + "insertOne")
                .addHeader("Content-Type", "application/json")
                .addHeader("api-key", apikey)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("API call fail for reason" + response.body().string());
            }
            profiles.add(profile);
        }
        catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(PetProfile profile){
        if(!profiles.contains(profile)){
            throw new RuntimeException("Profile does not exists");

        }
        String json = convertMongodMatchJsonFormat(profile, update);
        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(baseURL + "updateOne")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("api-key", apikey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("API call fail for reason" + response.body().string());
            }


        }
        catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(String name, String petOwnerName , String specie) {
        PetProfile profile = getProfile(name,petOwnerName,specie);
        if(profile == null){
            throw new RuntimeException("PetProfile does not exists");
        }
        String json = deleteconvertMongoMatchJsonFormat(name,petOwnerName,specie);
        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(baseURL + "deleteOne")
                .addHeader("api-key", apikey)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("API call fail for reason" + response.body().string());
            }
           profiles.remove(profile);
        }
        catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public PetProfile getProfile(String name, String petOwnerName , String specie) {
        for (PetProfile profile : profiles){
            if (profile.getName().equals(name) && profile.getPetOwnerName().equals(petOwnerName)
                    && profile.getSpecie().equals(specie)){
                return profile;
            }

        }
        return null;

    }


}
