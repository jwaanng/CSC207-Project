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
        DogProfile mondrea = new PetProfileBuilderFactory().createDogProfile("Jack").
                vaccinated(false).neutered(true).withBreed("Golden retriever").withAge(5).withSex(MALE).withName("mondrea").build();
        PetProfileDataAccessObject daoP = new PetProfileDataAccessObject();
        //
        //daoP.add(mondrea);

        mondrea.setGeneralDescr("woof");
        mondrea.setProfilePublic();

        daoP.update(mondrea);
        System.out.println(daoP.getProfile(mondrea.getId()).getPublicStatus());


    }
}
