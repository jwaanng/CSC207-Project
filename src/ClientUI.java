import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientUI extends JFrame {
    public ClientUI() {
        setTitle("Furry App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));
        add(mainPanel);

        JButton viewMessages = new JButton("Messages");
        viewMessages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
                System.out.println("clicked messages button");
            }
        });
        mainPanel.add(viewMessages);

        JButton viewProfile = new JButton("Profile");
        viewProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
                System.out.println("clicked Profile button");
            }
        });
        mainPanel.add(viewProfile);

        JButton viewSettings = new JButton("Settings");
        viewSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
                System.out.println("clicked Settings button");
            }
        });
        mainPanel.add(viewSettings);

        JButton viewMain = new JButton("Main");
        viewMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
                System.out.println("clicked Main button");
            }
        });
        mainPanel.add(viewMain);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClientUI().setVisible(true);
        });
    }
}