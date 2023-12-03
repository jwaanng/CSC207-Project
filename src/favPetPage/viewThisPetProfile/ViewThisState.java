package favPetPage.viewThisPetProfile;

import java.awt.*;
import java.util.HashMap;

/**
 * Stores information about the detailed pet profile to be displayed
 */
public class ViewThisState {
    String name;
    int age;
    String sex;
    String size;
    String specie;
    Image photo;
    String generalDescr;
    String likeDescr;
    String tempDescr;
    String ownerName;
    String ownerInstagram;

    String error;

    HashMap<String, String> specieSpecificInformation = new HashMap<>();

    /**
     * Construct an UpdateState object from a {@link ViewThisOPData}
     *
     * @param data the {@link  ViewThisOPData that stores all relevant information}
     */
    public ViewThisState(ViewThisOPData data) {
        name = data.name;
        age = data.age;
        sex = data.sex;
        size = data.size;
        photo = data.photo;
        specie = data.specie;
        generalDescr = data.generalDescr;
        likeDescr = data.likeDescr;
        tempDescr = data.tempDescr;
        ownerName = data.ownerName;
        specieSpecificInformation = data.specieSpecificInformation;
        ownerInstagram = data.ownerInstagram;
        error = data.error;
    }

    /**
     * Construct an empty UpdateState object
     */
    public ViewThisState() {
    }

    /**
     * Get the name of a pet
     *
     * @return name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * Get the age of a pet
     *
     * @return age of the pet
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the specie of a pet
     *
     * @return specie of the pet
     */
    public String getSpecie() {
        return specie;
    }

    /**
     * Get the sex of a pet
     *
     * @return sex of the pet
     */
    public String getSex() {
        return sex;
    }

    /**
     * Get the size of a pet
     *
     * @return size of the pet
     */
    public String getSize() {
        return size;
    }

    /**
     * Get the photo of a pet
     *
     * @return image of the pet
     */
    public Image getPhoto() {
        return photo;
    }

    /**
     * Get the general description of a pet
     *
     * @return general description of the pet
     */
    public String getGeneralDescr() {
        return generalDescr;
    }

    /**
     * Get the pet's like description
     *
     * @return the pet's like description
     */
    public String getLikeDescr() {
        return likeDescr;
    }

    /**
     * Get the pet's temp description
     *
     * @return the pet's temp description
     */
    public String getTempDescr() {
        return tempDescr;
    }

    /**
     * Get the name of the owner of the pet
     *
     * @return the pet's owner's name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Get the instagram of the owner of the pet
     *
     * @return the pet's owner's instagram
     */
    public String getOwnerInstagram() {
        return ownerInstagram;
    }

    /**
     * Get the pet's information specifically related to its specie
     *
     * @return a map between the attribute's name and the pet's attribute
     */
    public HashMap<String, String> getSpecieSpecificInformation() {
        return specieSpecificInformation;
    }

    /**
     * Get the error if user can not display the pet profile in detail
     *
     * @return the error
     */
    public String getError() {
        return error;
    }
}
