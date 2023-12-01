package view;

import dataAcessObject.CommonUserDataAccessObject;
import entity.user.AppUserFactory;
import configProfile.SignupController;
import login.LGViewModel;
import signUp.SignupPresenter;
import signUp.SignupState;
import signUp.SignupViewModel;
import viewModel.ViewModelManager;
import usecase.SignUp.SignupInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RegisterView extends JDialog implements PropertyChangeListener {

    private JPanel RegisterPanel;
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

    private final SignupController signupController;
    private final SignupViewModel signupViewModel;

    public RegisterView(JFrame parent, SignupController signupController, SignupViewModel signupViewModel){
        // constructor
        super(parent);
        setTitle("Create an account now!");  // this is the text at the top of the window
        setContentPane(RegisterPanel);
        setMinimumSize(new Dimension(500, 450));
        setModal(true);
        setLocationRelativeTo(parent);

        this.signupController = signupController;
        this.signupViewModel = signupViewModel;


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
                dispose();
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

        SignupState currentState = this.signupViewModel.getState();

        currentState.setUsername(username);
        currentState.setPassword(password);
        currentState.setRepeatPassword(confirmPassword);
        currentState.setAddress(address);

        System.out.println("REG USER: " + currentState.toString());

        
//        System.out.println(username);

        // if one of the fields are empty
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ENTER ALL INFORMATION", "FAILED", JOptionPane.ERROR_MESSAGE);
            return;
        }

//        // if the passwords don't match
//        if (!password.equals(confirmPassword)) {
//            JOptionPane.showMessageDialog(this, "MAKE SURE PASSWORD MATCHES", "FAILED", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

        // signup use case controller checks for things and pushes to db
        signupController.execute(username, password, confirmPassword, address);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().equals(signupViewModel)) {
            System.out.println("VIEW: property change received");
            SignupState state = (SignupState) evt.getNewValue();
            if (state.getError() != null) {
                System.out.println(state.getError());
                JOptionPane.showMessageDialog(this, state.getError());
            }
        }
    }


    public static void main(String[] args) {
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupPresenter signupPresenter = new SignupPresenter(signupViewModel, new LGViewModel(), new ViewModelManager());
        SignupInteractor signupInteractor = new SignupInteractor(new CommonUserDataAccessObject(), signupPresenter, new AppUserFactory());
        SignupController signupController = new SignupController(signupInteractor);

        RegisterView registerView = new RegisterView(null, signupController, signupViewModel);
    }

    // TODO: no popup for when cases fail
}