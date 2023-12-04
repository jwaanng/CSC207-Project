package myProfilePage.configProfile;

import entity.petProfile.PetProfile;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * View Model class for the user profile configuration feature.
 *
 * This class extends the {@link ViewModel} class and is responsible for representing the state and behavior
 * associated with the user profile configuration feature in the user interface. It provides constants for
 * labels, manages the state of the view, and notifies changes to registered observers (listeners).
 */
public class ConfigProfileViewModel extends ViewModel {
    public final String TITLE_LABEL = "My Profile";
    public final String USERNAME_LABEL = "Username";
    public final String CONFIRM_BUTTON = "Confirm";
    public final String BIO_LABEL = "Bio";
    public final String ADDRESS_LABEL = "Address";
    public final String SIZE_LABEL = "Size";
    public final String SEX_LABEL = "Sex";

    //for radio buttons
    public final String NONE = "None";
    public final String SMALL = PetProfile.SMALLPET;
    public final String MEDIUM = PetProfile.MEDIUMPET;
    public final String LARGE = PetProfile.LARGEPET;


    public final String MALE = PetProfile.MALE;
    public final String FEMALE = PetProfile.FEMALE;

    private ConfigProfileState state = new ConfigProfileState();

    /**
     * Constructor for the ConfigProfileViewModel class.
     * Initializes the view model with the specified name.
     */
    public ConfigProfileViewModel() {
        super("My Profile");
    }

    /**
     * Sets the state of the view model.
     *
     * @param state The state object representing the current state of the user profile configuration view.
     */
    public void setState(ConfigProfileState state) {
        this.state = state;
    }

    /**
     * Gets the current state of the view model.
     *
     * @return The state object representing the current state of the user profile configuration view.
     */
    public ConfigProfileState getState() {
        return state;
    }

    /**
     * Notifies registered observers about a change in the view model's properties.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies registered observers about a change in the view model's properties.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
        state.setError(null); //consume error
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The listener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}