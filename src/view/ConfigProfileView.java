package view;

import myProfilePage.changeProfile.ChangeProfileController;
import myProfilePage.changeProfile.ChangeProfileState;
import myProfilePage.changeProfile.ChangeProfileViewModel;
import myProfilePage.configProfile.*;

import javax.swing.*;
import javax.swing.ButtonGroup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Enumeration;

public class ConfigProfileView extends JDialog implements PropertyChangeListener {
//    private JTextField nameTf;
    private JTextField addressTf;
    private JTextField bioTf;
    private JLabel titleTf;
//    private JLabel name;
    private JButton confirmButton;
    private JPanel configPanel;
    private JRadioButton smallRadioButton;
    private JRadioButton bigRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton maleRadioButton;
    private JRadioButton bothRadioButton;
    private ButtonGroup sizeGroup;
    private ButtonGroup sexGroup;

    private final ConfigProfileController configProfileController;
    private final ChangeProfileController changeProfileController;
    private final ConfigProfileViewModel configProfileViewModel;
    private final ChangeProfileViewModel changeProfileViewModel;

    public ConfigProfileView(JFrame parent, ConfigProfileController configProfileController,
                             ChangeProfileController changeProfileController,
                             ConfigProfileViewModel configProfileViewModel,
                             ChangeProfileViewModel changeProfileViewModel){
        // constructor
        super(parent);

        // Radio button group for size pref
        sizeGroup = new ButtonGroup();
        sizeGroup.add(smallRadioButton);
        sizeGroup.add(mediumRadioButton);
        sizeGroup.add(bigRadioButton);

        // Radio button group for sex pref
        sexGroup = new ButtonGroup();
        sexGroup.add(femaleRadioButton);
        sexGroup.add(maleRadioButton);
        sexGroup.add(bothRadioButton);

        // rest of constructor
        setTitle("Set up some info!");  // this is the text at the top of the window
        setContentPane(configPanel);
        setMinimumSize(new Dimension(1000, 700));
        setModal(true);
        setLocationRelativeTo(parent);

        this.configProfileController = configProfileController;
        this.changeProfileController =changeProfileController;
        this.configProfileViewModel = configProfileViewModel;
        this.changeProfileViewModel = changeProfileViewModel;

        configProfileViewModel.addPropertyChangeListener(this);
        changeProfileViewModel.addPropertyChangeListener(this);

        confirmButton.addActionListener(new ActionListener() {
            // Action listener for clicking 'confirm'
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("HIIIIIIII");
                saveInfo();
            }
        });

        setVisible(true); // makes this view visible when running
    }

    private void saveInfo() {
        String bio = bioTf.getText();
        String address = addressTf.getText();
//        String name = nameTf.getText();
        String preferredSize = getSelectedButtonText(sizeGroup);
        String preferredSex = getSelectedButtonText(sexGroup);

        ConfigProfileState currentState = this.configProfileViewModel.getState();
//        String username = currentState.getUsername();

//        currentState.setUsername(username);
        currentState.setAddress(address);
        currentState.setBio(bio);
//        currentState.setSize(preferredSize);
//        currentState.setSex(preferredSex);

        System.out.println("CONFIG DSLJFKLSDJF: " + currentState.toString());

        // TODO: saving the info that was entered onto either a csv or db or smth idk ... -jw
        // TODO 2: make this auto relay back to the 'mainView' page if it saves correctly
        // TODO3 done by jw: 'bio' has max character amount of 150
        // TODO4 done by jw: 'name' can't contain any invalid characters (no symbols)
//        configProfileController.execute(username, address, bio, preferredSize, preferredSex);
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().equals(configProfileViewModel)) {
            System.out.println("VIEW: property change received");
            ConfigProfileState state = (ConfigProfileState) evt.getNewValue();
            if (state.getError() != null) {
                System.out.println(state.getError());
                JOptionPane.showMessageDialog(this, state.getError());
            }
        }

    }

    public static void main(String[] args) {
//        ConfigProfileViewModel configProfileViewModel = new ConfigProfileViewModel();
//        ConfigProfilePresenter configProfilePresenter = new ConfigProfilePresenter(configProfileViewModel, new ViewModelManager());
//        ConfigProfileUCI configProfileInteractor = new ConfigProfileUCI(new CommonUserDataAccessObject(), configProfilePresenter, configProfilePresenter);
//        ConfigProfileController configProfileController = new ConfigProfileController(configProfileInteractor);
//
//        ConfigProfileView configProfileView = new ConfigProfileView(null, configProfileController, configProfileViewModel);
    }

}
