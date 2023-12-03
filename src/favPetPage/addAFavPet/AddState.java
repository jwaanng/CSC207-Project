package favPetPage.addAFavPet;

import login.LoginOPData;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class stores the information on liked pet profiles that needs to be added to a user's screen of favorite pets
 */
public class AddState {


    //Must include information includes the pet's photo and its name
    private HashMap<Integer, Image> favPetID_Photo = new HashMap<>();
    private HashMap<Integer, String> favPetID_Name = new HashMap<>();

    /**
     * Construct an AddState object
     *
     * @param data output data retrieved after a user login
     */
    public AddState(LoginOPData data) {
        this.favPetID_Photo = data.getPetID_to_Photo();
        this.favPetID_Name = data.getPetID_to_Name();
    }

    /**
     * Construct an empty AddState object
     */
    public AddState() {
    }

    /**
     * Add a pet profile's information
     *
     * @param petId   the id of the profile
     * @param petName the name of the pet
     * @param photo   the image of the pet
     */
    public void addPetNameAndPhoto(int petId, String petName, Image photo) {
        favPetID_Name.put(petId, petName);
        favPetID_Photo.put(petId, photo);
    }

    /**
     * Get the name of a pet given that pet's profile id
     *
     * @param petId the id of the profile
     * @return name of the pet
     */
    public String getName(int petId) {
        return favPetID_Name.get(petId);
    }

    /**
     * Get the image of a pet given that pet's profile id
     *
     * @param petId the id of the profile
     * @return photo of the pet
     */
    public Image getPhoto(int petId) {
        return favPetID_Photo.get(petId);
    }

    /**
     * Get the set of all pet ids stored in this AddState
     *
     * @return a list of pet id
     */
    public List<Integer> getKeyEntries() {
        return new ArrayList<Integer>(favPetID_Name.keySet());
    }

}
