package myProfilePage.innerviews;

import favPetPage.myFavPetPageRedirect.FavPetRDRController;
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
    public MyProfileRDRView(MyProfileRDRViewModel myProfileRDRViewModel, FavPetRDRController favPetRDRController) {
        super(myProfileRDRViewModel);
        myProfile.setEnabled(false);
        myFav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                favPetRDRController.execute();
            }
        });
    }
}
