package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigProfileView extends JDialog{
    private JTextField nameTf;
    private JTextField addressTf;
    private JTextField bioTf;
    private JLabel titleTf;
    private JLabel name;
    private JButton confirmButton;
    private JPanel configPanel;

    public ConfigProfileView(JFrame parent){
        // constructor
        super(parent);
        setTitle("Set up some info!");  // this is the text at the top of the window
        setContentPane(configPanel);
        setMinimumSize(new Dimension(1000, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setVisible(true); // makes this view visible when running

        confirmButton.addActionListener(new ActionListener() { // Action listener for clicking 'confirm'
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInfo();
            }
        });
    }

    private void saveInfo() {
        String bio = bioTf.getText();
        String address = addressTf.getText();
        String name = nameTf.getName();

        // TODO: saving the info that was entered onto either a csv or db or smth idk ... -jw
        // TODO 2: make this auto relay back to the 'mainView' page if it saves correctly
        // TODO 3: 'bio' has max character amount of 150
        // TODO 4: 'name' can't contain any invalid characters (no symbols)
    }

    public static void main(String[] args) {
        ConfigProfileView configProfileView = new ConfigProfileView(null);
    }

}
