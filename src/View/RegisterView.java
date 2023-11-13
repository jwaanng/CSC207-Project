package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JDialog{

    private JPanel RegisterPanel;
    private JTextField usernameTF;
    private JPasswordField passwordTf;
    private JPasswordField confirmPasswordTf;
    private JButton signUpButton;
    private JButton cancelButton;

    public RegisterView(JFrame parent){
        // constructor
        super(parent);
        setTitle("Create an account now!");  // this is the text at the top of the window
        setContentPane(RegisterPanel);
        setMinimumSize(new Dimension(500, 450));
        setModal(true);
        setLocationRelativeTo(parent);
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

        setVisible(true); // makes this view visible as a popup
    }

    private void registerUser() {
        // TODO: Case for if username already exists
        // TODO 2: maybe use a controller for if statements idk :c
        // TODO 3: implement a 'add user to database' method (15:59)

        // getting the inputs from text fields
        String username = usernameTF.getText();
        String password = String.valueOf(passwordTf.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordTf.getPassword());

        // if one of the fields are empty
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ENTER ALL INFORMATION", "FAILED", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // if the passwords don't match
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "MAKE SURE PASSWORD MATCHES", "FAILED", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }


//    public static void main(String[] args) {
//        RegisterView registerView = new RegisterView(null);
//    }
}