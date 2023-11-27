package FavPetPage.innerviewmodels;

import FavPetPage.FavPetDisplayState;
import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FavPetDisplayViewModel extends ViewModel {

    public final String propertyName = "state";

    public final int PROFILE_DISPLAY_IN_ONE_ROW = 2;
    public final int SIZE_OF_ONE_PET_PROFILE_IN_PIXEL = 300;

    private FavPetDisplayState state = new FavPetDisplayState();

    public void setState(FavPetDisplayState state) {
        this.state = state;
    }
    public FavPetDisplayState getState(){
        return state;
    }

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public FavPetDisplayViewModel() {
        super("fav pet display ");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
