package myPets.createNewDog;

import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;
import entity.petProfile.PetProfileBuilderFactory;
import myPets.InnerViewModelManager;
import myPets.MyPetsViewModel;
import myPets.innerViews.CreatePetView;
import myPets.myPetDisplayRedirect.MyPetRedirectController;

public class CreateUseCaseFactory {
    CreateUseCaseFactory(){}

    public static CreatePetView create(
            InnerViewModelManager viewManagerModel, MyPetsViewModel myPetsViewModel, CreateViewModel createViewModel, PetProfileDataAccessInterface petProfileDataAccessInterface, MyPetRedirectController myRedirectController, ProfilePictureDataAccessInterface profilePictureDataAccessObject) {


        CreateController createController = createPetUseCase(viewManagerModel, createViewModel, myPetsViewModel, petProfileDataAccessInterface, profilePictureDataAccessObject);
        return new CreatePetView(viewManagerModel, createViewModel, createController, myRedirectController);

    }
    public static CreateController createPetUseCase(InnerViewModelManager innerViewModelManager, CreateViewModel createViewModel, MyPetsViewModel myPetsViewModel, PetProfileDataAccessInterface petProfileDataAccessObject, ProfilePictureDataAccessInterface profilePictureDataAccessObject){
        CreateOB createOB = new CreatePresenter(innerViewModelManager,myPetsViewModel, createViewModel);

        PetProfileBuilderFactory petProfileBuilderFactory = new PetProfileBuilderFactory();

        CreateIB createUCI = new CreateUCI(createOB, petProfileBuilderFactory, petProfileDataAccessObject, profilePictureDataAccessObject);

        return new CreateController(createUCI);
    }

}
