package favPetPage.innerviews;

import favPetPage.deleteAFavPet.DeleteController;
import favPetPage.addAFavPet.AddState;
import favPetPage.deleteAFavPet.DeleteState;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import favPetPage.viewThisPetProfile.ViewThisController;
import favPetPage.addAFavPet.AddViewModel;
import favPetPage.deleteAFavPet.DeleteViewModel;
import favPetPage.updateAFavPet.UpdateState;
import favPetPage.updateAFavPet.UpdateViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavPetDisplayView extends JPanel implements PropertyChangeListener {
    private final HashMap<Integer, OnePetProfile> id_to_PetProfile= new HashMap<>();
    private final ViewThisController viewController;
    private final DeleteController deleteController;

    private final AddViewModel addVM;
    private final DeleteViewModel deleteVM;
    private final UpdateViewModel updateVM;
    private final NoFavPetDisplayViewModel noPetVM;
    private final GridBagConstraints gbc;
    private final ActionListener unLikeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO debugging
            System.out.println("unlike petProfile with id" + e.getActionCommand());
            id_to_PetProfile.get(Integer.parseInt(e.getActionCommand())).unlike();
            //deleteController.execute(vm.getState().getUsername(), Integer.getInteger(e.getActionCommand()));
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
    public FavPetDisplayView(AddViewModel addViewModel,
                             UpdateViewModel updateViewModel,
                             DeleteViewModel deleteViewModel,
                             NoFavPetDisplayViewModel noFavPetDisplayViewModel,
                             DeleteController deletePetController,
                             ViewThisController viewThisPetController){
        setLayout(new GridBagLayout());
        deleteController = deletePetController;
        viewController = viewThisPetController;
        addVM = addViewModel;
        addVM.addPropertyChangeListener(this);
        updateVM = updateViewModel;
        updateVM.addPropertyChangeListener(this);
        deleteVM = deleteViewModel;
        deleteVM.addPropertyChangeListener(this);
        noPetVM = noFavPetDisplayViewModel;
        //CommonLayoutSetUp
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5); //space between each profile
        gbc.fill = GridBagConstraints.NONE; //not going to assign more space than necessary;
        gbc.weightx = 0; //don't take extra space
        gbc.weighty = 0;
    }

    private void repaintGraphicsAddOrDelete(){
        //maintain no gap in layout
        removeAll(); //remove all profiles
        List<Integer> petIds = new ArrayList<Integer>(id_to_PetProfile.keySet());
        int totalProfiles = petIds.size();
        int reqCol = addVM.PROFILE_DISPLAY_IN_ONE_ROW;
        for (int profilePos = 0; profilePos < totalProfiles; profilePos++){
            int id = petIds.get(profilePos);
            gbc.gridx = profilePos % reqCol;
            gbc.gridy = profilePos / reqCol;
            add(id_to_PetProfile.get(id), gbc);
        }
        revalidate();
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == addVM) {
            AddState currState = (AddState) evt.getNewValue();
            List<Integer> petIds = currState.getKeyEntries();
            for (int id : petIds) {
                id_to_PetProfile.put(id, new OnePetProfile(
                                id,
                                currState.getName(id),
                                currState.getPhoto(id),
                                unLikeListener, viewProfileListener,
                                addVM.SIZE_OF_ONE_PET_PROFILE_IN_PIXEL
                        )
                );
                //maintain the list of pet profiles
            }
            repaintGraphicsAddOrDelete();
        }
        else if (evt.getSource() == updateVM) {
            UpdateState currState = (UpdateState) evt.getNewValue();
            List<Integer> petIds = currState.getKeyEntries();
            for (int petId : petIds) {
                OnePetProfile curr = id_to_PetProfile.get(petId);
                curr.updatePhoto(currState.getPhoto(petId));
                curr.updateName(currState.getName(petId));
                curr.refresh();
            }
        }
        else if (evt.getSource() == deleteVM) {
            DeleteState state = (DeleteState) evt.getNewValue();
            for (int petId : state.getIds()) {
                id_to_PetProfile.remove(petId);
            }
            repaintGraphicsAddOrDelete();
            if (id_to_PetProfile.isEmpty()){
                noPetVM.firePropertyChanged(); //no more profiles left
            }
        }
    }
}
