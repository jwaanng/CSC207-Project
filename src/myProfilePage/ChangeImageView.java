package myProfilePage;

import myProfilePage.changeProfile.ChangeProfileController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ChangeImageView extends JPanel {
    private final JLabel text = new JLabel("Drop your new profile label to here!");
    private final JFileChooser fileChooser = new JFileChooser();
    private final ChangeProfileController controller;
    public ChangeImageView(String username, ChangeProfileController changeProfileController){
        controller = changeProfileController;
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(filter);
        add(text);
        add(fileChooser);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            controller.execute(username, selectedFile);
            JOptionPane.showMessageDialog(this, "File is uploaded!");
        }
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        text.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 30));
        SwingUtilities.getWindowAncestor(fileChooser).dispose();

        }

}
