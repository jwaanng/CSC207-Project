package login;

import java.awt.*;
import java.util.HashMap;

/**
 * The {@code LoginOPData} class represents the output data for the login use case, providing information
 * for success or failure scenarios, along with additional details for pet-related information.
 */
public class LoginOPData {


    String username;
    String preferredSex;
    String preferredSize;
    String address;
    String bio;
    Image profile;

    boolean usecaseFailed;
    private final HashMap<Integer, String> petID_to_Name = new HashMap<>();
    private final HashMap<Integer, Image> petID_to_Photo = new HashMap<>();

    String error;

    /**
     * Constructs a new {@code LGOPData} instance by copying the data from another instance.
     *
     * @param copy The {@code LGOPData} instance to copy.
     */
    public LoginOPData(LoginOPData copy) {
        username = copy.username;
        address = copy.address;
        bio = copy.bio;
        preferredSex = copy.preferredSex;
        preferredSize = copy.preferredSize;
        profile = copy.profile;
        error = copy.error;
        usecaseFailed = copy.usecaseFailed;
    }

    /**
     * Constructs an empty {@code LGOPData} instance.
     */
    public LoginOPData() {
    }


    /**
     * Adds pet name and photo information to the {@code LGOPData} instance.
     *
     * @param petId   The ID of the pet.
     * @param petName The name of the pet.
     * @param photo   The profile image of the pet.
     */
    public void addPetNameAndPHOTO(int petId, String petName, Image photo) {
        petID_to_Name.put(petId, petName);
        petID_to_Photo.put(petId, photo);
    }

    /**
     * Gets a copy of the mapping of pet IDs to their corresponding profile images.
     *
     * @return A copy of the mapping.
     */
    public HashMap<Integer, Image> getPetID_to_Photo() {
        return new HashMap<>(petID_to_Photo);
    }

    /**
     * Gets a copy of the mapping of pet IDs to their corresponding names.
     *
     * @return A copy of the mapping.
     */
    public HashMap<Integer, String> getPetID_to_Name() {
        return new HashMap<>(petID_to_Name);
    }
}