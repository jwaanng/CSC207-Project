package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements PropertyChangeListener {
    private JPanel loginPanel;
    private JLabel loginLabel;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JPasswordField pleaseEnterPasswordHerePasswordField;
    private JLabel passwordLabel;
    private JButton enterButton;
    private LoginViewModel loginViewModel;


    private final LoginController loginController;

    public LoginView(LoginViewModel loginViewModel, LoginController loginController) {
        // constructor
        setMinimumSize(new Dimension(500, 450));
        setLayout(new GridBagLayout());
        this.loginViewModel = loginViewModel;
        this.loginController = loginController;
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(loginPanel, gbc);
        setOpaque(true);
        loginViewModel.addPropertyChangeListener(this);
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState currstate = (LoginState) evt.getNewValue();
        if (currstate.getError() != null) {
            JOptionPane.showMessageDialog(this, currstate.getError());
        }
    }


//    public static void main(String[] args) {
//        ConfigProfileViewModel configProfileViewModel = new ConfigProfileViewModel();
//        LoginView loginView = new LoginView(null, new LGController(new LGUCI(new LGPresenter(new LGViewModel(), new FavPetPageViewModel(), new ViewModelManager(), configProfileViewModel), new CommonUserDataAccessObject(), new PetProfileDataAccessObject())));
//    }
}
