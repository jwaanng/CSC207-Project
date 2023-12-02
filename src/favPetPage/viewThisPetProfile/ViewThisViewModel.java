package favPetPage.viewThisPetProfile;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewThisViewModel extends ViewModel {
    private ViewThisState state = new ViewThisState();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ViewThisViewModel() {
        super("view this favorite pet profile");
    }

    public void setState(ViewThisState state) {
        this.state = state;
    }


    public ViewThisState getState() {
        return state;
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
