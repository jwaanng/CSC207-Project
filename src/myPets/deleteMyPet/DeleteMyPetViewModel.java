package myPets.deleteMyPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteMyPetViewModel extends ViewModel {
    public final String propertyName = "state";
    private DeleteMyPetState state = new DeleteMyPetState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteMyPetViewModel() {
        super("myPet delete");
    }
    public void setState(DeleteMyPetState state) {
        this.state = state;
    }
    public DeleteMyPetState getState(){
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
        setState(new DeleteMyPetState());
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
