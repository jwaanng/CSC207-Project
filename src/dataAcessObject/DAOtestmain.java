package dataAcessObject;

import entity.PetProfiles.DogProfile;
import entity.PetProfiles.PetProfileBuilderFactory;
import entity.User.AppUser;
import entity.User.AppUserFactory;

import static entity.Constants.MALE;

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
        AppUser user3 = new AppUserFactory().createAppUser("Sean Beans", "SeanBean1023", "1000 Yonge Street");
        user3.setBio("I love Mr.Bean");
        dao.add(user3);
        //daoP.add(mondrea);

        //mondrea.setGeneralDescr("woof");
        //mondrea.setProfilePublic();

       // daoP.update(mondrea);


    }
}
