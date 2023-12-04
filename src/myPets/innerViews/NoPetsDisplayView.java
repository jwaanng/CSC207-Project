package myPets.innerViews;

import dataAccessObject.PetProfileDataAccessInterface;
import myPets.InnerViewModelManager;
import myPets.createRedirect.CreateRedirectController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myPets.noMyPets.NoMyPetsDisplayViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class NoPetsDisplayView extends JPanel {
    private final NoMyPetsDisplayViewModel vm;
    private final JButton createPet;
    public final String viewName = NoMyPetsDisplayViewModel.TITLE_LABEL;
    //private final Image background;

    public NoPetsDisplayView(InnerViewModelManager innerViewModelManager, NoMyPetsDisplayViewModel noMyPetsDisplayViewModel, PetProfileDataAccessInterface petProfileDataAccessObject, MyPetRDRController myPetRDRController, CreateRedirectController createRedirectController){

        vm = noMyPetsDisplayViewModel;
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);
        createPet = new JButton(vm.CREATE_PET);
        createPet.setBackground(Color.darkGray);
        createPet.setBorder(new EmptyBorder(10,10,10,10));
        createPet.setOpaque(true);
        createPet.setMargin(new Insets(0, 0, 0, 0));

        createPet.setFont(new Font("Garamond", Font.BOLD, 20));
        createPet.setLayout(new BorderLayout());
        createPet.setForeground(Color.white);
        //background = new ImageIcon(getClass().getResource("/favPetPage/NoFavPet.png")).getImage();
        add(createPet);
        createPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CreatePetView createPetView = CreateUseCaseFactory.create(innerViewModelManager, new MyPetsViewModel(), new CreateViewModel(), petProfileDataAccessObject, MyPetRDRController);

                createRedirectController.execute();
                System.out.println(vm.CREATE_PET);
                //controller.execute();
                //CreateViewModel cvm = new CreateViewModel();
                //CreatePetView cv = new CreatePetView();
                //innerViewModelManager.setActiveViewName(createPetView.viewName);
                //innerViewModelManager.firePropertyChange();



            }
        });
        createPet.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                createPet.setForeground(Color.white);
            }
        });
    }

}
