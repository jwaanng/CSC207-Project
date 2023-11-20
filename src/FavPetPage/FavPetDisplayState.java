package FavPetPage;

import Login.LGOPData;

import java.util.HashMap;

public class FavPetDisplayState {

    private String username;
    //TODO must find a way to store all relevant information about a safe petprofile
    //Must include information includes the pet's photo and its name

    private HashMap<Integer, String> favPetID_Photo;
    private HashMap<Integer, String> favPetID_Name;


    //TODO decide if this is final or not, decide if the copy constructor is necessary
//    public FavPetDisplayState(FavPetDisplayState copy){
//        this.username = copy.username;
//        this.
//    }
    public FavPetDisplayState(LGOPData data){
        this.username = data.getUsername();
        this.favPetID_Photo = data.getPetID_to_Photo();
        this.favPetID_Name = data.getPetID_to_Name();

        }

    public FavPetDisplayState() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void addPetNameAndPhoto(int petId, String petName, String photoUrl){
        favPetID_Name.put(petId, petName);
        favPetID_Photo.put(petId, photoUrl);
    }
    public void deleletePetNameAndPhoto(int petId){
        favPetID_Name.remove(petId);
        favPetID_Photo.remove(petId);
    }

}
