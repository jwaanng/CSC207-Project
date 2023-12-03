package signupPage;

import configProfile.SignupController;
import signupPage.SignupViewModel;
import signupPage.cancel.CancelController;
import signupPage.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements PropertyChangeListener {

    private JPanel registerPanel;
    private JLabel usernameLabel;
    private JTextField usernameTF;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JPasswordField passwordTf;
    private JPasswordField confirmPasswordTf;
    private JButton signUpButton;
    private JButton cancelButton;
    private JTextField addressTf;
    private JLabel addressLabel;
    private JTextField instagramTf;
    private final SignupController signupController;
    private final CancelController cancelController;
    private final SignupViewModel signupViewModel;

    public SignupView(
            SignupViewModel signupViewModel,
            SignupController signupController,
            CancelController cancelController
    ){
        // constructor
//        setTitle("Create an account now!");  // this is the text at the top of the window
//        setContentPane(RegisterPanel);
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
        this.cancelController = cancelController;
        setMinimumSize(new Dimension(500, 450));
        setLayout(new GridBagLayout());
//        setModal(true);
//        setLocationRelativeTo(parent);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(registerPanel,gbc);



        signupViewModel.addPropertyChangeListener(this);

        signUpButton.addActionListener(new ActionListener() {
            // action listener for when u click on 'sign up' button... -jw
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            // when 'cancel' is clicked, the app closes (hence dispose())
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelController.execute();
            }
        });

//        signupViewModel.addPropertyChangeListener(evt -> {
//            System.out.println("HI" + evt.getPropertyName());
//            if ("signupState".equals(evt.getPropertyName())) {
//                propertyChange(evt);
//            }
//        }
//        );

        setVisible(true); // makes this view visible as a popup
    }

    private void registerUser() {
        // TODO1 done jw: Case for if username already exists
        // TODO2 done jw: maybe use a controller for if statements idk :c
        // TODO3 done jw: implement a 'add user to database' method (15:59)

        // getting the inputs from text fields
        String username = usernameTF.getText();
        String password = String.valueOf(passwordTf.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordTf.getPassword());
        String address = String.valueOf(addressTf.getText());
        String instagram = String.valueOf(instagramTf.getText());

        SignupState currentState = this.signupViewModel.getState();

        currentState.setUsername(username);
        currentState.setPassword(password);
        currentState.setRepeatPassword(confirmPassword);
        currentState.setAddress(address);
        currentState.setInstagram(instagram);


        
//        System.out.println(username);

        // if one of the fields are empty
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ENTER ALL INFORMATION", "FAILED", JOptionPane.ERROR_MESSAGE);
        }


        // signup use case controller checks for things and pushes to db
        signupController.execute(username, password, confirmPassword, address, instagram);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().equals(signupViewModel)) {
            SignupState state = (SignupState) evt.getNewValue();
            if (state.getError() != null) {
                System.out.println(state.getError());
                JOptionPane.showMessageDialog(this, state.getError());
            }
        }
    }


    public static void main(String[] args) {



    }

    // TODOdone: no popup for when cases fail
}