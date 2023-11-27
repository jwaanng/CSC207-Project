package favPetPage.innerviewmodels;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class NoFavPetDisplayViewModel extends ViewModel {
    public final String BROWSE_PET = "Go Browse Some Pets!";
    public NoFavPetDisplayViewModel() {
        super("no fav pet display");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
