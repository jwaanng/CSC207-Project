package myPets.createNewDog;

import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;
import entity.petProfile.DogProfile;
import entity.petProfile.PetProfileBuilderFactory;

public class CreateUCI implements CreateIB {
    private final CreateOB presenter;
    private final PetProfileBuilderFactory petFactory;
    private final PetProfileDataAccessInterface daop;
    private final ProfilePictureDataAccessInterface daopfp;

    public CreateUCI(CreateOB createPresenter, PetProfileBuilderFactory petFactory,
                     PetProfileDataAccessInterface petProfileDataAccessObject, ProfilePictureDataAccessInterface profilePictureDataAccessObject) {
        this.presenter = createPresenter;
        this.petFactory = petFactory;
        this.daop = petProfileDataAccessObject;
        this.daopfp = profilePictureDataAccessObject;
    }

    @Override
    public void execute(String username, CreateIPData inputData) {
//        if (daop.exists(petId)) {
//            presenter.prepareFailView("pet already exists!");
//        }
//        else {
            DogProfile pet = petFactory.createDogProfile(username).vaccinated(inputData.isVaccinated()).neutered(inputData.isNeutered()).withBreed(inputData.getPetBreed()).withAge(inputData.getAge()).isMale().withName(inputData.getName()).build();
            daop.add(pet);
            daopfp.uploadPetProfile(pet.getId(), inputData.getImageFile());
            CreateOPData createOP = new CreateOPData(inputData.getImageFile(), pet.getId(), pet.getName(), pet.getBreed(), pet.isVaccinated(), pet.isNeuter(), pet.getAge(), pet.getSex(), inputData.getSize(), false);

            presenter.prepareSucessView(createOP);
//        }


    }
}
