package favPetPage.addAFavPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class stores all information retrievable by the screen to display the user's newly liked pet profiles
 */
public class AddViewModel extends ViewModel {

    public final String propertyName = "state";
    public final int PROFILE_DISPLAY_IN_ONE_ROW = 2;
    public final int SIZE_OF_ONE_PET_PROFILE_IN_PIXEL = 300;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private AddState state = new AddState();

    /**
     * Construct a new AddViewModel object with preassigned view name
     */
    public AddViewModel() {
        super("fav pet add update ");
    }

    /**
     * Set or update information storing newly liked pet profiles
     *
     * @param state the AddState that stores the new information
     */
    public void setState(AddState state) {
        this.state = state;
    }

    /**
     * Get stored information about newly liked pet profiles
     *
     * @return the AddState that stores this information
     */
    public AddState getState() {
        return state;
    }

    /**
     * Notifies and send information to the front end for screen to adjust display
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
        setState(new AddState()); //refresh
    }

    /**
     * Add a component to be a listener to changed information
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
