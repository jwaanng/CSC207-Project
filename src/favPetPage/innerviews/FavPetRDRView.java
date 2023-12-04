package favPetPage.innerviews;

import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import favPetPage.innerviewmodels.FavPetRDRViewModel;
import myProfilePage.myProfileRedirect.MyProfileRDRController;
import redirect.CommonRedirectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * What user see for the redirecting panel that lets them switch to other pages
 */
public class FavPetRDRView extends CommonRedirectView {
    private FavPetRDRController controller;

    /**
     * Construct a new FavPetRDR object
     *
     * @param favPetRedirectViewModel the {@link FavPetRDRViewModel} that stores all the information this view needs
     *                                to display
     */
    public FavPetRDRView(FavPetRDRViewModel favPetRedirectViewModel, MyProfileRDRController myProfileController) {
        super(favPetRedirectViewModel);
        myFav.setEnabled(false);
        myFav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        myProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myProfileController.execute();
            }
        });
    }

}
