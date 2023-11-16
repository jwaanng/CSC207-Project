package DataAcessObject;

import Entity.PetProfiles.DogProfile;
import Entity.PetProfiles.DogProfileBuilder;
import Entity.PetProfiles.PetProfileBuilderFactory;
import Entity.PetProfiles.ProfileBuilderFactory;
import Entity.User.AppUser;
import Entity.User.AppUserFactory;

import java.util.ArrayList;

import static Entity.Constants.MALE;

public class DAOtestmain {
    public static void main(String[] args) {
        AppUser user = new AppUserFactory().createAppUser("Michael", "102325", "108 King Street");
        CommonUserDataAccessObject dao = new CommonUserDataAccessObject();
        user.setBio("I love golden retrievers!");
        AppUser user2 = new AppUserFactory().createAppUser("Jordan", "102325424", "108 King Street");
        DogProfile jessica = new PetProfileBuilderFactory().createDogProfile("Jack").
                vaccinated(true).neutered(true).withBreed("Labarado").withAge(4).withSex(MALE).build();
        PetProfileDataAccessObject daoP = new PetProfileDataAccessObject();
        daoP.add(jessica);
        assert daoP.getProfile(jessica.getName(), jessica.getPetOwnerName(), jessica.getSpecie()) == jessica;
        jessica.setName("jessica");
        jessica.setGeneralDescr("woof");
        jessica.setAge(5);
        daoP.update(jessica);
        assert daoP.getProfile(jessica.getName(), jessica.getPetOwnerName(), jessica.getSpecie()).getName().equals("jessica");


    }
}
