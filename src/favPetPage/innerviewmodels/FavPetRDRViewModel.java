package favPetPage.innerviewmodels;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;

/**
 * This class stores all information retrievable by the screen to display a fav pet page's redirecting menu to other
 * main pages
 */
public class FavPetRDRViewModel extends PageRedirectViewModel {
    public final String propertyName = "redirect";

    /**
     * Construct a new FavPetRDRViewModel with preassigned view name
     */
    public FavPetRDRViewModel() {
        super("fav pet redirect");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
