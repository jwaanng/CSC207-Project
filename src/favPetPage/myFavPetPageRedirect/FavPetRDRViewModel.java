package favPetPage.myFavPetPageRedirect;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;


public class FavPetRDRViewModel extends PageRedirectViewModel {
    public final String propertyName = "redirect";

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
