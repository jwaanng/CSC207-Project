package myPets.innerViews;

import browsePage.browsePageRedirect.BrowsePageRDRController;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRViewModel;
import myProfilePage.myProfileRedirect.MyProfileRDRController;
import org.checkerframework.checker.units.qual.A;
import redirect.CommonRedirectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPetRDRView extends CommonRedirectView {
    public String viewName = "Redirect View";
    public MyPetRDRView(MyPetRDRViewModel myPetRDRViewModel,
                        BrowsePageRDRController browsePageRDRController,
                        FavPetRDRController favPetRDRController,
                        MyProfileRDRController myProfileRDRController){
        super(myPetRDRViewModel);
        myPet.setEnabled(false);
        myPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browsePageRDRController.execute();
            }
        });
        myFav.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                favPetRDRController.execute();
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
