package myPets.myPetPageRedirect;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class MyPetRDRViewModel extends PageRedirectViewModel {
    public final String propertyName = "redirect";
    private String name = "";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public MyPetRDRViewModel() {
        super("my pet redirect");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("name", null, name);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
