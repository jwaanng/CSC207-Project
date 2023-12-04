package browsePage.browsePageRedirect;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class BrowsePageViewModel extends ViewModel {
    /**
     * Constructs a {@code ViewModel} with the specified name.
     *
     *
     */
    public BrowsePageViewModel() {
        super("browse page");
    }

    @Override
    public void firePropertyChanged() {
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
