package favPetPage.innerviewmodels;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NoFavPetDisplayViewModel extends ViewModel {
    public final String BROWSE_PET = "Go Browse Some Pets!";
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public NoFavPetDisplayViewModel() {
        super("no fav pet display");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, null);
        //Just need to fire for notifying
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
