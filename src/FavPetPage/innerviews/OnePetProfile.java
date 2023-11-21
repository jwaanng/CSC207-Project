package FavPetPage.innerviews;

import FavPetPage.innerviewmodels.OnePetProfileDisplayViewModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class OnePetProfile extends JPanel {
    public static boolean isValidURL(String url){
        try{
            URL imgUrl = new URL(url);
            return true;
        } catch (MalformedURLException e){
            return false;
        }
    }
    private OnePetProfileDisplayViewModel vm = new OnePetProfileDisplayViewModel();
    public OnePetProfile(String petname, String petPhotoURL, ActionListener commonActionlistener)
            throws MalformedURLException {
        JPopupMenu dropdown = new JPopupMenu();
        JMenuItem delete =  new JMenuItem(vm.DELETE_BUTTON_LABEL);
        JLabel nameLabel = new JLabel(petname);
        if (isValidURL(petPhotoURL)) {
            URL imageUrl = new URL(petPhotoURL);
            ImageIcon petImage = new ImageIcon(imageUrl);
        } else{
            //temporary needs changes later
            System.out.println("enter valid url");
        }
        //TODO


    }

}
