package browsePage;

import browsePage.swipe.DynamicSwipePageController;
import browsePage.swipe.PetProfilePresenter;
import favPetPage.addAFavPet.AddController;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myProfilePage.myProfileRedirect.MyProfileRDRController;

import javax.swing.*;
import java.awt.*;

public class BrowsePageView extends JPanel {
    public BrowsePageView(BrowsePageViewModel browsePageViewModel,
                          PetProfilePresenter petProfilePresenter,
                          AddController addController,
                          FavPetRDRController favPetRDRController,
                          MyPetRDRController myPetRDRController,
                          MyProfileRDRController myProfileRDRController
                          ){

        setLayout(new BorderLayout());
        SwipePageView swipePageView = new SwipePageView(petProfilePresenter,addController, browsePageViewModel);
        BrowsePageRedirectView browsePageRedirectView = new BrowsePageRedirectView(
                browsePageViewModel.getBrowsePageRedirectViewModel(),
                favPetRDRController,
                myPetRDRController,
                myProfileRDRController);
        add(swipePageView, BorderLayout.CENTER);
        add(browsePageRedirectView, BorderLayout.SOUTH);


    }
}
