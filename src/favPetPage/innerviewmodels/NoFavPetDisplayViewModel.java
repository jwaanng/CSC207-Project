package favPetPage.innerviewmodels;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class stores all information retrievable by the screen to define what a user should see when they don't
 * have any favorite pet
 */
public class NoFavPetDisplayViewModel extends ViewModel {
    public final String BROWSE_PET = "Go Browse Some Pets!";
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Construct a new NoFavPetDisplayViewModel object with preassigned view name
     */
    public NoFavPetDisplayViewModel() {
        super("no fav pet display");
    }

    /**
     * Notifies and send information to the front end for screen to adjust display
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, null);
        //Just need to fire for notifying
    }

    /**
     * Add a component to be a listener to changed information
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
