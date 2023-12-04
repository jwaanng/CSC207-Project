package favPetPage.innerviews;

import favPetPage.browsePet.BrowseController;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * What user see when they don't have any favorite pets
 */
public class NoFavPetsView extends JPanel {
    private final NoFavPetDisplayViewModel vm;
    private final JButton browsePet;
    private final BrowseController controller;
    private final Image background;

    /**
     * Construct a new NoFavPetsView object
     *
     * @param noFavPetDisplayViewModel the {@link NoFavPetDisplayViewModel} that stores all the information this view needs
     *                                 to display
     * @param browsePetController      the {@link BrowseController}that initiates the browsePet usecase
     */
    public NoFavPetsView(NoFavPetDisplayViewModel noFavPetDisplayViewModel, BrowseController browsePetController) {

        vm = noFavPetDisplayViewModel;
        controller = browsePetController;
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);
        browsePet = new JButton(vm.BROWSE_PET);
        browsePet.setBackground(Color.darkGray);
        browsePet.setBorder(new EmptyBorder(10, 10, 10, 10));
        browsePet.setOpaque(true);
        browsePet.setMargin(new Insets(0, 0, 0, 0));

        browsePet.setFont(new Font("Garamond", Font.BOLD, 20));
        browsePet.setLayout(new BorderLayout());
        browsePet.setForeground(Color.white);
        background = new ImageIcon(getClass().getResource("/favPetPage/NoFavPet.png")).getImage();
        add(browsePet);
        browsePet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browsePet.setForeground(Color.lightGray);
                controller.execute();
            }
        });
        browsePet.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                browsePet.setForeground(Color.white);
            }
        });
    }

}
