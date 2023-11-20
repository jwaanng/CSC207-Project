package FavPetPage.innerviewmodels;

import FavPetPage.FavPetDisplayState;
import ViewModel.ViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FavePetDisplayViewModel extends ViewModel {
    public final String BROWSE_PET = "Go Browse Some Pets!";

    public final String propertyName = "state";

    public final int PROFILE_DISPLAY_IN_ONE_ROW = 2;

    public final String ADD_BUTTON_LABEL = "+";
    private FavPetDisplayState state = new FavPetDisplayState();

    public void setState(FavPetDisplayState state) {
        this.state = state;
    }
    public FavPetDisplayState getState(){
        return state;
    }

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public FavePetDisplayViewModel() {
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
