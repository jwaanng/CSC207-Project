package browsePage.swipe;

import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.UserDataAccessInterface;
import entity.petProfile.PetProfile;
import entity.user.AppUser;
import browsePage.swipe.newcomparator.PetProfileComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckCreator {
    private final UserDataAccessInterface dao;
    private final PetProfileDataAccessInterface pdao;
    private String username;
    public DeckCreator(String username,
                       UserDataAccessInterface userDataAccessInterface,
                       PetProfileDataAccessInterface petProfileDataAccessInterface) {
        this.dao = userDataAccessInterface;
        pdao = petProfileDataAccessInterface;
        this.username = username;

    }

    public List<PetProfile> createDeck() {
        System.out.println(username);
        AppUser user = dao.retrieve(username);
        List<PetProfile> profiles = pdao.getAllProfiles();

        PetProfileComparator customComparator = new PetProfileComparator(
                user.getPreferredSize(),
                user.getPreferredSex());
        Collections.sort(profiles, customComparator);
        List<Integer> petIDs = user.getFavPet();
        ArrayList<PetProfile> toRemove = new ArrayList<>();
        for (int i = 0; i < profiles.size(); i++) {
            if (petIDs.contains(profiles.get(i).getId())) {
                toRemove.add(profiles.get(i));
            }
        }
        profiles.removeAll(toRemove);
        return profiles;
    }
    public void setName(String username){
        this.username = username ;
    }
}