package myPets.noMyPets;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NoMyPetsDisplayViewModel extends ViewModel{
    public static String TITLE_LABEL = "No Pets View";
    public final String CREATE_PET = "Go Create Some Pet Profiles!";
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public NoMyPetsDisplayViewModel() {
        super("no my pet display");
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
