package favPetPage.innerviews;

import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import favPetPage.myFavPetPageRedirect.FavPetRDRViewModel;
import redirect.CommonRedirectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FavPetRDRView extends CommonRedirectView {
    private FavPetRDRController controller;
    public FavPetRDRView(FavPetRDRViewModel favPetRedirectViewModel, FavPetRDRController favPetRedirectController) {
        super(favPetRedirectViewModel);
        controller = favPetRedirectController;
        myFav.setEnabled(false);
        myFav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.execute();;
            }
        });
    }

}
