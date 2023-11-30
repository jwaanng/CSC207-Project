package favPetPage.deleteAFavPet;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteViewModel extends ViewModel {
    public final String propertyName = "state";
    private DeleteState state = new DeleteState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteViewModel() {
        super("fav pet delete");
    }
    public void setState(DeleteState state) {
        this.state = state;
    }
    public DeleteState getState(){
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
        setState(new DeleteState());
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
