package myProfilePage.changeProfile;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChangeProfileViewModel extends ViewModel {


    /**
     * Constructs a {@code ViewModel} with the specified name.
     */

    private ChangeProfileState state = new ChangeProfileState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public ChangeProfileViewModel() {
        super("change profile");
    }
    public ChangeProfileState getState() {
        return state;
    }

    public void setState(ChangeProfileState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
            support.addPropertyChangeListener(listener);
    }
}
