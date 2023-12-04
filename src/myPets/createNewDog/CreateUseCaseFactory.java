package myPets.createNewDog;

import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.ProfilePictureDataAccessInterface;
import dataAccessObject.UserDataAccessInterface;
import entity.petProfile.PetProfileBuilderFactory;
import myPets.MyPetsViewModel;
import myPets.myPetDisplayRedirect.MyPetRedirectController;
import myPets.innerViews.CreatePetView;
import myPets.InnerViewModelManager;

public class CreateUseCaseFactory {
    CreateUseCaseFactory(){}

    public static CreatePetView create(
            InnerViewModelManager viewManagerModel, MyPetsViewModel myPetsViewModel, CreateViewModel createViewModel, UserDataAccessInterface userDataAccessInterface, PetProfileDataAccessInterface petProfileDataAccessInterface, MyPetRedirectController myRedirectController, ProfilePictureDataAccessInterface profilePictureDataAccessObject) {


        CreateController createController = createPetUseCase(viewManagerModel, createViewModel, myPetsViewModel, userDataAccessInterface,  petProfileDataAccessInterface, profilePictureDataAccessObject);
        return new CreatePetView(viewManagerModel, createViewModel, createController, myRedirectController);

    }
    public static CreateController createPetUseCase(InnerViewModelManager innerViewModelManager, CreateViewModel createViewModel, MyPetsViewModel myPetsViewModel, UserDataAccessInterface userDataAccessInterface, PetProfileDataAccessInterface petProfileDataAccessObject, ProfilePictureDataAccessInterface profilePictureDataAccessObject){
        CreateOB createOB = new CreatePresenter(innerViewModelManager,myPetsViewModel, createViewModel);

        PetProfileBuilderFactory petProfileBuilderFactory = new PetProfileBuilderFactory();

        CreateIB createUCI = new CreateUCI(createOB, petProfileBuilderFactory, userDataAccessInterface, petProfileDataAccessObject, profilePictureDataAccessObject);

        return new CreateController(createUCI);
    }

}
