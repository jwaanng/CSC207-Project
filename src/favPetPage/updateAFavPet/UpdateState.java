package favPetPage.updateAFavPet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateState {

    //Must include information includes the pet's photo and its name
    private HashMap<Integer, String> petId_Photo = new HashMap<>();
    private HashMap<Integer, String> petId_Name = new HashMap<>();

    public UpdateState(UpdateState copy){
        petId_Photo = copy.petId_Photo;
        petId_Name = copy.petId_Name;
    }
    public UpdateState() {}

    public void addPetNameAndPhoto(int petId, String petName, String photoUrl){
        petId_Name.put(petId, petName);
        petId_Photo.put(petId, photoUrl);
    }
    public String getName(int petId){
        return petId_Name.get(petId);
    }
    public String getPhoto(int petId){ return petId_Photo.get(petId);}
    public List<Integer> getKeyEntries(){
        return new ArrayList<Integer>(petId_Name.keySet());
    }

}
