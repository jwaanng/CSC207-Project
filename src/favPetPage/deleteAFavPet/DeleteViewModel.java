package favPetPage.deleteAFavPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class stores all information retrievable by the screen to remove a fav pet profile in display
 */
public class DeleteViewModel extends ViewModel {

    public final String propertyName = "state";
    private DeleteState state = new DeleteState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Construct a new AddViewModel object with preassigned view name
     */
    public DeleteViewModel() {
        super("fav pet delete");
    }

    /**
     * Set or update information storing deleting pet profiles
     *
     * @param state the AddState that stores the new information
     */
    public void setState(DeleteState state) {
        this.state = state;
    }

    /**
     * Get stored information about deleting pet profiles
     *
     * @return the DeleteState that stores this information
     */
    public DeleteState getState() {
        return state;
    }

    /**
     * Notifies and send information to the front end for screen to adjust display
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
        setState(new DeleteState());
    }

    /**
     * Add a component to be a listener to changed information
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
