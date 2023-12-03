package browsePage;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

/**
 * View Model class for the Browse Page feature.
 * <p>
 * This class extends the {@link ViewModel} class and is responsible for representing the state and behavior
 * associated with the Browse Page feature in the user interface. It provides methods for notifying changes
 * to registered observers (listeners) and managing property change events.
 */
public class BrowsePageViewModel extends ViewModel {

    /**
     * Constructor for the BrowsePageViewModel class.
     * Initializes the view model with the specified name.
     */
    public BrowsePageViewModel() {
        super("browse page");
    }

    /**
     * Notifies registered observers about a change in the view model's properties.
     */
    @Override
    public void firePropertyChanged() {
        // Implementation details...
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The listener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // Implementation details...
    }
}
