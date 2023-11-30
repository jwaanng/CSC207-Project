package favPetPage.innerviews;

import favPetPage.displayUser.DisplayUserState;
import favPetPage.displayUser.DisplayUserModel;
import org.checkerframework.common.subtyping.qual.Bottom;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DisplayUserView extends JPanel implements PropertyChangeListener {
    private final DisplayUserModel vm;

    private final JLabel username;
    private final JLabel profile;
    private final JLabel appLabel;

    public DisplayUserView(DisplayUserModel displayUserModel){
        try{
        this.vm = displayUserModel;
        vm.addPropertyChangeListener(this);
        setLayout(new GridBagLayout());
        DisplayUserState currState = vm.getState();

        appLabel = new JLabel(vm.APPNAME);
        appLabel.setPreferredSize(new Dimension(100, 50));
        username = new JLabel();
        profile = new JLabel();

        //TODO customize, image, font, auto resize etc
            // TODO debugging
        //URI path = new URI(currState.getProfilePhotoUrl());
        //BufferedImage profileImg = ImageIO.read(path.toURL());
        //profile.setIcon(new ImageIcon(profileImg));
            profile.setIcon(new ImageIcon(ImageIO.read(getClass()
                            .getResource("/BottomPageRedirectingIcons/myProfile.png"))
                    .getScaledInstance(50,50,Image.SCALE_DEFAULT)));
            appLabel.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 25));
            username.setFont(new Font("Garamond", Font.BOLD, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(appLabel,gbc);

        gbc.insets = new Insets(0,20,0,10);
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(username, gbc);
        gbc.insets = new Insets(0,0,0,0);
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 3;
        add(profile, gbc);

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
                    if(!state.getProfilePhotoUrl().isEmpty()){
                    URI path = new URI(state.getProfilePhotoUrl());
                    BufferedImage profileImg = ImageIO.read(path.toURL());
                    profile.setIcon(new ImageIcon(profileImg));
                    }
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



