package favPetPage.addAFavPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddViewModel extends ViewModel {

    public final String propertyName = "state";
    public final int PROFILE_DISPLAY_IN_ONE_ROW = 2;
    public final int SIZE_OF_ONE_PET_PROFILE_IN_PIXEL = 300;

    private AddState state = new AddState();


    public void setState(AddState state) {
        this.state = state;
    }
    public AddState getState(){
        return state;
    }

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public AddViewModel() {
        super("fav pet add update ");
    }


    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
        setState(new AddState()); //refresh
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
