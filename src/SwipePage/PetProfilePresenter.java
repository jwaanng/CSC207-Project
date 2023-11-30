package SwipePage;

import entity.PetProfiles.PetProfile;

public class PetProfilePresenter {
    public SwipePageViewModel createViewModel(PetProfile profile) {
        if (profile == null) {
            return new SwipePageViewModel("No more profiles", "", "");
        }
        return new SwipePageViewModel(
                profile.getName(),
                "Bio: " + profile.toString(),
                profile.getPetPhotoLink()
        );
    }
}
