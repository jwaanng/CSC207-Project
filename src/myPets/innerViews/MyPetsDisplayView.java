package myPets.innerViews;

import favPetPage.updateAFavPet.UpdateState;
import myPets.createNewDog.CreateState;
import myPets.createNewDog.CreateViewModel;
import myPets.createRedirect.CreateRedirectController;
import myPets.createRedirect.CreateRedirectViewModel;
import myPets.deleteMyPet.DeleteMyPetController;
import myPets.deleteMyPet.DeleteMyPetState;
import myPets.deleteMyPet.DeleteMyPetViewModel;
import myPets.myPetDisplayRedirect.MyPetRedirectViewModel;
import myPets.updateMyPet.UpdateMyPetsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyPetsDisplayView extends JPanel implements PropertyChangeListener {
    private final HashMap<Integer, OnePetProfile> id_to_PetProfile = new HashMap<>();
    //private final ViewThisController viewController;
    private final DeleteMyPetController deleteController;

    private final CreateViewModel createVM;
    private final DeleteMyPetViewModel deleteVM;
    private final UpdateMyPetsViewModel updateVM;
    private final MyPetRedirectViewModel myPetRedirectVM;
    private final CreateRedirectViewModel createRedirectVM;
    private final GridBagConstraints gbc;
    private final JButton createAnother;
    private final CreateRedirectController createRedirectController;
    private final ActionListener deleteListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO debugging
            System.out.println("delete petProfile with id" + e.getActionCommand());
            int idNum = Integer.parseInt(e.getActionCommand());
            id_to_PetProfile.get(idNum).deletePet();
            deleteController.execute("Bobby", idNum);
        }
    };;
    private final ActionListener viewProfileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO debugging
            System.out.println("view petProfile with id" + e.getActionCommand());
            //viewController.execute(Integer.getInteger(e.getActionCommand()));

        }
    };
    public MyPetsDisplayView(CreateViewModel createViewModel,
                             UpdateMyPetsViewModel updateViewModel,
                             DeleteMyPetViewModel deleteViewModel,
                             DeleteMyPetController deletePetController,
                             MyPetRedirectViewModel myPetRedirectViewModel,
                             CreateRedirectViewModel createRedirectViewModel,
                             CreateRedirectController createRedirectController){
        setLayout(new GridBagLayout());

        this.createRedirectController = createRedirectController;
        deleteController = deletePetController;
        //viewController = viewThisPetController;

        createRedirectVM = createRedirectViewModel;
        createRedirectVM.addPropertyChangeListener(this);
        myPetRedirectVM = myPetRedirectViewModel;
        myPetRedirectVM.addPropertyChangeListener(this);
        createVM = createViewModel;
        createVM.addPropertyChangeListener(this);
        updateVM = updateViewModel;
        updateVM.addPropertyChangeListener(this);
        deleteVM = deleteViewModel;
        deleteVM.addPropertyChangeListener(this);
        //CommonLayoutSetUp
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5); //space between each profile
        gbc.fill = GridBagConstraints.NONE; //not going to assign more space than necessary;
        gbc.weightx = 0; //don't take extra space
        gbc.weighty = 0;

        createAnother = new JButton("Create");
        add(createAnother);
        setVisible(true);

        createAnother.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource().equals(createAnother)){
                    createRedirectController.execute();
                    System.out.println("create another pet");
                }
            }
        });

    }

    private void repaintGraphicsAddOrDelete(){
        //maintain no gap in layout
        removeAll(); //remove all profiles
        List<Integer> petIds = new ArrayList<Integer>(id_to_PetProfile.keySet());
        int totalProfiles = petIds.size();
        int reqCol = createVM.PROFILE_DISPLAY_IN_ONE_ROW;
        for (int profilePos = 0; profilePos < totalProfiles + 1; profilePos++){
            if (profilePos == 0){
                gbc.gridx = 0;
                gbc.gridy = 0;
                createAnother.setSize(100,100);
                add(createAnother, gbc);
            }else {
                int id = petIds.get(profilePos - 1);
                gbc.gridx = profilePos % reqCol;
                gbc.gridy = profilePos / reqCol;
                add(id_to_PetProfile.get(id), gbc);
            }
        }
        revalidate();
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == myPetRedirectVM) {
            CreateState currState = createVM.getState();
            List<Integer> petIds = currState.getKeyEntries();
            for (int id : petIds) {
                id_to_PetProfile.put(id, new OnePetProfile(
                                id,
                                currState.getName(id),
                                currState.getImageFile(),
                                deleteListener, viewProfileListener,
                                createVM.SIZE_OF_ONE_PET_PROFILE_IN_PIXEL
                        )
                );
                System.out.println("petProfileID list");
                //maintain the list of pet profiles
            }

            repaintGraphicsAddOrDelete();
        }
        else if (evt.getSource() == updateVM) {
            UpdateState currState = (UpdateState) evt.getNewValue();
            List<Integer> petIds = (List<Integer>) currState.getKeyEntries();
            for (int petId : petIds) {
                OnePetProfile curr = id_to_PetProfile.get(petId);
                curr.updatePhoto(currState.getPhoto(petId));
                curr.updateName(currState.getName(petId));
                curr.refresh();
            }
        }
        else if (evt.getSource() == deleteVM) {
            DeleteMyPetState state = deleteVM.getState();
            for (int petId : state.getIds()) {
                id_to_PetProfile.remove(petId);
                System.out.println(petId);
            }
            repaintGraphicsAddOrDelete();
            System.out.println("success deleted");
            System.out.println(id_to_PetProfile.size());
        }
    }
}
