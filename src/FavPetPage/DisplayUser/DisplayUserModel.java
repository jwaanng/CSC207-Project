package FavPetPage.DisplayUser;

import FavPetPage.DisplayUser.DisplayUserState;
import ViewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayUserModel extends ViewModel {
    public final String APPNAME = "petPal";
    public final String propertyName = "state";
    private DisplayUserState state = new DisplayUserState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public DisplayUserModel() {
        super("user display");
    }
    public void setState(DisplayUserState state){
        this.state = state;
    }
    public DisplayUserState getState(){
        return state;
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
