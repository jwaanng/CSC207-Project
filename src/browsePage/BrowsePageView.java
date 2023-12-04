package browsePage;

import browsePage.swipePage.SwipePageController;
import browsePage.swipePage.SwipePageView;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myProfilePage.myProfileRedirect.MyProfileRDRController;

import javax.swing.*;
import java.awt.*;

public class BrowsePageView extends JPanel {
    public BrowsePageView(BrowsePageViewModel browsePageViewModel, SwipePageController swipePageController,
                          FavPetRDRController favPetRDRController,
                          MyPetRDRController myPetRDRController,
                          MyProfileRDRController myProfileRDRController
                          ){
        setLayout(new BorderLayout());
        SwipePageView swipePageView = new SwipePageView(swipePageController);
        BrowsePageRedirectView browsePageRedirectView = new BrowsePageRedirectView(
                browsePageViewModel.getBrowsePageRedirectViewModel(),
                favPetRDRController,
                myPetRDRController,
                myProfileRDRController);
        add(swipePageView, BorderLayout.CENTER);
        add(browsePageRedirectView, BorderLayout.SOUTH);


    }
}
