package signUp;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * View Model class for the user signup feature.
 *
 * This class extends the {@link ViewModel} class and is responsible for representing the state and behavior
 * associated with the user signup feature in the user interface. It provides constants for labels,
 * manages the state of the view, and notifies changes to registered observers (listeners).
 */
public class SignupViewModel extends ViewModel {

    /**
     * Constructor for the SignupViewModel class.
     * Initializes the view model with the specified name.
     */
    public SignupViewModel() {
        super("sign up");
    }

    private SignupState state = new SignupState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies registered observers about a change in the view model's properties.
     */
    @Override
    public void firePropertyChanged() {
        System.out.println("VIEWMODEL: firing property change");
        support.firePropertyChange("state", null, state);
        System.out.println("VIEWMODEL: property change fired");
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

    /**
     * Gets the current state of the view model.
     *
     * @return The state object representing the current state of the user signup view.
     */
    public SignupState getState() {
        System.out.println(state.toString());
        return state;
    }

    /**
     * Sets the state of the view model.
     *
     * @param state The state object representing the current state of the user signup view.
     */
    public void setState(SignupState state) {
        this.state = state;
    }
}