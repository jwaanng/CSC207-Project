package view;

import javax.swing.*;

/**
 * The {@code ButtonTextPanel} class is a custom Swing JPanel that combines a JLabel and another JPanel.
 * It provides a convenient way to organize and display a label and an associated panel within a single panel.
 *
 * This class is typically used for creating components with a label and an associated interactive panel,
 * such as a button or input field.
 */
public class ButtonTextPanel extends JPanel {

    /**
     * Constructs a {@code ButtonTextPanel} with the specified label and panel.
     *
     * @param label The label to be displayed.
     * @param panel The panel to be associated with the label.
     */
    public ButtonTextPanel(JLabel label, JPanel panel) {
        this.add(label);
        this.add(panel);
    }
}