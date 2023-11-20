package FavPetPage.innerviews;

import FavPetPage.innerviewmodels.FavePetDisplayViewModel;
import FavPetPage.innerviewmodels.OnePetProfileDisplayViewModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class OnePetProfile extends JPanel{
    private OnePetProfileDisplayViewModel vm = new OnePetProfileDisplayViewModel();
    public OnePetProfile(String petname, String petPhotoURL, ActionListener commonActionlistener){
        JPopupMenu dropdown = new JPopupMenu();
        JMenuItem delete =  new JMenuItem(vm.DELETE_BUTTON_LABEL);
        JLabel nameLabel = new JLabel(petname);
        //TODO unhandled exception
        URL imageUrl = new URL(petPhotoURL);
        ImageIcon petImage = new ImageIcon(imageUrl);
        //TODO


    }

}
