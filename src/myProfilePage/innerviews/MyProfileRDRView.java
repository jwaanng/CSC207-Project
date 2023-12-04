package myProfilePage.innerviews;

import browsePage.browsePageRedirect.BrowsePageRDRController;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myProfilePage.MyProfileRDRViewModel;
import redirect.CommonRedirectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfileRDRView extends CommonRedirectView {

    /**
     * Creates a new instance of {@code CommonRedirectView}.
     *
     * @param myProfileRDRViewModel The view model for page redirection.
     */
    public MyProfileRDRView(MyProfileRDRViewModel myProfileRDRViewModel,
                            BrowsePageRDRController browsePageRDRController,
                            FavPetRDRController favPetRDRController,
                            MyPetRDRController myPetRDRController
    ) {
        super(myProfileRDRViewModel);
        myProfile.setEnabled(false);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browsePageRDRController.execute();
            }
        });
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


    }
}
