package login;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The {@code LoginViewModel} class represents the view model for the login feature,
 * providing labels for UI elements, managing the state, and notifying listeners
 * of state changes.
 */
public class LoginViewModel extends ViewModel {


    public final String APPNAME_LABEL = "PetPal";
    public final String USERNAME_NAME_LABEL = "Username";
    public final String PASSWORD_NAME_LABEL = "Password";
    public final String LOGIN_LABEL = "Log In";
    public final String CANCEL_LABEL = "Cancel";
    private LoginState state = new LoginState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs an {@code LoginViewModel} instance with the specified name.
     */
    public LoginViewModel() {
        super("log in");
    }

    /**
     * Sets the state of the login view.
     *
     * @param state The new state of the login view.
     */
    public void setState(LoginState state) {
        this.state = state;
    }

    /**
     * Gets the current state of the login view.
     *
     * @return The current state of the login view.
     */

    public LoginState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}