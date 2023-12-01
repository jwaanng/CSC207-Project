package favPetPage.deleteAFavPet;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores the information on pet profiles that are no longer liked by the user
 */

public class DeleteState {
    private ArrayList<Integer> ids = new ArrayList<>();

    /**
     * Construct a DeleteState from a copy
     * @param copy DeleteState copy
     */
    public DeleteState(DeleteState copy) {
        this.ids = copy.ids;
    }

    /**
     * Construct an empty DeleteState
     */
    public DeleteState() {
    }

    /**
     * Add the petId of the pet profile that needs to be deleted
     *
     * @param id the id of the profile
     */
    public void addId(int id) {
        ids.add(id);
    }

    /**
     * Get the set of all pet ids that need to be deleted
     *
     * @return a list of pet id
     */
    public List<Integer> getIds() {
        return new ArrayList<>(ids);
    }
}
