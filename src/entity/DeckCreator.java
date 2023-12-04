package entity;

import dataAccessObject.PetProfileDataAccessObject;
import entity.petProfile.PetProfile;
import entity.user.AppUser;
import swipePage.newcomparator.PetProfileComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckCreator {
    private AppUser appUser;
    private PetProfileDataAccessObject ppdao;
    private PetProfileComparator comparator;
    private ArrayList<PetProfile> allPetProfiles;

    public DeckCreator(AppUser appUser) {
        ArrayList<PetProfile> petList = GenerateDeck();
        PetProfileDataAccessObject ppc = new PetProfileDataAccessObject();
        this.comparator = new PetProfileComparator(
//                appUser.getPreferredSize(), // ideal size
                5,        // ideal age
                appUser.getPreferredSex()  // ideal sex
        );
        this.ppdao = ppc;
        this.allPetProfiles = petList;
        this.appUser = appUser;
    }

    public DeckCreator() { //for testing ignore this in the final implementation -Sean
        ArrayList<PetProfile> petList = GenerateDeck();
        PetProfileDataAccessObject ppc = new PetProfileDataAccessObject();
        this.comparator = new PetProfileComparator(
//                "Medium", // ideal size
                5,        // ideal age
                "Male"  // ideal sex
        );
        this.ppdao = ppc;
        this.allPetProfiles = petList;
    }

    public ArrayList<PetProfile> sortAllPetProfiles() {
        Collections.sort(allPetProfiles, comparator);
        List<Integer> petIDs = appUser.getFavPet();
        for (int i = 0; i < allPetProfiles.size(); i++) {
            if (petIDs.contains(allPetProfiles.get(i).getId())) {
                allPetProfiles.remove(i);
            }
        }
        return allPetProfiles;
    }

    public ArrayList<PetProfile> GenerateDeck() {
        PetProfileDataAccessObject ppc = new PetProfileDataAccessObject();
        return ppc.retrieveAllProfiles();
    }

    public static void main(String[] args) {
        PetProfileDataAccessObject access = new PetProfileDataAccessObject();
        ArrayList<PetProfile> allprofiles = access.retrieveAllProfiles();
        System.out.println(allprofiles);

        DeckCreator deck = new DeckCreator();
        ArrayList<PetProfile> list = deck.sortAllPetProfiles();
        System.out.println(list);

    }
}