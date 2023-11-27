package viewModel;

import java.beans.PropertyChangeListener;

public class PageRedirectViewModel extends ViewModel{

    public final String SCROLLICONPATH = "/BottomPageRedirectingIcons/browse.png";
    public final String FAVPETICONPATH = "/BottomPageRedirectingIcons/fav.png";
    public final String MYPETICONPATH = "/BottomPageRedirectingIcons/myPet.png";
    public final String MYPROFILEICONPATH = "/BottomPageRedirectingIcons/myProfile.png";

//    public final String SEARCH_REDIRECT_BUTTON_LABEL = "search";
//    public final String BROWSE_REDIRECT_BUTTON_LABEL = "browse";
//    public final String MY_FAV_REDIRECT_BUTTON_LABEL = "my fav";
//
//    public final String MY_PET_REDIRECT_BUTTON_LABEL = "my pet";
//    public final String MY_PROFILE_REDIRECT_BUTTON_LABEL = "my profile";


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
