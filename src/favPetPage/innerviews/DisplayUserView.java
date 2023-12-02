package favPetPage.innerviews;

import favPetPage.displayUser.DisplayUserState;
import favPetPage.displayUser.DisplayUserViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * What user see for their information
 */
public class DisplayUserView extends JPanel implements PropertyChangeListener {
    private final DisplayUserViewModel vm;

    private final JLabel username;
    private final JLabel profile;
    private final JLabel appLabel;

    /**
     * Construct a new DisplayUserView
     *
     * @param displayUserViewModel the DisplayUserViewModel that stores all the information this view needs to display
     */
    public DisplayUserView(DisplayUserViewModel displayUserViewModel) {
        this.vm = displayUserViewModel;
        vm.addPropertyChangeListener(this);
        setLayout(new GridBagLayout());
        appLabel = new JLabel(vm.APPNAME);
        appLabel.setPreferredSize(new Dimension(100, 50));
        username = new JLabel();
        profile = new JLabel();

        //TODO customize, image, font, auto resize etc
        // TODO debugging
        appLabel.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 25));
        username.setFont(new Font("Garamond", Font.BOLD, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(appLabel, gbc);

        gbc.insets = new Insets(0, 20, 0, 10);
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(username, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 3;
        add(profile, gbc);
    }

    /**
     * Update the user's username and profile picture when changes in the user's username and profile information occur
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        DisplayUserState state = (DisplayUserState) evt.getNewValue();
        if (!username.getText().equals(state.getUsername())) {
            username.setText(state.getUsername());
        } else { //the only other reason evt is fired is if the profile photo has changed
            if (!(state.getPhoto() == null)) {
                profile.setIcon(new ImageIcon(state.getPhoto().getScaledInstance(50, 50,
                        Image.SCALE_DEFAULT)));
            }
        }
        revalidate();
        repaint();
    }


}



