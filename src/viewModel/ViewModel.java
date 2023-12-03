package viewModel;

import java.beans.PropertyChangeListener;
//this is the absolute highest viewModel hierarchy
/**
 * The {@code ViewModel} class serves as the highest-level hierarchy for view models.
 * This abstract class provides a foundation for implementing view models in a modular way.
 * Subclasses should extend this class to create specific view models for different components.
 *
 * The class includes a name to identify the view model and methods for handling property change events.
 *
 * @author [Your Name]
 * @version 1.0
 */
public abstract class ViewModel {

    /** The name associated with the view model. */
    private String vmName;

    /**
     * Constructs a {@code ViewModel} with the specified name.
     *
     * @param name The name associated with the view model.
     */
    public ViewModel(String name) {
        this.vmName = name;
    }

    /**
     * Gets the name associated with the view model.
     *
     * @return The name of the view model.
     */
    public String getViewName() {
        return vmName;
    }

    /**
     * Notifies listeners that a property of the view model has changed.
     * Subclasses should implement this method to handle specific property change events.
     */
    public abstract void firePropertyChanged();

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The listener to be added.
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}