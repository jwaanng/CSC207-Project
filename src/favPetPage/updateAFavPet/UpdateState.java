package favPetPage.updateAFavPet;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class stores the information on pet profiles in a user's liked list that needs to be updated
 */
public class UpdateState {

    //Must include information includes the pet's photo and its name
    private HashMap<Integer, Image> petId_Photo = new HashMap<>();
    private HashMap<Integer, String> petId_Name = new HashMap<>();

    /**
     * Construct an UpdateState from a copy
     *
     * @param copy UpdateState copy
     */
    public UpdateState(UpdateState copy) {
        petId_Photo = copy.petId_Photo;
        petId_Name = copy.petId_Name;
    }

    /**
     * Construct an empty UpdateState
     */
    public UpdateState() {
    }

    /**
     * Add a pet profile's information
     *
     * @param petId the id of the profile
     * @param name  the name of the pet
     * @param photo the image of the pet
     */

    public void addPetNameAndPhoto(int petId, String name, Image photo) {
        petId_Name.put(petId, name);
        petId_Photo.put(petId, photo);
    }

    /**
     * Get the name of a pet given that pet's profile id
     *
     * @param petId the id of the profile
     * @return name of the pet
     */
    public String getName(int petId) {
        return petId_Name.get(petId);
    }

    /**
     * Get the image of a pet given that pet's profile id
     *
     * @param petId the id of the profile
     * @return photo of the pet
     */
    public Image getPhoto(int petId) {
        return petId_Photo.get(petId);
    }

    /**
     * Get the set of all pet ids stored in this UpdateState
     *
     * @return a list of pet id
     */
    public List<Integer> getKeyEntries() {
        return new ArrayList<Integer>(petId_Name.keySet());
    }

}
