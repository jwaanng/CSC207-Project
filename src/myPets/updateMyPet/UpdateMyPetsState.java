package myPets.updateMyPet;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateMyPetsState {

    //Must include information includes the pet's photo and its name
    private HashMap<Integer, Image> petId_Photo = new HashMap<>();
    private HashMap<Integer, String> petId_Name = new HashMap<>();

    public UpdateMyPetsState(UpdateMyPetsState copy){
        petId_Photo = copy.petId_Photo;
        petId_Name = copy.petId_Name;
    }
    public UpdateMyPetsState() {}

    public void addPetNameAndPhoto(int petId, String petName, Image photo){
        petId_Name.put(petId, petName);
        petId_Photo.put(petId, photo);
    }
    public String getName(int petId){
        return petId_Name.get(petId);
    }
    public Image getPhoto(int petId){
        if(petId_Photo == null){System.out.println("no picture"); return null;}

        return petId_Photo.get(petId);
    }
    public List<Integer> getKeyEntries(){
        return new ArrayList<Integer>(petId_Name.keySet());
    }

}
