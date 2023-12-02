package view;

import javax.swing.*;

public class ButtonTextPanel extends JPanel {
    ButtonTextPanel(JLabel label, JPanel panel) {
        this.add(label);
        this.add(panel);
    }
}
