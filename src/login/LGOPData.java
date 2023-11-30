package login;

import java.util.HashMap;

public class LGOPData {
    String username;
    String profileURL;
    boolean usecaseFailed;

    private final HashMap<Integer, String> petID_to_Name = new HashMap<>();
    private final HashMap<Integer, String> petID_to_Photo = new HashMap<>();
    String error;

    public LGOPData(LGOPData copy){
        this.username = copy.username;
        this.profileURL = copy.profileURL;
        this.error = copy.error;
        this.usecaseFailed = copy.usecaseFailed;
    }
    public LGOPData(){}

    public static LGOPData createSuccessData(String username, String profileURL)
    {
        LGOPData data = new LGOPData();
        data.profileURL = profileURL;
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
