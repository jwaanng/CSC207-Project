package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwipePageView extends JFrame {
    private JButton likeButton;
    private JPanel mainPanel;

    public SwipePageView(){
        setContentPane(mainPanel);
        setTitle("Find a pet!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SwipePageView.this, "You have liked this pet!");
                // INSERT LIKE BUTTON ACTION HERE...
                //
                //
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwipePageView::new);
    }
}