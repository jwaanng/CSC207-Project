
package favPetPage.displayUser;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class stores all information retrievable by the screen to display a user on screen
 */
public class DisplayUserViewModel extends ViewModel {
    public final String APPNAME = "PetPal";
    public final String propertyName = "state";
    private DisplayUserState state = new DisplayUserState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Construct a new DisplayUserViewModel with preassigned view name
     */
    public DisplayUserViewModel() {
        super("user display");
    }

    /**
     * Set or update information on user
     *
     * @param state the DisplayUserState that stores the user's information
     */
    public void setState(DisplayUserState state) {
        this.state = state;
    }

    /**
     * Get stored information about the user
     *
     * @return the DisplayUserState that stores this information
     */
    public DisplayUserState getState() {
        return state;
    }

    /**
     * Notifies and send information to the front end for screen to adjust display
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);

    }

    /**
     * Add a component to be a listener to changed information
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
