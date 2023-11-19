package MyPetPage;

import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MyPetViewModel extends ViewModel {
    private final String BROWSE_NOFAV = "Go Browse Some Pets!";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public MyPetViewModel() {
        super("my pet");
    }

    public void firePropertyChanged() {

    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
