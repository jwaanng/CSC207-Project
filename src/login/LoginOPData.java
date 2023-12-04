package login;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private final HashMap<Integer, String> petID_to_Name_FavPet = new HashMap<>();
    private final HashMap<Integer, Image> petID_to_Photo_FavPet = new HashMap<>();

    private final HashMap<Integer, String> petID_to_Name_MyPet = new HashMap<>();
    private final HashMap<Integer, File> petID_to_ImageFile_MyPet = new HashMap<>();

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
    public void addFavPetNameAndPHOTO(int petId, String petName, Image photo) {
        petID_to_Name_FavPet.put(petId, petName);
        petID_to_Photo_FavPet.put(petId, photo);
    }

    /**
     * Gets a copy of the mapping of pet IDs to their corresponding profile images.
     *
     * @return A copy of the mapping.
     */
    public HashMap<Integer, Image> getPetID_to_Photo_FavPet() {
        return new HashMap<>(petID_to_Photo_FavPet);
    }

    /**
     * Gets a copy of the mapping of pet IDs to their corresponding names.
     *
     * @return A copy of the mapping.
     */
    public HashMap<Integer, String> getPetID_to_Name_FavPet() {
        return new HashMap<>(petID_to_Name_FavPet);
    }

    public void addMyPetNameAndPHOTO(int petId, String petName, Image photo) throws IOException {
        petID_to_Name_MyPet.put(petId, petName);
        BufferedImage image;
        if (photo instanceof BufferedImage) {
            image = (BufferedImage) photo;
        }
        else {
            image = new BufferedImage(photo.getWidth(null), photo.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB);
            Graphics2D bGr = image.createGraphics();
            bGr.drawImage(photo, 0, 0, null);
            bGr.dispose();
            File imageFile = File.createTempFile("converted_image", ".png");
            ImageIO.write(image, "png", imageFile);
            petID_to_ImageFile_MyPet.put(petId, imageFile);
        }
    }
    public HashMap<Integer, File> getPetID_to_Photo_MyPet() {
        return new HashMap<>(petID_to_ImageFile_MyPet);
    }
    public HashMap<Integer, String> getPetID_to_Name_MyPet() {
        return new HashMap<>(petID_to_Name_MyPet);
    }
}