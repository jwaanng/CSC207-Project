package FavPetPage;
import FavPetPage.DeleteAFavPet.DeleteFavPetViewModel;
import FavPetPage.DisplayUser.DisplayUserModel;
import FavPetPage.addAFavPet.AddViewModel;
import FavPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import FavPetPage.myFavPetPageRedirect.FavPetRDRViewModel;
import FavPetPage.updateAFavPet.UpdateViewModel;
import redirect.PageRedirectViewModel;
import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FavPetPageViewModel extends ViewModel {


    private final AddViewModel add = new AddViewModel();
    private final UpdateViewModel update = new UpdateViewModel();

    private final DeleteFavPetViewModel delete = new DeleteFavPetViewModel();
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
    public DeleteFavPetViewModel getDeleteFavPetViewModel() {return delete;};
    public  PageRedirectViewModel getFavPetRDRViewModel(){
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
