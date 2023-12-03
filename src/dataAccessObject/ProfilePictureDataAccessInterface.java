package dataAcessObject;

import java.awt.*;
import java.io.File;

/**
 * Interface for accessing and manipulating user and pet profile pictures.
 */
public interface ProfilePictureDataAccessInterface {

    /**
     * Uploads a user profile picture to the data source.
     *
     * @param username The username of the user for whom the profile picture is uploaded.
     * @param file     The File object representing the image file to be uploaded.
     */
    void uploadUserProfile(String username, File file);

    /**
     * Uploads a pet profile picture to the data source.
     *
     * @param id   The unique identifier of the pet for which the profile picture is uploaded.
     * @param file The File object representing the image file to be uploaded.
     */
    void uploadPetProfile(int id, File file);

    /**
     * Retrieves the user profile picture from the data source.
     *
     * @param username The username of the user for whom the profile picture is retrieved.
     * @return An Image object representing the retrieved user profile picture.
     */
    Image retrieveUserProfile(String username);

    /**
     * Retrieves the pet profile picture from the data source.
     *
     * @param petId The unique identifier of the pet for which the profile picture is retrieved.
     * @return An Image object representing the retrieved pet profile picture.
     */
    Image retrievePetProfile(int petId);
}