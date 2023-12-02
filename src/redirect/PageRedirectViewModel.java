package redirect;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The {@code PageRedirectViewModel} class represents a view model for managing
 * page redirection and provides paths to icons associated with different pages.
 */
public abstract class PageRedirectViewModel extends ViewModel {

    /**
     * The file path for the icon associated with browsing.
     */
    public final String SCROLLICONPATH = "/BottomPageRedirectingIcons/browse.png";

    /**
     * The file path for the icon associated with favorite pets.
     */
    public final String FAVPETICONPATH = "/BottomPageRedirectingIcons/fav.png";

    /**
     * The file path for the icon associated with user's pets.
     */
    public final String MYPETICONPATH = "/BottomPageRedirectingIcons/myPet.png";

    /**
     * The file path for the icon associated with the user's profile.
     */
    public final String MYPROFILEICONPATH = "/BottomPageRedirectingIcons/myProfile.png";

    /**
     * Creates a new instance of {@code PageRedirectViewModel}.
     *
     * @param name The name of the view model.
     */
    public PageRedirectViewModel(String name) {
        super(name);
    }


//    public final String SEARCH_REDIRECT_BUTTON_LABEL = "search";
//    public final String BROWSE_REDIRECT_BUTTON_LABEL = "browse";
//    public final String MY_FAV_REDIRECT_BUTTON_LABEL = "my fav";
//
//    public final String MY_PET_REDIRECT_BUTTON_LABEL = "my pet";
//    public final String MY_PROFILE_REDIRECT_BUTTON_LABEL = "my profile";

}
