package SwipePage;

import entity.petProfile.PetProfile;

public class PetProfilePresenter {
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
