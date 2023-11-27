package FavPetPage.innerviews;

import FavPetPage.Redirect.RDController;
import ViewModel.PageRedirectViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class RedirectView extends JPanel {
    private final PageRedirectViewModel vm;
    private final RDController controller;
    private final JButton browse;
    private final JButton myFav;
    private final JButton myPet;
    private final  JButton myProfile;

    public RedirectView(PageRedirectViewModel redirectViewModel, RDController redirectController){
        try {
            this.vm = redirectViewModel;
            this.controller = redirectController;

            setLayout(new GridLayout(1, 4, 0, 0));
            browse = new JButton();
            myFav = new JButton();
            myPet = new JButton();
            myProfile = new JButton();
            myFav.setEnabled(false);

            // TODO generalize this to the outside as a template for other pages too

            //Customize
           BufferedImage browseImg = ImageIO.read(getClass().getResource(vm.SCROLLICONPATH));
            browse.setIcon(new ImageIcon(browseImg.getScaledInstance(100,100,Image.SCALE_DEFAULT)));


            BufferedImage myFavImg = ImageIO.read(getClass().getResource(vm.FAVPETICONPATH));

            myFav.setIcon(new ImageIcon(myFavImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));


            BufferedImage myPetImg = ImageIO.read(getClass().getResource(vm.MYPETICONPATH));
            myPet.setIcon(new ImageIcon(myPetImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

            BufferedImage myProfileImg = ImageIO.read(getClass().getResource(vm.MYPROFILEICONPATH));
            myProfile.setIcon(new ImageIcon(myProfileImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

            //browse.setActionCommand();
            add(browse);
            add(myFav);
            add(myPet);
            add(myProfile);


        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
