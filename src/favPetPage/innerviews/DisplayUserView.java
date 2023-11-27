package favPetPage.innerviews;

import favPetPage.displayUser.DisplayUserState;
import favPetPage.innerviewmodels.DisplayUserModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DisplayUserView extends JPanel implements PropertyChangeListener {
    private DisplayUserModel vm;

    private final JLabel username;
    private final JLabel profile;
    private final JLabel appLabel;

    public DisplayUserView(DisplayUserModel displayUserModel){
        try{
        this.vm = displayUserModel;
        setLayout(new GridBagLayout());
        DisplayUserState currState = vm.getState();


        appLabel = new JLabel(vm.APPNAME);
        username = new JLabel(currState.getUsername());
        profile = new JLabel();

        //TODO customize, image, font, auto resize etc
            // TODO debugging
        //URI path = new URI(currState.getProfilePhotoUrl());
        //BufferedImage profileImg = ImageIO.read(path.toURL());
        //profile.setIcon(new ImageIcon(profileImg));
            profile.setIcon(new ImageIcon(ImageIO.read(getClass()
                            .getResource("/BottomPageRedirectingIcons/myProfile.png"))
                    .getScaledInstance(10,10,Image.SCALE_DEFAULT)));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        add(appLabel);
        gbc.gridy = 1;
        add(username);

        gbc.gridy =2;
        add(profile);

        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        DisplayUserState state = (DisplayUserState) evt.getNewValue();
            if (!username.getText().equals(state.getUsername())){
                username.setText(state.getUsername());
            }
            else{ //the only other reason evt is fired is if the profile photo has changed
                try {
                    URI path = new URI(state.getProfilePhotoUrl());
                    BufferedImage profileImg = ImageIO.read(path.toURL());
                    profile.setIcon(new ImageIcon(profileImg));
                }
                catch (URISyntaxException e){
                    JOptionPane.showMessageDialog( this,"System error, invalid url syntax ");
                }
                catch (IOException e){
                    JOptionPane.showMessageDialog(this, "System error, Profile link does not exists");
                }
            }
    }


}



