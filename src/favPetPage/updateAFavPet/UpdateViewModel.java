package favPetPage.updateAFavPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class stores all information retrievable by the screen to update a pet profile that exists in the user's
 * liked list
 */
public class UpdateViewModel extends ViewModel {
    private final String propertyName = "state";
    private UpdateState state = new UpdateState();

    /**
     * Construct a new UpdateViewModel object with preassigned view name
     */
    public UpdateViewModel() {
        super("update");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Get stored information about the pet profiles that need to be updated
     *
     * @return the UpdateState that stores this information
     */
    public UpdateState getState() {
        return state;
    }

    /**
     * Set or update information storing the pet profiles that need to be updated
     *
     * @param state the AddState that stores the new information
     */
    public void setState(UpdateState state) {
        this.state = state;
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
