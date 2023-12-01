package dataAcessObject;

import java.awt.*;
import java.io.File;

public interface ProfilePictureDataAccessInterface {
    void uploadUserProfile(String username, File file) ;
    void uploadPetProfile(int id, File file);
    Image retrieveUserProfile(String username);
    Image  retrievePetProfile(int petId);
}
