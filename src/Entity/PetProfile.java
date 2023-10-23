package Entity;

import java.util.List;

public abstract class PetProfile {
    private String name;
    private int age;
    private boolean sex; //"true = Male, false = Female"
    private String specie;
    private char size;
    private String petPhotoLink;
    private List<String> morePhotos;
    private String petOwnerId;
    private String LikeDescr;
    private String TemperDescr;
    //private List<petFinder> favusers;
    private boolean  isPublic;

}
