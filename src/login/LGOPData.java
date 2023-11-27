package login;

import java.util.HashMap;

public class LGOPData {
    private String username;
    private boolean usecaseFailed;

    private final HashMap<Integer, String> petID_to_Name = new HashMap<>();
    private final HashMap<Integer, String> petID_to_Photo = new HashMap<>();
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
    public void addPetNameAndPHOTO(int petId, String petName, String photoUrl){
         petID_to_Name.put(petId, petName);
         petID_to_Photo.put(petId,photoUrl);
    }
    public HashMap<Integer, String> getPetID_to_Photo(){
        return new HashMap<Integer, String>(petID_to_Photo);
    }
    public HashMap<Integer, String> getPetID_to_Name(){
        return new HashMap<Integer, String>(petID_to_Name);
    }
}
