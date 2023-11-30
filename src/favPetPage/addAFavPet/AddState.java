package favPetPage.addAFavPet;

import login.LGOPData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddState {


    //Must include information includes the pet's photo and its name
    private HashMap<Integer, String> favPetID_Photo = new HashMap<>();
    private HashMap<Integer, String> favPetID_Name = new HashMap<>();
    public AddState(LGOPData data){
        this.favPetID_Photo = data.getPetID_to_Photo();
        this.favPetID_Name = data.getPetID_to_Name();
        }

    public AddState() {
    }
    public void addPetNameAndPhoto(int petId, String petName, String photoUrl){
        favPetID_Name.put(petId, petName);
        favPetID_Photo.put(petId, photoUrl);
    }
    public String getName(int petId){
        return favPetID_Name.get(petId);
    }
    public String getPhoto(int petId){ return favPetID_Photo.get(petId);}
    public List<Integer> getKeyEntries(){
        return new ArrayList<Integer>(favPetID_Name.keySet());
    }

}
