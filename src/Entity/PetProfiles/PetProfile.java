package Entity.PetProfiles;

import java.util.List;

import static Entity.Constants.*;

public abstract class PetProfile {
    private String name;
    private int age;
    private char sex; //"M = Male, "F = Female"
    private final String specie;
    private char size;
    private String petPhotoLink;
    private List<String> morePhotos;
    private final String petOwnerName;
    private String generalDescr;
    private String likeDescr;
    private String temperDescr;

    private boolean  isPublic;
    protected PetProfile(PetProfileBuilder<? extends PetProfileBuilder<?,?>, ? extends PetProfile> builder){
        this.petOwnerName = builder.petOwnerName;
        this.age = builder.age;
        this.name = builder.name;
        this.sex = builder.sex;
        this.size = builder.size;
        this.specie = builder.specie;
        this.isPublic = false;
        this.petPhotoLink = builder.petPhotoLink;
        this.morePhotos = builder.morePhotos;
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
    public char getSex() {
        return sex;
    }

    /*valid sex character only*/
    public void setSex(char sex) {
        this.sex = sex;
    }
    public char getSize() {
        return size;
    }
    public void setSize(char size) {
        this.size = size;
    }
    public String getPetPhotoLink() {
        return petPhotoLink;
    }
    public void setPetPhotoLink(String petPhotoLink) {
        this.petPhotoLink = petPhotoLink;
    }
    public List<String> getMorePhotos() {
        return morePhotos;
    }
    public void addMorePhotos(String photo) {
        morePhotos.add(photo);
    }
    //TODO
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
}
