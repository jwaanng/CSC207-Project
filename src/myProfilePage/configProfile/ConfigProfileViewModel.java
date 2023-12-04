package configProfile;

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
    public static final String TITLE_LABEL = "My Profile";
    public static final String USERNAME_LABEL = "Username";
    public static final String CONFIRM_BUTTON = "Confirm";
    public static final String BIO_LABEL = "Bio";
    public static final String ADDRESS_LABEL = "Address";
    public static final String SIZE_LABEL = "Size";
    public static final String SEX_LABEL = "Sex";

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
        System.out.println("VIEWMODEL: property change fired");
        support.firePropertyChange("state", null, this.state);
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