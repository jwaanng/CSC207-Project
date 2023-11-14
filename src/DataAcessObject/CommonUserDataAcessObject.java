package DataAcessObject;

import Entity.User.AppUser;
import Entity.User.AppUserFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static Entity.Constants.*;

public class CommonUserDataAcessObject implements UserDataAcessInterface{
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private final String apikey = "';

    private final String baseURL = "https://us-east-2.aws.data.mongodb-api.com/app/data-xfyvk/endpoint/data/v1/action/";

    //Helper
    private String convertMongodMatchJsonFormat(AppUser user, String operation) {

            String userJsonStr = new Gson().toJson(user);
            JSONObject userJson = new JSONObject(userJsonStr);
            JSONObject dataLoadingJson = new JSONObject();
            dataLoadingJson.put("collection", "users");
            dataLoadingJson.put("database", "207DataBase");
            dataLoadingJson.put("dataSource", "ClusterCSC207Pro");
            if (operation.equals(add)) {
                dataLoadingJson.put("document", userJson);
            }
            else if (operation.equals(update)){
                JSONObject compFilt = new JSONObject();
                compFilt.put("username", user.getUsername());
                dataLoadingJson.put("filter", compFilt );
                JSONObject compUpda = new JSONObject();
                compUpda.put("$set", userJson);
                dataLoadingJson.put("update", compUpda);

            }
            return dataLoadingJson.toString();


    }
    private String convertMongoMatchJsonFormat(String username, String operation){
        JSONObject dataLoadingJson = new JSONObject();
        dataLoadingJson.put("collection", "users");
        dataLoadingJson.put("database", "207DataBase");
        dataLoadingJson.put("dataSource", "ClusterCSC207Pro");
        JSONObject compFilt = new JSONObject();
        compFilt.put("username", username);
        dataLoadingJson.put("filter", compFilt);

        if (operation.equals(delete)) {
            return dataLoadingJson.toString();
        }
        else if (operation.equals(get)){
            JSONObject compProj = new JSONObject();
            compProj.put("_id", 0);
            dataLoadingJson.put("projection", compProj );

        }
        return dataLoadingJson.toString();
    }
    @Override
    public String add(AppUser user) {
       String json = convertMongodMatchJsonFormat(user, add);
       RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
       Request request = new Request.Builder()
               .url(baseURL + "insertOne")
               .addHeader("Content-Type", "application/json")
               .addHeader("api-key", apikey)
               .post(body)
               .build();
    try(Response response = client.newCall(request).execute()){
        if(!response.isSuccessful()){
            System.out.println(response.body().string());
            throw new IOException(String.valueOf(response));
        }
        return success;
    }
    catch (IOException e){
        return e.getMessage();
    }
    }

    @Override
    public String update(AppUser user) {
        String json = convertMongodMatchJsonFormat(user, update);
        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(baseURL + "updateOne")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("api-key", apikey)
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                throw new IOException(String.valueOf(response.code()));
            }
            return success;
        }
        catch (IOException e)
        {
            return e.getMessage();
        }
    }

    @Override
    public String delete(String username) {
        /*Precondition username does exist*/
        String json = convertMongoMatchJsonFormat(username, delete);
        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(baseURL + "deleteOne")
                .addHeader("api-key", apikey)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                throw new IOException(String.valueOf(response.code()));
            }
            return success;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private String retrieveJsonUser(String username){
        /*Precondition username does exist*/
        String json = convertMongoMatchJsonFormat(username, get);
        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().
                url(baseURL + "findOne")
                .addHeader("api-key", apikey)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                throw new IOException(String.valueOf(response));
            }
            return response.body().string();
        }
        catch (IOException e){
            return e.getMessage();
        }

    }
    @Override
    public AppUser retrieve(String username) {
        Gson gson = new Gson();
        String json = retrieveJsonUser(username);
        JsonObject document = JsonParser.parseString(json).getAsJsonObject();
        JsonObject appUser = document.getAsJsonObject("document");
        if (appUser.isJsonNull()){
            return null;
        }

        else {;
            return gson.fromJson(appUser,AppUser.class);
        }


    }
    public static void main(String[] args) throws IOException {
        AppUser user = new AppUserFactory().createAppUser("Michael", "102325", "108 King Street");
        CommonUserDataAcessObject dao = new CommonUserDataAcessObject();
        user.setBio("I love golden retrievers!");
        String json = dao.convertMongodMatchJsonFormat(user, "update");
        System.out.println(json);
        AppUser user2 = new AppUserFactory().createAppUser("Jordan", "102325424", "108 King Street");
        System.out.println(dao.retrieve("Michael").getAddress());
        //String message = dao.update(user);

    }

//    curl -s "https://us-east-2.aws.data.mongodb-api.com/app/data-xfyvk/endpoint/data/v1/action/updateOne" \
//            -X POST \
//            -H "apiKey: HIsUO9Tj20CJ8tURPbLMxlEBiFvqXwl0LFCenXsq2HWR0LAhhmdotFfqM2aLDSNp" \
//            -H 'Content-Type: application/ejson' \
//            -H "Accept: application/json" \
//            -d '{
//            "dataSource": "ClusterCSC207Pro",
//            "database": "207DataBase",
//            "collection": "users",
//            "filter": {
//        "username": { "$eq": "Michael" }
//    },
//            "update": {
//        "$set": {
//            "bio": "I love dogs",
//                    }
//        }
//    }
}
