package browsePage.swipe;

import browsePage.BrowsePageState;
import browsePage.BrowsePageViewModel;
import dataAccessObject.PetProfileDataAccessInterface;
import dataAccessObject.UserDataAccessInterface;

public class InitiateProfileSwiper {

    private final UserDataAccessInterface dao;
    private final PetProfileDataAccessInterface daoP;
    private final BrowsePageViewModel browsePageVM;
    private final DeckCreator creator;

    public InitiateProfileSwiper(
            UserDataAccessInterface userDataAccessInterface,
            PetProfileDataAccessInterface petProfileDataAccessInterface,
            BrowsePageViewModel browsePageViewModel) {
        browsePageVM = browsePageViewModel;
        creator = new DeckCreator(browsePageViewModel.getState().getUsername(),
                userDataAccessInterface, petProfileDataAccessInterface);
        dao = userDataAccessInterface;
        daoP = petProfileDataAccessInterface;
    }

    public void execute() {
        BrowsePageState curr = browsePageVM.getState();
        creator.setName(curr.getUsername());
        System.out.println(curr.getUsername());
        curr.setRecommendation(creator.createDeck());
        browsePageVM.setState(curr);
        browsePageVM.firePropertyChanged();
    }
}
