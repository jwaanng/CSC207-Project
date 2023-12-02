package login;

import java.awt.*;
import java.util.HashMap;

/**
 * The {@code LGOPData} class represents the output data for the login use case, providing information
 * for success or failure scenarios, along with additional details for pet-related information.
 */
public class LGOPData {

    /** The username associated with the login attempt. */
    String username;

    /** The profile image associated with the user's account. */
    Image profile;

    /** Indicates whether the use case execution has failed. */
    boolean usecaseFailed;

    /** The mapping of pet IDs to their corresponding names. */
    private final HashMap<Integer, String> petID_to_Name = new HashMap<>();

    /** The mapping of pet IDs to their corresponding profile images. */
    private final HashMap<Integer, Image> petID_to_Photo = new HashMap<>();

    /** The error message associated with a failed use case execution. */
    String error;

    /**
     * Constructs a new {@code LGOPData} instance by copying the data from another instance.
     *
     * @param copy The {@code LGOPData} instance to copy.
     */
    public LGOPData(LGOPData copy) {
        this.username = copy.username;
        this.profile = copy.profile;
        this.error = copy.error;
        this.usecaseFailed = copy.usecaseFailed;
    }

    /**
     * Constructs an empty {@code LGOPData} instance.
     */
    public LGOPData() {}

    /**
     * Creates an {@code LGOPData} instance for a successful login attempt.
     *
     * @param username The username associated with the successful login.
     * @param profile  The profile image associated with the user's account.
     * @return The created {@code LGOPData} instance.
     */
    public static LGOPData createSuccessData(String username, Image profile) {
        LGOPData data = new LGOPData();
        data.profile = profile;
        data.username = username;
        return data;
    }

    /**
     * Creates an {@code LGOPData} instance for a failed login attempt.
     *
     * @param error The error message associated with the failed login attempt.
     * @return The created {@code LGOPData} instance.
     */
    public static LGOPData createFailData(String error) {
        LGOPData data = new LGOPData();
        data.error = error;
        data.usecaseFailed = true;
        return data;
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