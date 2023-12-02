package login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The {@code LGView} class represents the graphical user interface for the login feature,
 * including text fields for username and password, login and cancel buttons, and associated
 * event listeners.
 */
public class LGView extends JPanel implements PropertyChangeListener {

    private final LGController controller;

    private final LGViewModel viewModel;
    private final JTextField usernameField;

    private final JTextField passwordField;

    private final JButton login;

    private final JButton cancel;

    /**
     * Constructs an {@code LGView} instance with the specified controller and view model.
     *
     * @param controller The controller associated with the login view.
     * @param vm          The view model associated with the login view.
     */
    public LGView(LGController controller, LGViewModel vm) {
        this.controller = controller;
        this.viewModel = vm;
        viewModel.addPropertyChangeListener(this);

        usernameField = new JTextField();
        passwordField = new JTextField();
        login = new JButton(viewModel.LOGIN_LABEL);
        cancel = new JButton(viewModel.CANCEL_LABEL);

        // TODO: Add login page design layout here;

        usernameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LGState currState = viewModel.getState();
                currState.setUsername(usernameField.getText() + e.getKeyChar());
                viewModel.setState(currState);
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

        // TODO: Implement CANCEL, expected Behavior: go back to signup view
    }

    /**
     * Detects property change and determines acction
     *
     * @param evt The property change event to listen for
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LGState currState = (LGState) evt.getNewValue();
        if (currState.getError() != null) {
            JOptionPane.showMessageDialog(this, currState.getError());
        }
    }
}