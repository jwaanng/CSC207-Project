package FavPetPage.DeleteAFavPet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeleteFavPetsState {
    private ArrayList<Integer> ids = new ArrayList<>();

    public DeleteFavPetsState(DeleteFavPetsState copy){
        this.ids = copy.ids;
    }
    public DeleteFavPetsState(){}

    public void addId(int id) {
        ids.add(id);
    }
    public List<Integer> getIds(){
        return new ArrayList<>(ids);
    }
}
