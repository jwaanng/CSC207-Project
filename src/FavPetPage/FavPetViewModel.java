package FavPetPage;
import FavPetPage.innerviewmodels.FavePetDisplayViewModel;
import ViewModel.PageRedirectViewModel;
import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class FavPetViewModel extends ViewModel {


    public final FavePetDisplayViewModel display = new FavePetDisplayViewModel(); //this is a viewmodel corresponding
    // to the inner scroll pane display of pet profiles


    public final PageRedirectViewModel redirect = new PageRedirectViewModel();

//    private FavPetDisplayState state = new FavPetDisplayState();



//    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

//    public void setState(FavPetDisplayState state) {
//        this.state = state;
//    }
//    public FavPetDisplayState getState(){
//        return state;
//    }
    public FavPetViewModel() {
        super("fav pet");
    }

    public void firePropertyChanged() {

    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
    }
}
