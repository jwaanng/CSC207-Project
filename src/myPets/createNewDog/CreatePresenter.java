package myPets.createNewDog;

import myPets.MyPetsViewModel;
//import myPets.noMyPets.MyPetsDisplayViewModel;
import myPets.InnerViewModelManager;

public class CreatePresenter implements CreateOB {

    private final MyPetsViewModel myPetsViewModel;
    private final CreateViewModel createViewModel;
    private final InnerViewModelManager innerViewModelManager;


    public CreatePresenter(InnerViewModelManager innerViewModelManager, MyPetsViewModel myPetsViewModel, CreateViewModel createViewModel) {
        this.myPetsViewModel = myPetsViewModel;
        this.innerViewModelManager = innerViewModelManager;
        this.createViewModel = createViewModel;
    }

    @Override
    public void prepareFailView(String message) {
        CreateState createState = createViewModel.getState();
        createState.setCreateError(message);
        myPetsViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSucessView(CreateOPData outputData) {
        CreateState currState = createViewModel.getState();
        currState.addPetNameAndPhoto(outputData.getPetId(), outputData.getPetName(), outputData.getImageFile());
        createViewModel.setState(createViewModel.getState());
    }
}
