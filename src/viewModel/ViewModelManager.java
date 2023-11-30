package viewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;



public class ViewModelManager {
    public final static String propertyName = "VIEW";
    private String activeViewName;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public String getActiveViewName() {
        return activeViewName;
    }

    public void setActiveViewName(String activeViewName) {
        this.activeViewName = activeViewName;
    }

    public void firePropertyChange(){
        support.firePropertyChange(propertyName, null, this.activeViewName);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
