package Login;

import Entity.User.AppUser;

import java.util.HashMap;

public class LGOPData {
    private String username;
    private boolean usecaseFailed;

    private final HashMap<String, String> petName_to_photo = new HashMap<>();
    private String error;
    //TODO need to contain all relevant for petProfile display
    public String getUsername() {
        return username;
    }

    public boolean isUsecaseFailed() {
        return usecaseFailed;
    }

    public String getError() {
        return error;
    }

    public LGOPData(LGOPData copy){
        this.username = copy.username;
        this.error = copy.error;
        this.usecaseFailed = copy.usecaseFailed;
    }
    public LGOPData(){}

    public static LGOPData createSuccessData(String username)
    {
        LGOPData data = new LGOPData();
        data.username = username;
        return data;
    }
    public static LGOPData createFailData(String error){
        LGOPData data = new LGOPData();
        data.error = error;
        data.usecaseFailed = true;
        return data;
    }
    public void addPetPHOTO(String petName, String photoUrl){
         petName_to_photo.put(petName, photoUrl);
    }
    public HashMap<String, String> getPetNames_Photos_Map(){
        return new HashMap<String, String>(petName_to_photo);
    }
}
