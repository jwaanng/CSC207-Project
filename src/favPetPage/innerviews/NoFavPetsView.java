package favPetPage.innerviews;

import favPetPage.browsePet.BPController;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoFavPetsView extends JPanel{
    private final NoFavPetDisplayViewModel vm;
    private final JButton browsePet;

    private final BPController controller;

    public NoFavPetsView(NoFavPetDisplayViewModel noFavPetDisplayViewModel, BPController browsePetController){
        vm = noFavPetDisplayViewModel;
        controller = browsePetController;
        setLayout(new BorderLayout());
        browsePet = new JButton(vm.BROWSE_PET);
        add(browsePet);
        browsePet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO debugging
                System.out.println(vm.BROWSE_PET);
                //controller.execute();
            }
        });
    }
}
