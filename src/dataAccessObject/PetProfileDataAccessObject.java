package dataAccessObject;

import entity.petProfile.DogProfile;
import entity.petProfile.PetProfile;
import entity.other.RuntimeTypeAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Implementation of the PetProfileDataAccessInterface for accessing and manipulating pet profile data.
 */
public class PetProfileDataAccessObject implements PetProfileDataAccessInterface {
    private final String add = "add";
    private final String update = "update";

    private final String collection = "petprofiles";
    private final String database = "207DataBase";
    private final String dataSource = "ClusterCSC207Pro";
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private final String apikey = "HIsUO9Tj20CJ8tURPbLMxlEBiFvqXwl0LFCenXsq2HWR0LAhhmdotFfqM2aLDSNp";
    private final HashMap<Integer, PetProfile> profiles = new HashMap<>();
    private final String baseURL = "https://us-east-2.aws.data.mongodb-api.com/app/data-xfyvk/endpoint/data/v1/action/";
    private final RuntimeTypeAdapterFactory<PetProfile> petProfileTypeAdapterFactory;

    /**
     * Constructor initializing the PetProfileDataAccessObject and loading existing profiles.
     */
    public PetProfileDataAccessObject() {
        petProfileTypeAdapterFactory = RuntimeTypeAdapterFactory.of(PetProfile.class, "specie", true).
                registerSubtype(DogProfile.class, DogProfile.SPECIE_NAME);
        ArrayList<PetProfile> petProfiles = retrieveAllProfiles();
        for (PetProfile profile : petProfiles) {
            profiles.put(profile.getId(), profile);
        }


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
                throw new IOException(String.valueOf(response.body().string()));
            }
            return response.body().string();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    private ArrayList<PetProfile> retrieveAllProfiles() {
        String profiles = new JSONObject(retrieveAll()).getJSONArray("documents").toString();
        Type listProfiles = new TypeToken<ArrayList<PetProfile>>() {
        }.getType();
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(petProfileTypeAdapterFactory).create();
        return gson.fromJson(profiles, listProfiles);
    }

    private String convertMongodMatchJsonFormat(PetProfile profile, String operation) {
        String profileStr = "";
        profileStr = new Gson().toJson(profile);


        JSONObject profileJson = new JSONObject(profileStr);
        JSONObject dataLoadingJson = new JSONObject();
        dataLoadingJson.put("collection", collection);
        dataLoadingJson.put("database", database);
        dataLoadingJson.put("dataSource", dataSource);
        if (operation.equals(add)) {
            dataLoadingJson.put("document", profileJson);
        } else if (operation.equals(update)) {
            JSONObject compFilt1 = new JSONObject();
            compFilt1.put("petId", profile.getId());
            dataLoadingJson.put("filter", compFilt1);
            JSONObject compUpda = new JSONObject();
            compUpda.put("$set", profileJson);
            dataLoadingJson.put("update", compUpda);

        }
        return dataLoadingJson.toString();


    }

    private String deleteconvertMongoMatchJsonFormat(int id) {
        JSONObject dataLoadingJson = new JSONObject();
        dataLoadingJson.put("collection", collection);
        dataLoadingJson.put("database", database);
        dataLoadingJson.put("dataSource", dataSource);
        JSONObject compFilt1 = new JSONObject();
        compFilt1.put("petId", id);
        dataLoadingJson.put("filter", compFilt1);
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

    /**
     * Adds a new pet profile to the data source.
     *
     * @param profile The PetProfile object representing the pet profile to be added.
     */
    @Override
    public void add(PetProfile profile) {
        if (exists(profile.getId())) { //calls on equals method
            throw new RuntimeException("The profile already exists");
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
            profiles.put(profile.getId(), profile);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Updates an existing pet profile in the data source.
     *
     * @param profile The PetProfile object representing the pet profile to be updated.
     */
    @Override
    public void update(PetProfile profile) {
        if (!exists(profile.getId())) {
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


        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Deletes an existing pet profile from the data source based on its unique identifier.
     *
     * @param id The unique identifier of the pet profile to be deleted.
     */
    @Override
    public void delete(int id) {
        if (!exists(id)) {
            throw new RuntimeException("Profile does not exists");
        }
        String json = deleteconvertMongoMatchJsonFormat(id);
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
            profiles.remove(id);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Checks the existence of a pet profile in the data source based on its unique identifier.
     *
     * @param id The unique identifier of the pet profile to be checked for existence.
     * @return true if the pet profile exists, false otherwise.
     */
    @Override
    public boolean exists(int id) {
        return profiles.containsKey(id);
    }


    /**
     * Gets the petprofile
     *
     * @param id The unique identifier of the pet profile to be checked for existence.
     * @return the profile, or null if none
     */
    @Override
    public PetProfile getProfile(int id) {
        return profiles.getOrDefault(id, null);
    }


}
