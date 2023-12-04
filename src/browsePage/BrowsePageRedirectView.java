package browsePage;

import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myProfilePage.myProfileRedirect.MyProfileRDRController;
import redirect.CommonRedirectView;
import browsePage.browsePageRedirect.BrowsePageRedirectViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowsePageRedirectView extends CommonRedirectView {

    /**
     * Creates a new instance of {@code CommonRedirectView}.
     *
     * @param browsePageRedirectViewModel The view model for page redirection.
     */
    public BrowsePageRedirectView(BrowsePageRedirectViewModel browsePageRedirectViewModel,
                                  FavPetRDRController favPetRDRController,
                                  MyPetRDRController myPetRDRController,
                                  MyProfileRDRController myProfileRDRController
                                  ) {
        super(browsePageRedirectViewModel);
        browse.setEnabled(false);
        myFav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                favPetRDRController.execute();
            }
        });
        myPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPetRDRController.execute();
            }
        });
        myProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myProfileRDRController.execute();
            }
        });

    }
}
