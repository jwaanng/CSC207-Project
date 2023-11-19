package ViewModel.MyFavPetPage;
import ViewModel.PageRedirectViewModel;
import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FavPetViewModel extends ViewModel {
    private final String BROWSE_PET = "Go Browse Some Pets!";

    public final PageRedirectViewModel redirect = new PageRedirectViewModel();
    public final String propertyName = "state";
    private FavPetPageState state = new FavPetPageState();



    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setState(FavPetPageState state) {
        this.state = state;
    }

    public FavPetViewModel() {
        super("fav pet");
    }

    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, this.state);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
