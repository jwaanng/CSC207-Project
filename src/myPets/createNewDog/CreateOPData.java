package myPets.createNewDog;

import java.awt.*;
import java.io.File;

public class CreateOPData {
    private final String name;
    private final String breed;
    private final boolean vaccinated;
    private final boolean neutered;
    private final boolean useCaseFailed;
    private final int age;
    private final String sex;
    private final int id;
    private final File photo;
    private final String size;
    private final String description;
    private final String likes;
    private final String temper;

    public CreateOPData(File photo, int id, String name, String breed, boolean vaccinated, boolean neuter, int age, String sex, String size, String temper, String description, String likes, boolean useCaseFailed){
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.vaccinated = vaccinated;
        this.neutered = neuter;
        this.useCaseFailed = useCaseFailed;
        this.age = age;
        this.sex = sex;
        this.photo = photo;
        this.size = size;
        this.temper = temper;
        this.description = description;
        this.likes = likes;
    }

    public int getPetId(){return id;}
    public String getPetName(){
        return name;
    }
    public String getPetBreed(){
        return breed;
    }
    public boolean isVaccinated(){
        return vaccinated;
    }
    public boolean isNeutered(){
        return neutered;
    }
    public int getAge(){return age;}
    public String getSex(){return sex;}
    public String getSize(){return size;}
    public File getImageFile(){return photo;}
    public String getTemper() {return temper;}
    public String getDescription(){return description;}
    public String getLikes(){return likes;}
}
