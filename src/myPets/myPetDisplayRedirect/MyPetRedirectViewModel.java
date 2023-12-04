package myPets.myPetDisplayRedirect;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class MyPetRedirectViewModel extends PageRedirectViewModel {
    public final String propertyName = "my pets redirect";

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public MyPetRedirectViewModel() {
        super("my pet redirect");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
