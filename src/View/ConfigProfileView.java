package View;

import javax.swing.*;
import javax.swing.ButtonGroup;
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
    private JRadioButton smallRadioButton;
    private JRadioButton bigRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton maleRadioButton;
    private JRadioButton bothRadioButton;
    private ButtonGroup sizeGroup;
    private ButtonGroup sexGroup;

    public ConfigProfileView(JFrame parent){
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
        String preferredSize = sizeGroup.getSelection().toString();

//        JOptionPane.showMessageDialog(this, preferredSize, "FAILED", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(this, address, "FAILED", JOptionPane.ERROR_MESSAGE);

        // TODO: saving the info that was entered onto either a csv or db or smth idk ... -jw
        // TODO 2: make this auto relay back to the 'mainView' page if it saves correctly
        // TODO3 done by jw: 'bio' has max character amount of 150
        // TODO4 done by jw: 'name' can't contain any invalid characters (no symbols)
    }

    public static void main(String[] args) {
        ConfigProfileView configProfileView = new ConfigProfileView(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
