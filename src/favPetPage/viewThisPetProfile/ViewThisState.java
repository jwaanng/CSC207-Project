package favPetPage.viewThisPetProfile;

import java.awt.*;
import java.util.HashMap;

/**
 *Stores information about the detailed pet profile to be displayed
 * */
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

    HashMap<String,String> specieSpecificInformation = new HashMap<>();

    public ViewThisState(ViewThisOPData data){
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
    public ViewThisState(){
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getSpecie(){return specie;}

    public String getSex() {
        return sex;
    }

    public String getSize() {
        return size;
    }


    public Image getPhoto() {
        return photo;
    }

    public String getGeneralDescr() {
        return generalDescr;
    }

    public String getLikeDescr() {
        return likeDescr;
    }

    public String getTempDescr() {
        return tempDescr;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerInstagram() {
        return ownerInstagram;
    }

    public HashMap<String, String> getSpecieSpecificInformation() {
        return specieSpecificInformation;
    }

    public String getError() {
        return error;
    }
}
