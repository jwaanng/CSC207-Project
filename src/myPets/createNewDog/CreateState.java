package myPets.createNewDog;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateState {
    private String name = "";
    private String breed = "";
    private String createError = null;
    private boolean vaccinated = true;
    private boolean neutered = true;
    private int age = 0;
    private String sex = "a";
    private File photo = null;
    private String size = "";
    private String temper = "";
    private String description = "";
    private String likes = "";

    private HashMap<Integer, File> myPetID_Photo = new HashMap<>();
    private HashMap<Integer, String> myPetID_Name = new HashMap<>();
    private File imageFile;

//    public CreateState(CreateState copy) {
//        name = copy.name;
//        breed = copy.breed;
//        vaccinated = copy.vaccinated;
//        neutered = copy.neutered;
//        age = copy.age;
//        sex = copy.sex;
//
//    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CreateState() {

    }
    public CreateState(CreateOPData data){
        name = data.getPetName();;
        breed = data.getPetBreed();
        vaccinated = data.isVaccinated();
        neutered = data.isNeutered();
        age = data.getAge();
        sex = data.getSex();
        photo = data.getImageFile();
        size = data.getSize();
        temper = data.getTemper();
        description = data.getDescription();
        likes = data.getLikes();

    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public boolean isNeutered() {
        return neutered;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getName(int petId){
        return myPetID_Name.get(petId);
    }

    public void setName(String name){this.name = name;}

    public void setBreed(String breed){this.breed = breed;}

    public void setAge(int age){this.age = age;}

    public void setCreateError(String createError){this.createError = createError;}

    public void setImage(File photo) {
        this.imageFile = photo;
    }

    public File getImage(){
        return imageFile;
    }

    public void addPetNameAndPhoto(int petId, String petName, File photo){
        myPetID_Name.put(petId, petName);
        myPetID_Photo.put(petId, photo);
    }

    public List<Integer> getKeyEntries(){
        return new ArrayList<Integer>(myPetID_Name.keySet());
    }

    public String getSize() {
        return this.size;
    }
    public void setSize(String size){
        this.size = size;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }
    public File getImageFile(){return imageFile;}

    public void setTemper(String text) {this.temper = text;}
    public String getTemper(){return temper;}

    public void setDescription(String text) {this.description = text;}
    public String getDescription(){return description;}

    public void setLikes(String text) {this.likes = text;}
    public String getLikes(){return likes;}

}
