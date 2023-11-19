package ViewModel.MyFavPetPage;

import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public class FavPetDisplayViewModel extends ViewModel {
    public final int PROFILE_DISPLAY_IN_ONE_ROW = 2;

    public final String ADD_BUTTON_LABEL = "+";

    //TODO way to store the information
    public final ;
    public FavPetDisplayViewModel() {
        super("Favorite Pet Display");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
