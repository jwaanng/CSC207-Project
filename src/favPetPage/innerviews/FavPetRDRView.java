package favPetPage.innerviews;

import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import favPetPage.innerviewmodels.FavPetRDRViewModel;
import redirect.CommonRedirectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * What user see for the redirecting panel that lets them switch to other pages
 */
public class FavPetRDRView extends CommonRedirectView {
    private FavPetRDRController controller;

    /**
     * Construct a new FavPetRDR(FavPetRedirect)View
     *
     * @param favPetRedirectViewModel  the FavPetRedirectViewModel that stores all the information this view needs
     *                                 to display
     */
    public FavPetRDRView(FavPetRDRViewModel favPetRedirectViewModel) {
        super(favPetRedirectViewModel);
        myFav.setEnabled(false);
        myFav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

}
