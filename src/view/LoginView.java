package view;

import dataAcessObject.CommonUserDataAccessObject;
import dataAcessObject.PetProfileDataAccessObject;
import viewModel.ViewModelManager;
import login.LGController;
import login.LGPresenter;
import login.LGUCI;
import login.LGViewModel;
import favPetPage.FavPetPageViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JDialog{
    private JLabel LogInLabel;
    private JLabel UsernameLabel;
    private JTextField usernameTextField;
    private JPasswordField pleaseEnterPasswordHerePasswordField;
    private JLabel PasswordLabel;
    private JButton enterButton;
    private JPanel LoginPanel;

    private final LGController loginController;

    public LoginView(JFrame parent, LGController loginController){
        // constructor
        super(parent);
        setTitle("Log In!!!");  // this is the text at the top of the window
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(500, 450));
        setModal(true);
        setLocationRelativeTo(parent);

        this.loginController = loginController;
        enterButton.addActionListener(new ActionListener() {
            // action listener for when u click on 'sign up' button... -jw
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }

            // TODOdone jw: make enter function
        });

        setVisible(true); // makes this view visible as a popup
    }
    private void loginUser() {
        // getting the inputs from text fields
        String username = usernameTextField.getText();
        String password = String.valueOf(pleaseEnterPasswordHerePasswordField.getPassword());

        // if one of the fields are empty
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ENTER ALL INFORMATION", "FAILED", JOptionPane.ERROR_MESSAGE);
            return;
        }

        loginController.execute(username, password);

    }


    public static void main(String[] args) {
        LoginView loginView = new LoginView(null, new LGController(new LGUCI(new LGPresenter(new LGViewModel(), new FavPetPageViewModel(), new ViewModelManager()), new CommonUserDataAccessObject(), new PetProfileDataAccessObject())));
    }
}
