package myPets.deleteMyPet;

import java.util.ArrayList;
import java.util.List;

public class DeleteMyPetState {
    private ArrayList<Integer> ids = new ArrayList<>();

    public DeleteMyPetState(DeleteMyPetState copy){
        this.ids = copy.ids;
    }
    public DeleteMyPetState(){}

    public void addId(int id) {
        ids.add(id);
    }
    public List<Integer> getIds(){
        return new ArrayList<>(ids);
    }
}
