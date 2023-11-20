package FavPetPage.innerviews;

import FavPetPage.innerviewmodels.FavePetDisplayViewModel;
import FavPetPage.innerviewmodels.OnePetProfileDisplayViewModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class OnePetProfile extends JPanel{
    private OnePetProfileDisplayViewModel vm = new OnePetProfileDisplayViewModel();
    public OnePetProfile(String petname, String petPhotoURL, ActionListener commonActionlistener){
        JMenuItem delete =  new JMenuItem(vm.DELETE_BUTTON_LABEL);
        JLabel nameLabel = new JLabel(petname);

        ImaageIcon heart = new ImageIcon(getClass().getResource(vm.HEART_PATH));

        //TODO customize heart image size....
        try{
        ImageIcon petImage = new ImageIcon(URI.create(petPhotoURL).toURL());
        }
        catch (IllegalArgumentException | MalformedURLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

}
