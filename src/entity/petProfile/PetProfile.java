package entity.petProfile;

import javax.swing.JPanel;
import java.util.HashMap;
import java.util.List;

public abstract class PetProfile {
    public static final String NAMEIDENTIFIER = "PetName";
    public static final String AGEIDENTIFIER = "Age";
    public static  final String SEXIDENTIFIER = "Sex";
    public static final String SPECIEIDENTIFIER = "Specie";
    public static final String PETOWNERNAMEIDENTIFIER = "Owner";
    public static final String GENERALDESCRIDENTIFIER = "General";
    public static final String LIKEDESCRIDTENFITIER = "Like";
    public static final String TEMPERDESCREIDENTIFIER = "Temper";
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";
    public static final String LARGEPET = "Large";
    public static final String MEDIUMPET = "Medium";
    public static final String SMALLPET = "Small";

    private static int nextId = 0;
    private int petId;
    private String name;
    private int age;
    private String sex;
    private final String specie;
    private String size;
    private final String petOwnerName;
    private String generalDescr;
    private String likeDescr;
    private String temperDescr;
    private boolean  isPublic;
    protected PetProfile(PetProfileBuilder<? extends PetProfileBuilder<?,?>, ? extends PetProfile> builder){

        this.petId = nextId;
        nextId++;
        this.petOwnerName = builder.petOwnerName;
        this.age = builder.age;
        this.name = builder.name;
        this.sex = builder.sex;
        this.size = builder.size;
        this.specie = builder.specie;
        this.isPublic = false;
        this.likeDescr = builder.likeDescr;
        this.temperDescr = builder.temperDescr;
        this.generalDescr = builder.generalDescr;

    }

  //==================================GETTERS, SETTERS======================================
    public String getSpecie(){return specie;}
    public String getPetOwnerName() {
        return petOwnerName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }

    /*valid sex character only*/
    public void setFemale(){
        this.sex = FEMALE;
    }
    public void setMale(){
        this.sex = MALE;
    }
    public String getSize() {
        return size;
    }
    public void setMediumSize() {
        this.size = MEDIUMPET;
    }
    public void setLargeSize(){
        this.size = LARGEPET;
    }
    public void setSmallSize(){
        this.size = SMALLPET;
    }
    public void deletedPhoto(String photo){
       ;
    }
    public String getLikeDescr() {
        return likeDescr;
    }
    public void setLikeDescr(String likeDescr) {
        likeDescr = likeDescr;
    }
    public String getTemperDescr() {
        return temperDescr;
    }
    public void setTemperDescr(String temperDescr) {
        temperDescr = temperDescr;
    }
    public boolean getPublicStatus() {
        return isPublic;
    }
    public void setProfilePublic(){
        isPublic = true;
    }
    public void setProfilePrivate(){
        isPublic = false;
    }

    public String getGeneralDescr() {
        return generalDescr;
    }

    public void setGeneralDescr(String generalDescr) {
        this.generalDescr = generalDescr;
    }

    public int getId() {
        return petId;
    }

//    HashMap<String,String> defaultDisplayProfile(){
//        HashMap<String, String> info = new HashMap<>();
//        info.put(NAMEIDENTIFIER, name);
//        info.put(AGEIDENTIFIER, String.valueOf(age));
//        info.put(SEXIDENTIFIER, String.valueOf(sex));
//        info.put(SPECIEIDENTIFIER, specie);
//        info.put(PETOWNERNAMEIDENTIFIER, petOwnerName);
//        info.put(GENERALDESCRIDENTIFIER, generalDescr);
//        info.put(LIKEDESCRIDTENFITIER, likeDescr);
//        info.put(TEMPERDESCREIDENTIFIER, temperDescr);
//        return  info;
//    }

    public abstract HashMap<String, String> getDisplayAdditionalInformation();
}
