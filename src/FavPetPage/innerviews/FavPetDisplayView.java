package FavPetPage.innerviews;

import FavPetPage.DeleteAFavPet.DFPController;
import FavPetPage.FavPetDisplayState;
import FavPetPage.ViewThisPetProfile.VTPController;
import FavPetPage.innerviewmodels.FavPetDisplayViewModel;
import FavPetPage.innerviews.OnePetProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.List;

public class FavPetDisplayView extends JPanel implements PropertyChangeListener {
    private final HashMap<Integer, OnePetProfile> id_to_PetProfile= new HashMap<>();
    private final VTPController viewController;
    private final DFPController deleteController;
    private final FavPetDisplayViewModel vm;
    private final ActionListener unLikeListener;
    private final ActionListener viewProfileListener;
    public FavPetDisplayView(FavPetDisplayViewModel favPetDisplayViewModel,
                             DFPController deletePetController,
                             VTPController viewThisPetController){
        setLayout(new GridBagLayout());
        this.deleteController = deletePetController;
        this.viewController = viewThisPetController;
        this.vm = favPetDisplayViewModel;
        vm.addPropertyChangeListener(this);
        ActionListener unlikeProfileListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO debugging
                System.out.println("unlike petProfile with id" + e.getActionCommand());
                //deleteController.execute(vm.getState().getUsername(), Integer.getInteger(e.getActionCommand()));
            }
        };
        this.unLikeListener = unlikeProfileListener;

        ActionListener viewProfileActionListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO debugging
                System.out.println("view petProfile with id" + e.getActionCommand());
                //viewController.execute(Integer.getInteger(e.getActionCommand()));

            }
        };
        this.viewProfileListener = viewProfileActionListner;

        FavPetDisplayState currState =  vm.getState();
        List<Integer> petIds = currState.getKeyEntries();
        for (int id : petIds) {
            id_to_PetProfile.put(id, new OnePetProfile(
                    id,
                    currState.getName(id),
                    currState.getPhoto(id),
                    unLikeListener, viewProfileListener
                    , vm.SIZE_OF_ONE_PET_PROFILE_IN_PIXEL));
        }
        updateGraphics();
    }
    private void updateGraphics(){
        //layout editing
        removeAll(); //remove all profiles
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5); //space between each profile
        gbc.fill = GridBagConstraints.NONE; //not going to assign more space than necessary;
        gbc.weightx = 0; //don't take extra space
        gbc.weighty = 0;
        int totalProfiles =  id_to_PetProfile.size();
        int reqCol = vm.PROFILE_DISPLAY_IN_ONE_ROW;
        for (int profilePos = 0; profilePos < totalProfiles; profilePos++){
            int row = profilePos / reqCol;
            int col = profilePos % reqCol;
            gbc.gridx = col ;
            gbc.gridy = row;
            add(id_to_PetProfile.get(profilePos), gbc);
        }
        revalidate();
        repaint();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /*TODO current propertyChange does not detect change in name, petPhotoUrl of a pet
           oneway of solving this is to assign a separate viewmodel to each of the usecase, and put those viewmodel
           as a part of this viewmodel and each subviewmodel will have a propertysupport, and this view will be in
           support to all of the viewmodel */
        FavPetDisplayState currState =  (FavPetDisplayState)evt.getNewValue();
        List<Integer> currIds = currState.getKeyEntries();
        for ( int currId :  currIds){ //get entries key
            if (!id_to_PetProfile.containsKey(currId)){  // this petProfile need be added
                id_to_PetProfile.put(currId, new OnePetProfile(
                        currId,
                        currState.getName(currId),
                        currState.getPhoto(currId),
                        unLikeListener, viewProfileListener
                        , vm.SIZE_OF_ONE_PET_PROFILE_IN_PIXEL));
            }
        for (int oldId : id_to_PetProfile.keySet()){
            if (!currIds.contains(oldId)){ //this petProfile need to be deleted
                id_to_PetProfile.remove(oldId);
            }
        }
        updateGraphics();
        }

    }
}
