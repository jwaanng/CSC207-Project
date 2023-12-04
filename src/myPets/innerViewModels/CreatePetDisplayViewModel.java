package myPets.innerViewModels;

import myPets.createNewDog.CreateState;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreatePetDisplayViewModel extends ViewModel {

    public static final String CREATE_PET = "create a pet";

    public CreatePetDisplayViewModel(String name) {
        super(CREATE_PET);
    }
    private CreateState state = new CreateState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public CreateState getState(){return state;}
    public void setState(CreateState state){this.state = state;}

}
