package favPetPage.updateAFavPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UpdateViewModel extends ViewModel {
    private final String propertyName = "state";
    private UpdateState state = new UpdateState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public UpdateViewModel() {
        super("update");
    }

    public UpdateState getState(){
        return state;
    }
    public void setState(UpdateState state) {
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
