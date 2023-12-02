package entity.petProfile;

import java.util.List;

public abstract class PetProfileBuilder<T extends PetProfileBuilder<T,P>, P extends PetProfile>{
    String name;
    int age;
    String sex;
    String specie;
    String size;
    final String petOwnerName;
    String likeDescr;
    String temperDescr;
    String generalDescr;
    public PetProfileBuilder(String petOwnerName){
        this.petOwnerName = petOwnerName;
    }

    public abstract P build();
    private T self(){
        return (T) this;
    }



    public T withName(String name){
        this.name = name;
        return self();
    }
    public T isLargePet(){
        /*valid size char letter */
        this.size = PetProfile.LARGEPET;
        return self();
    }
    public T isMediumPet(){
        this.size = PetProfile.MEDIUMPET;
        return self();
    }
    public T isSmallPet(){
        /*valid size char letter */
        this.size = PetProfile.SMALLPET;
        return self();
    }
    public T withAge(int age){
        this.age = age;
        return self();
    }
    public T isMale(){
        /*valid sex char only*/
        this.sex = PetProfile.MALE;
        return self();
    }
    public T isFemale(){
        this.sex = PetProfile.FEMALE;
        return self();
    }

    public T withTemperDescr(String descr){
        this.temperDescr = descr;
        return self();
    }
    public T withLikedDescr(String descr){
        this.likeDescr = descr;
        return self();
    }
    public T withGeneralDescr(String descr){
        this.generalDescr = descr;
        return self();
    }
}
