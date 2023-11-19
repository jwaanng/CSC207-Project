package ViewModel;

import java.beans.PropertyChangeListener;

public class PageRedirectViewModel extends ViewModel{
    public final String SEARCHICONPATH = "/BottomPageRedirectingIcons/search.png";

    public final String SCROLLICONPATH = "/BottomPageRedirectingIcons/browse.png";
    public final String FAVPETICONPATH = "/ButtomPageRedirectionIcons/fav.png";
    public final String MYPETICONPATH = "/ButtomPageRedirectionIcons/myPet.png";
    public final String MYPROFILEICONPATH = "/ButtomPageRedirectionIcons/myProfile.png";

    public PageRedirectViewModel() {
        super("page redirect");
    }

    @Override
    public void firePropertyChanged() {
        //does not need any in this case
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        //does not need any in this case
    }
}
