package favPetPage.viewThisPetProfile;

import java.awt.*;
import java.util.HashMap;

/**
 * This class stores potential errors needed by an viewThisPetProfile presenter to function properly
 */
public class ViewThisOPData {
    String name;
    int age;
    String sex;
    Image photo;
    String size;
    String specie;
    String generalDescr;
    String likeDescr;
    String tempDescr;
    String ownerName;
    HashMap<String, String> specieSpecificInformation;
    String ownerInstagram;
    String error = "";
}
