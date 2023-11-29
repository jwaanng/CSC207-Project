package FavPetPage.DeleteAFavPet;

import FavPetPage.DeleteAFavPet.DeleteFavPetsState;
import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteFavPetViewModel extends ViewModel {
    public final String propertyName = "state";
    private DeleteFavPetsState state = new DeleteFavPetsState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteFavPetViewModel() {
        super("fav pet delete");
    }
    public void setState(DeleteFavPetsState state) {
        this.state = state;
    }
    public DeleteFavPetsState getState(){
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
        setState(new DeleteFavPetsState());
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
