
package redirect;

import favPetPage.myFavPetPageRedirect.FavPetRDRController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

/**
 * The {@code CommonRedirectView} class represents a common navigation panel with buttons
 * for redirecting to different pages.
 */
public class CommonRedirectView extends JPanel implements PropertyChangeListener {
    protected final PageRedirectViewModel vm;
    protected final JButton browse;
    protected final JButton myFav;
    protected final JButton myPet;
    protected final  JButton myProfile;

    /**
     * Creates a new instance of {@code CommonRedirectView}.
     *
     * @param redirectViewModel The view model for page redirection.
     */
    public CommonRedirectView(PageRedirectViewModel redirectViewModel){
        try {
            this.vm = redirectViewModel;


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

}
