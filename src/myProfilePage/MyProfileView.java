package myProfilePage;

import browsePage.browsePageRedirect.BrowsePageRDRController;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myProfilePage.changeProfile.*;
import myProfilePage.configProfile.*;

import myProfilePage.innerviews.ChangeImageView;
import myProfilePage.innerviews.MyProfileRDRView;
import myProfilePage.myProfileRedirect.MyProfileRDRController;
import view.ButtonTextPanel;
import view.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public static final String viewName = "my profile";

    private final JTextField usernameInputfield = new JTextField(15);
    private final JTextField bioInputfield= new JTextField(15);
    private final JTextField addressinputfield = new JTextField(15);
    private final JRadioButton smallRadioButton;
    private final JRadioButton bigRadioButton;
    private final JRadioButton mediumRadioButton;
    private final JRadioButton femaleRadioButton;
    private final JRadioButton maleRadioButton;
    private final JRadioButton noSizeRadioButton;
    private final JRadioButton noSexRadioButton;
    private JDialog dialog;
    private final JLabel imageLabel;
    private final ConfigProfileController configController;
    private final ChangeProfileController changeController;
    private final ConfigProfileViewModel configVM;

    private final ChangeProfileViewModel changeVM;

    private String preferredSize;
    private String preferredSex;

    public MyProfileView(
            MyProfileViewModel myProfileViewModel,
            ConfigProfileController configProfileController,
            ChangeProfileController changeProfileController,
            BrowsePageRDRController browsePageRDRController,
            FavPetRDRController favPetRDRController,
            MyPetRDRController myPetRDRController
    ) {
        this.configController = configProfileController;
        this.configVM = myProfileViewModel.getConfigProfileViewModel();
        this.changeController = changeProfileController;
        this.changeVM = myProfileViewModel.getChangeProfileViewModel();
        configVM.addPropertyChangeListener(this);
        this.changeVM.addPropertyChangeListener(this);

        //layout
        setLayout(new BorderLayout());

        //inner layout
        JPanel cp = new JPanel();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        //create profile image label
        imageLabel = new JLabel();
        JPanel imagePanel = new JPanel(new GridBagLayout());
        imagePanel.add(imageLabel);
        cp.add(imagePanel);

        //create text panel
        LabelTextPanel username = new LabelTextPanel(
                new JLabel(configVM.USERNAME_LABEL), usernameInputfield );
        LabelTextPanel bio = new LabelTextPanel(
                new JLabel(configVM.BIO_LABEL), bioInputfield );
        LabelTextPanel address = new LabelTextPanel(
                new JLabel(configVM.ADDRESS_LABEL), addressinputfield);

        cp.add(username);
        cp.add(bio);
        cp.add(address);

        //create buttons
        smallRadioButton = new JRadioButton(configVM.SMALL);
        mediumRadioButton = new JRadioButton(configVM.MEDIUM);
        bigRadioButton = new JRadioButton(configVM.LARGE);
        noSizeRadioButton = new JRadioButton(configVM.NONE);
        femaleRadioButton = new JRadioButton(configVM.FEMALE);
        maleRadioButton = new JRadioButton(configVM.MALE);
        noSexRadioButton = new JRadioButton(configVM.NONE);

        //grouping buttons
        JPanel sizeGroup = new JPanel();
        sizeGroup.add(smallRadioButton);
        sizeGroup.add(mediumRadioButton);
        sizeGroup.add(bigRadioButton);
        sizeGroup.add(noSizeRadioButton);

        JPanel sexGroup = new JPanel();
        sexGroup.add(femaleRadioButton);
        sexGroup.add(maleRadioButton);
        sexGroup.add(noSexRadioButton);

        ButtonGroup sizeButtonGroup = new ButtonGroup();
        sizeButtonGroup.add(smallRadioButton);
        sizeButtonGroup.add(mediumRadioButton);
        sizeButtonGroup.add(bigRadioButton);
        sizeButtonGroup.add(noSexRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(noSexRadioButton);


        ButtonTextPanel size = new ButtonTextPanel(new JLabel(configVM.SIZE_LABEL),
                sizeGroup);
        ButtonTextPanel sex = new ButtonTextPanel(new JLabel(configVM.SEX_LABEL),
                sexGroup);
        cp.add(size);
        cp.add(sex);



        //create confirm button and container panel
        JPanel buttons = new JPanel();
        JButton confirm = new JButton(configVM.CONFIRM_BUTTON);
        buttons.add(confirm);
        cp.add(buttons);
        //inputfield settings
        usernameInputfield.setEditable(false);
        usernameInputfield.setEnabled(false);

        //defaulte preference setttings
         preferredSize = configVM.NONE;
         preferredSex = configVM.NONE;

        //creaet bottom redirect view
        MyProfileRDRView redirect = new MyProfileRDRView(
                myProfileViewModel.getMyProfileRDRViewModel(),
                browsePageRDRController,
                favPetRDRController,
                myPetRDRController
                );
        add(redirect, BorderLayout.SOUTH);

        //add everything to the big panel
        add(cp, BorderLayout.CENTER);
        //listeners
        imageLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked");
                dialog = new JDialog();
                dialog.setContentPane(new ChangeImageView(usernameInputfield.getText(), changeController));
                dialog.setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //Size related buttons

        //small
        smallRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(smallRadioButton.isSelected()) {
                            preferredSize = configVM.SMALL;
                        }

                    }
                }
        );

        //medium
        mediumRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(mediumRadioButton.isSelected()) {
                           preferredSize = configVM.MEDIUM;
                        }
                    }
                }
        );

        //large
        bigRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(bigRadioButton.isSelected()) {
                         preferredSize = configVM.LARGE;
                        }

                    }
                }
        );
        //no preference
        noSizeRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(noSizeRadioButton.isSelected()) {
                            preferredSize = configVM.NONE;
                        }
                    }
                }
        );


        //sex related buttons
        //female
        femaleRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(femaleRadioButton.isSelected()) {
                            preferredSex = configVM.FEMALE;
                        }
                    }
                }
        );
        //male
        maleRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(maleRadioButton.isSelected()) {
                          preferredSex = configVM.MALE;
                        }
                    }
                }
        );


        //no preference
        noSexRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (noSexRadioButton.isSelected()) {
                            preferredSize = configVM.NONE;
                        }
                    }
                }
        );

        //confirm
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInfo();
            }
        });

}




    @Override
    public void actionPerformed(ActionEvent e) {

    }



    private void saveInfo() {
        String username = usernameInputfield.getText();
        String bio = bioInputfield.getText();
        String address = addressinputfield.getText();

        if (bio.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ENTER ALL INFORMATION", "FAILED", JOptionPane.ERROR_MESSAGE);
            return;
        }

        configController.execute(username, address, bio, preferredSize, preferredSex);

    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getSource().equals(configVM)){
            ConfigProfileState state = (ConfigProfileState) evt.getNewValue();
            if (state.getError() == null){
                usernameInputfield.setText(state.getUserName());
                addressinputfield.setText(state.getAddress());
                bioInputfield.setText(state.getBio());
                preferredSex = state.getPreferredSex();
                preferredSize = state.getPreferredSize();

            }
            else{
                JOptionPane.showMessageDialog(this, state.getError());
            }
        }
        if (evt.getSource().equals(changeVM)) {
            ChangeProfileState state = (ChangeProfileState) evt.getNewValue();
            if (state.getError().isEmpty()) {
                imageLabel.setIcon(new ImageIcon(state.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)
                ));
                imageLabel.revalidate();
                imageLabel.repaint();
                if (!(dialog == null)){
                    dialog.dispose();
                }


            } else {
                JOptionPane.showMessageDialog(this, state.getError());
            }
        }
    }
    public static void main(String[] args) {
        JFrame application = new JFrame("MyProfile");



    }
}
