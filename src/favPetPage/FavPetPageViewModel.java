package favPetPage;
import favPetPage.deleteAFavPet.DeleteViewModel;
import favPetPage.displayUser.DisplayUserModel;
import favPetPage.addAFavPet.AddViewModel;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import favPetPage.myFavPetPageRedirect.FavPetRDRViewModel;
import favPetPage.updateAFavPet.UpdateViewModel;
import redirect.PageRedirectViewModel;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class FavPetPageViewModel extends ViewModel {


    private final AddViewModel add = new AddViewModel();
    private final UpdateViewModel update = new UpdateViewModel();

    private final DeleteViewModel delete = new DeleteViewModel();
    // to the inner scroll pane display of pet profiles
    private final FavPetRDRViewModel redirect = new FavPetRDRViewModel();
    private final DisplayUserModel userinfo = new DisplayUserModel();

    private final NoFavPetDisplayViewModel noPetDisplay = new NoFavPetDisplayViewModel();
    public FavPetPageViewModel() {
        super("fav pet");

    }


    public AddViewModel getAddViewModel(){
        return add;
    }
    public UpdateViewModel getUpdateViewModel() {return update;}
    public DeleteViewModel getDeleteFavPetViewModel() {return delete;};
    public  FavPetRDRViewModel getFavPetRDRViewModel(){
        return redirect;
    }
    public DisplayUserModel getDisplayUserModel(){
        return userinfo;
    }
    public NoFavPetDisplayViewModel getNoPetDisplayViewModel(){
        return noPetDisplay;
    }


    public void viewmodelsfirePropertyChanges(){
        if (!add.getState().getKeyEntries().isEmpty()){
            add.firePropertyChanged();
        } //minimize call to repaintGraphicsAddOrDelete();
        update.firePropertyChanged();
        if (!delete.getState().getIds().isEmpty()){
            delete.firePropertyChanged();
        }
    }

    public void firePropertyChanged() {
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }
}
