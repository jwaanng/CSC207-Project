package swipePage;
import entity.petProfile.PetProfile;
import favPetPage.addAFavPet.AddController;

/**
 * The {@code SwipePageController} class handles interactions for swiping through pet profiles.
 */
public class SwipePageController {

    private final ProfileSwipingInteractor interactor;
    private final PetProfilePresenter presenter;
    private final NewSwipePage view;

    private PetProfile currentProfile;

    private String username;

    private AddController addController;

    /**
     * Constructs a {@code SwipePageController} with the provided interactor, presenter, and view.
     *
     * @param interactor The interactor responsible for swiping profiles.
     * @param presenter  The presenter responsible for creating view models.
     * @param view       The view to be updated with profile information.
     */
    public SwipePageController(ProfileSwipingInteractor interactor, PetProfilePresenter presenter, NewSwipePage view, String user, AddController addController) {
        this.interactor = interactor;
        this.presenter = presenter;
        this.view = view;
        this.username = user;
        this.currentProfile = null;
        this.addController = addController;
    }

    /**
     * Loads the next pet profile and updates the view.
     */
    public void loadNextProfile() {
        PetProfile profile = interactor.getNextProfile();
        currentProfile = profile;
        if (profile != null) {
            SwipePageViewModel viewModel = presenter.createViewModel(profile);
            view.updateProfile(viewModel);
        } else {
            // Handle case where there are no more profiles (e.g., disable buttons, show message).
            System.out.println("No more profiles to swipe.");
        }
    }

    /**
     * Handles the like action for the current profile.
     */
    public void onLike() {
        // Additional logic for liking a profile (if needed).
        addController.execute(username, currentProfile.getId());
        loadNextProfile();
    }

    /**
     * Handles the dislike action for the current profile.
     */
    public void onDislike() {
        loadNextProfile();
    }
}