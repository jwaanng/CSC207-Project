package redirect;

import FavPetPage.myFavPetPageRedirect.FavPetRDRController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class CommonRedirectView extends JPanel implements PropertyChangeListener {
    private final PageRedirectViewModel vm;
    private final FavPetRDRController controller;
    private final JButton browse;
    private final JButton myFav;
    private final JButton myPet;
    private final  JButton myProfile;

    public CommonRedirectView(PageRedirectViewModel redirectViewModel, FavPetRDRController redirectController){
        try {
            this.vm = redirectViewModel;
            this.controller = redirectController;

            setLayout(new GridLayout(1, 4, 0, 0));
            browse = new JButton();
            myFav = new JButton();
            myPet = new JButton();
            myProfile = new JButton();

            // TODO generalize this to the outside as a template for other pages too

            //Customize
           BufferedImage browseImg = ImageIO.read(getClass().getResource(vm.SCROLLICONPATH));
            browse.setIcon(new ImageIcon(browseImg.getScaledInstance(70,70,Image.SCALE_DEFAULT)));




            BufferedImage myFavImg = ImageIO.read(getClass().getResource(vm.FAVPETICONPATH));

            myFav.setIcon(new ImageIcon(myFavImg.getScaledInstance(70,70, Image.SCALE_DEFAULT)));


            BufferedImage myPetImg = ImageIO.read(getClass().getResource(vm.MYPETICONPATH));
            myPet.setIcon(new ImageIcon(myPetImg.getScaledInstance(70,70, Image.SCALE_DEFAULT)));

            BufferedImage myProfileImg = ImageIO.read(getClass().getResource(vm.MYPROFILEICONPATH));
            myProfile.setIcon(new ImageIcon(myProfileImg.getScaledInstance(70,70, Image.SCALE_DEFAULT)));

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


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
    public void inMyPetPage(){
        myFav.setEnabled(false);
    }
    //TODO put the public methods to disable corresponding page button
}
