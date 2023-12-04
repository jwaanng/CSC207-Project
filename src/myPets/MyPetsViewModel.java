package myPets;

import myPets.MyPetsDisplay.AddPetViewModel;
import myPets.createNewDog.CreateViewModel;
import myPets.createRedirect.CreateRedirectViewModel;
import myPets.deleteMyPet.DeleteMyPetViewModel;
import myPets.myPetDisplayRedirect.MyPetRedirectViewModel;
import myPets.myPetPageRedirect.MyPetRDRViewModel;
import myPets.noMyPets.MyPetsDisplayViewModel;
import myPets.noMyPets.NoMyPetsDisplayViewModel;
import myPets.noMyPets.OnePetProfileDisplayViewModel;
import myPets.updateMyPet.UpdateMyPetsViewModel;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class MyPetsViewModel extends ViewModel {


    private final CreateViewModel create = new CreateViewModel();
    private final UpdateMyPetsViewModel update = new UpdateMyPetsViewModel();

    private final DeleteMyPetViewModel delete = new DeleteMyPetViewModel();
    // to the inner scroll pane display of pet profiles
    private final MyPetRDRViewModel redirect = new MyPetRDRViewModel();
    //private final DisplayUserModel userinfo = new DisplayUserModel();
    private final AddPetViewModel addPet = new AddPetViewModel();
    private final MyPetsDisplayViewModel myPetsDisplay = new MyPetsDisplayViewModel();
    private final OnePetProfileDisplayViewModel onePetProfileDisplayViewModel = new OnePetProfileDisplayViewModel();
    private final MyPetRedirectViewModel myPetRedirectViewModel = new MyPetRedirectViewModel();
    private final CreateRedirectViewModel createRedirectViewModel = new CreateRedirectViewModel();
    private final NoMyPetsDisplayViewModel noPetDisplay = new NoMyPetsDisplayViewModel();
    public MyPetsViewModel() {
        super("my pet");

    }

    public OnePetProfileDisplayViewModel getOnePetProfileDisplayViewModel (){return onePetProfileDisplayViewModel;}
    public CreateViewModel getCreateViewModel(){
        return create;
    }
    public UpdateMyPetsViewModel getUpdateMyPetsViewModel() {return update;}
    public DeleteMyPetViewModel getDeleteMyPetViewModel() {return delete;};
    public MyPetRDRViewModel getRDRViewModel(){
        return redirect;
    }
//    public DisplayUserModel getDisplayUserModel(){
//        return userinfo;
//    }
    public CreateRedirectViewModel getCreateRedirectViewModel() {return createRedirectViewModel;}
    public NoMyPetsDisplayViewModel getNoPetsDisplayViewModel(){
        return noPetDisplay;
    }
    public MyPetRedirectViewModel getMyPetRedirectViewModel() {return myPetRedirectViewModel;}
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

    public AddPetViewModel getAddViewModel() {return addPet;}
}
