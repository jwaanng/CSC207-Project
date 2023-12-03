package login;

import java.awt.*;
import java.util.HashMap;

public class LoginOPData {
    String username;
    Image profile;
    boolean usecaseFailed;

    private final HashMap<Integer, String> petID_to_Name = new HashMap<>();
    private final HashMap<Integer, Image> petID_to_Photo = new HashMap<>();
    String error;

    public LoginOPData(LoginOPData copy){
        this.username = copy.username;
        this.profile = copy.profile;
        this.error = copy.error;
        this.usecaseFailed = copy.usecaseFailed;
    }
    public LoginOPData(){}

    public static LoginOPData createSuccessData(String username, Image profile)
    {
        LoginOPData data = new LoginOPData();
        data.profile = profile;
        data.username = username;
        return data;
    }
    public static LoginOPData createFailData(String error){
        LoginOPData data = new LoginOPData();
        data.error = error;
        data.usecaseFailed = true;
        return data;
    }
    public void addPetNameAndPHOTO(int petId, String petName, Image photo){
         petID_to_Name.put(petId, petName);
         petID_to_Photo.put(petId,photo);

    }
    public HashMap<Integer, Image> getPetID_to_Photo(){
        return new HashMap<Integer, Image>(petID_to_Photo);
    }
    public HashMap<Integer, String> getPetID_to_Name(){
        return new HashMap<Integer, String>(petID_to_Name);
    }
}
