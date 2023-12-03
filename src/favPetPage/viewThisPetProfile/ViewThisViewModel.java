package favPetPage.viewThisPetProfile;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class stores all information retrievable by the screen to display a detailed pet profile
 */
public class ViewThisViewModel extends ViewModel {
    private ViewThisState state = new ViewThisState();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Construct a new ViewThisViewModel with preassigned view name
     */
    public ViewThisViewModel() {
        super("view this favorite pet profile");
    }

    /**
     * Set or update information storing the to be displayed pet profile
     *
     * @param state the ViewThisState that stores this information
     */
    public void setState(ViewThisState state) {
        this.state = state;
    }


    /**
     * get the information storing the to be displayed pet profile
     *
     * @return the ViewThisState that stores this information
     */
    public ViewThisState getState() {
        return state;
    }

    /**
     * Notifies and send information to the front end for screen to adjust display
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    /**
     * Add a component to be a listener to changed information
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }
}
