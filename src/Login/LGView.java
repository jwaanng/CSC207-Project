package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LGView extends JPanel implements PropertyChangeListener {

    private final LGController controller;
    private final LGViewModel viewModel;
    //Username textField
    private final JTextField usernameField;
    //Password textField
    private final JTextField passwordField;
    //Login Button
    private final JButton login;
    //Cancel Button
    private final JButton cancel;

    public LGView(LGController controller, LGViewModel vm) {
        this.controller = controller;
        this.viewModel = vm;
        viewModel.addPropertyChangeListener(this);
        //TODO add username char limit
        usernameField = new JTextField();
        //TODO add password char limit
        passwordField = new JTextField();
        login = new JButton(viewModel.LOGIN_LABEL);
        cancel = new JButton(viewModel.CANCEL_LABEL);

        //TODO add login page design layout here;


        usernameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                 LGState currState = viewModel.getState();
                 currState.setUsername(usernameField.getText() + e.getKeyChar());
                 viewModel.setState(currState); //safety procedure?

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LGState currState = viewModel.getState();
                currState.setPassword(passwordField.getText() + e.getKeyChar());
                viewModel.setState(currState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    controller.execute(viewModel.getState().getUsername(), viewModel.getState().getPassword());
            }
        });

        //TODO IMPLEMENT CANCEL, expected Behavior: go back to signup view

    }




    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            LGState currstate = (LGState) evt.getNewValue();
            if(currstate.getError()!= null){
                JOptionPane.showMessageDialog(this, currstate.getError());
            }
    }
}
