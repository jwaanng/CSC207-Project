package FavPetPage.innerviewmodels;
import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class OnePetProfileDisplayViewModel extends ViewModel {
    //this is just a placeholder vieModel that contains info about how each petProfile will be displayed
    public final String HEART_PATH = "/FavPetPage/like.png";
    public OnePetProfileDisplayViewModel() {
        super("one pet profile");
    }


    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
