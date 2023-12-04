package myPets;

import myPets.createNewDog.CreateViewModel;
import myPets.deleteMyPet.DeleteMyPetViewModel;
import myPets.myPetsRedirect.MyRedirectViewModel;
import myPets.innerViewModels.MyPetsDisplayViewModel;
import myPets.innerViewModels.OnePetProfileDisplayViewModel;
import myPets.updateMyPet.UpdateMyPetsViewModel;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class MyPetsViewModel extends ViewModel {


    private final CreateViewModel create = new CreateViewModel();
    private final UpdateMyPetsViewModel update = new UpdateMyPetsViewModel();

    private final DeleteMyPetViewModel delete = new DeleteMyPetViewModel();
    // to the inner scroll pane display of pet profiles
    private final MyRedirectViewModel redirect = new MyRedirectViewModel();
    //private final DisplayUserModel userinfo = new DisplayUserModel();
    private final MyPetsDisplayViewModel myPetsDisplay = new MyPetsDisplayViewModel();
    private final OnePetProfileDisplayViewModel onePetProfileDisplayViewModel = new OnePetProfileDisplayViewModel();

    public MyPetsViewModel() {
        super("my pet");

    }

    public OnePetProfileDisplayViewModel getOnePetProfileDisplayViewModel (){return onePetProfileDisplayViewModel;}
    public CreateViewModel getCreateViewModel(){
        return create;
    }
    public UpdateMyPetsViewModel getUpdateMyPetsViewModel() {return update;}
    public DeleteMyPetViewModel getDeleteMyPetViewModel() {return delete;};
    public MyRedirectViewModel getRedirectViewModel(){
        return redirect;
    }
    public MyPetsDisplayViewModel getMyPetsDisplayViewModel() {
        return myPetsDisplay;
    }

    public void viewmodelsfirePropertyChanges(){
        if (!create.getState().getKeyEntries().isEmpty()){
            create.firePropertyChanged();
        } //minimize call to repaintGraphicsAddOrDelete();
        //update.firePropertyChanged();
        if (!delete.getState().getIds().isEmpty()){
            delete.firePropertyChanged();
        }
    }

    public void firePropertyChanged() {

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }
}
