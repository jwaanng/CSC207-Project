package myPets.updateMyPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UpdateMyPetsViewModel extends ViewModel {
    private final String propertyName = "state";
    private UpdateMyPetsState state = new UpdateMyPetsState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public UpdateMyPetsViewModel() {
        super("update");
    }

    public UpdateMyPetsState getState(){
        return state;
    }
    public void setState(UpdateMyPetsState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
