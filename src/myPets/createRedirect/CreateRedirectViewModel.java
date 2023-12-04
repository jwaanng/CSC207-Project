package myPets.createRedirect;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class CreateRedirectViewModel extends PageRedirectViewModel {
    public final String propertyName = "redirect";

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public CreateRedirectViewModel() {
        super("create pet redirect");
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
