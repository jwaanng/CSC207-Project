package swipePage;

import entity.petProfile.PetProfile;

/**
 * The {@code PetProfilePresenter} class is responsible for creating a {@code SwipePageViewModel}
 * based on a {@code PetProfile}.
 */
public class PetProfilePresenter {

    /**
     * Creates a {@code SwipePageViewModel} based on the provided {@code PetProfile}.
     *
     * @param profile The pet profile for which to create the view model.
     * @return A {@code SwipePageViewModel} representing the provided pet profile.
     */
    public SwipePageViewModel createViewModel(PetProfile profile) {
        if (profile == null) {
            return new SwipePageViewModel("No more profiles", "", "");
        }
        return new SwipePageViewModel(
                profile.getName(),
                "Bio: " + profile.toString(),
                profile.getName() // TEMPORARILY SET FROM GET PHOTO LINK COZ THERE WAS AN ERROR - JW
        );
    }
}
