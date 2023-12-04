package browsePage;

import browsePage.browsePageRedirect.BrowsePageRedirectViewModel;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * View Model class for the Browse Page feature.
 * <p>
 * This class extends the {@link ViewModel} class and is responsible for representing the state and behavior
 * associated with the Browse Page feature in the user interface. It provides methods for notifying changes
 * to registered observers (listeners) and managing property change events.
 */
public class BrowsePageViewModel extends ViewModel {
    private final BrowsePageRedirectViewModel browsePageRedirectViewModel = new BrowsePageRedirectViewModel();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private BrowsePageState state = new BrowsePageState();

    public void setState(BrowsePageState browsePageState) {
        this.state = browsePageState;
        System.out.println(this.state.getUsername());
    }
    public BrowsePageState getState(){
        return state;
    }

    /**
     * Constructor for the BrowsePageViewModel class.
     * Initializes the view model with the specified name.
     */

    public BrowsePageViewModel() {
        super("browse page");
    }

    public BrowsePageRedirectViewModel getBrowsePageRedirectViewModel() {
        return browsePageRedirectViewModel;
    }

    /**
     * Notifies registered observers about a change in the view model's properties.
     */
    @Override
    public void firePropertyChanged() {
       support.firePropertyChange("state", null, this);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The listener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
