package browsePage.swipe;
import browsePage.SwipePageView;
import entity.petProfile.PetProfile;
import favPetPage.addAFavPet.AddController;

/**
 * The {@code DynamicSwipePageController} class handles interactions for swiping through pet profiles.
 */
public class DynamicSwipePageController {

    private final ProfileQueueChainer interactor;
    private final PetProfilePresenter presenter;
    private final SwipePageView view;
    private PetProfile currentProfile;
    private String username;
    private AddController addController;

    /**
     * Constructs a {@code DynamicSwipePageController} with the provided interactor, presenter, and view.
     *
     * @param interactor The interactor responsible for swiping profiles.
     * @param presenter  The presenter responsible for creating view models.
     * @param view       The view to be updated with profile information.
     */
    public DynamicSwipePageController(ProfileQueueChainer interactor,
                                      PetProfilePresenter presenter,
                                      SwipePageView view,
                                      String username,
                                      AddController addController) {
        this.interactor = interactor;
        this.presenter = presenter;
        this.view = view;
        this.username = username;
        this.currentProfile = null;
        this.addController = addController;
    }

    /**
     * Loads the next pet profile and updates the view.
     */
    public boolean loadNextProfile() {
        PetProfile profile = interactor.getNextProfile();
        currentProfile = profile;
        if (profile != null) {
            SwipePageViewModel viewModel = presenter.createViewModel(profile);
            view.updateProfile(viewModel);
        } else {
            return true;
            // Handle case where there are no more profiles (e.g., disable buttons, show message).
        }
        return false;
    }

    /**
     * Handles the like action for the current profile.
     */
    public void onLike() {
        // Additional logic for liking a profile (if needed).
        addController.execute(username, currentProfile.getId());
        if (currentProfile != null) {
            loadNextProfile();
        }
    }

    /**
     * Handles the dislike action for the current profile.
     */
    public void onDislike() {
        if (currentProfile != null) {
            loadNextProfile();
        }

    }
}