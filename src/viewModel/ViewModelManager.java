package viewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The {@code ViewModelManager} class manages the active view model and provides functionality
 * for handling property changes related to view model updates.
 *
 * It includes a constant property name, the active view name, and methods to get the active view name,
 * set the active view name, fire property changes, and add property change listeners.
 */
public class ViewModelManager {

    /** The constant property name associated with view model changes. */
    public final static String propertyName = "VIEW";
    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Gets the name of the currently active view.
     *
     * @return The name of the active view.
     */
    public String getActiveViewName() {
        return activeViewName;
    }

    /**
     * Sets the name of the currently active view.
     *
     * @param activeViewName The name of the active view to be set.
     */
    public void setActiveViewName(String activeViewName) {
        this.activeViewName = activeViewName;
    }

    /**
     * Notifies listeners that a property of the view model manager has changed.
     * This method is called when the active view name changes.
     */
    public void firePropertyChange() {
        support.firePropertyChange(propertyName, null, this.activeViewName);
    }

    /**
     * Adds a property change listener to the view model manager.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
