package favPetPage;

import favPetPage.deleteAFavPet.DeleteViewModel;
import favPetPage.displayUser.DisplayUserViewModel;
import favPetPage.addAFavPet.AddViewModel;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import favPetPage.innerviewmodels.FavPetRDRViewModel;
import favPetPage.updateAFavPet.UpdateViewModel;
import favPetPage.viewThisPetProfile.ViewThisViewModel;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

/**
 * This class stores all information retrievable by the screen to display a fav pet page
 */
public class FavPetPageViewModel extends ViewModel {


    private final AddViewModel add = new AddViewModel();
    private final UpdateViewModel update = new UpdateViewModel();

    private final DeleteViewModel delete = new DeleteViewModel();
    // to the inner scroll pane display of pet profiles
    private final FavPetRDRViewModel redirect = new FavPetRDRViewModel();
    private final DisplayUserViewModel userinfo = new DisplayUserViewModel();
    private final ViewThisViewModel viewPet = new ViewThisViewModel();
    private final NoFavPetDisplayViewModel noPetDisplay = new NoFavPetDisplayViewModel();

    /**
     * Construct a new FavPetPageViewModel with preassigned view name
     */
    public FavPetPageViewModel() {
        super("fav pet");

    }

    /**
     * get the AddViewModel
     */
    public AddViewModel getAddViewModel() {
        return add;
    }

    /**
     * get the UpdateViewModel
     */
    public UpdateViewModel getUpdateViewModel() {
        return update;
    }

    /**
     * get the DeleteViewModel
     */
    public DeleteViewModel getDeleteFavPetViewModel() {
        return delete;
    }

    ;

    /**
     * get the FavPetRDRViewModel
     */
    public FavPetRDRViewModel getFavPetRDRViewModel() {
        return redirect;
    }

    /**
     * get the DisplayUserViewModel
     */
    public DisplayUserViewModel getDisplayUserModel() {
        return userinfo;
    }

    /**
     * get the NoFavPetDisplayViewModel
     */
    public NoFavPetDisplayViewModel getNoPetDisplayViewModel() {
        return noPetDisplay;
    }

    public ViewThisViewModel getViewThisViewModel(){ return viewPet;}

    /**
     * update the display of pet profiles when a user redirects to the favorite pet page
     */
    public void viewmodelsfirePropertyChanges() {
        if (!add.getState().getKeyEntries().isEmpty()) {
            add.firePropertyChanged();
        } //minimize call to repaintGraphicsAddOrDelete();
        update.firePropertyChanged();
        if (!delete.getState().getIds().isEmpty()) {
            delete.firePropertyChanged();
        }
    }

    public void firePropertyChanged() {
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }
}
