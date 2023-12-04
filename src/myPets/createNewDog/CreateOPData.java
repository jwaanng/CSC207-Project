package myPets.createNewDog;

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

    public CreateOPData(File photo, int id, String name, String breed, boolean vaccinated, boolean neuter, int age, String sex, String size, boolean useCaseFailed){
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
}
