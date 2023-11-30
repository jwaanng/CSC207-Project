package favPetPage.deleteAFavPet;

import java.util.ArrayList;
import java.util.List;

public class DeleteState {
    private ArrayList<Integer> ids = new ArrayList<>();

    public DeleteState(DeleteState copy){
        this.ids = copy.ids;
    }
    public DeleteState(){}

    public void addId(int id) {
        ids.add(id);
    }
    public List<Integer> getIds(){
        return new ArrayList<>(ids);
    }
}
