package browsePage.swipe;

import dataAccessObject.ProfilePictureDataAccessInterface;
import entity.petProfile.PetProfile;

import java.awt.*;

/**
 * The {@code PetProfilePresenter} class is responsible for creating a {@code SwipePageViewModel}
 * based on a {@code PetProfile}.
 */
public class PetProfilePresenter {
    private final ProfilePictureDataAccessInterface daoPic;
    public PetProfilePresenter(ProfilePictureDataAccessInterface profilePictureDataAccessInterface){
        daoPic = profilePictureDataAccessInterface;
    }
    /**
     * Creates a {@code SwipePageViewModel} based on the provided {@code PetProfile}.
     *
     * @param profile The pet profile for which to create the view model.
     * @return A {@code SwipePageViewModel} representing the provided pet profile.
     */
    public SwipePageViewModel createViewModel(PetProfile profile) {
        if (profile == null) {
            return new SwipePageViewModel("No more profiles", "", null);
        }

        int id = profile.getId();
        Image image = daoPic.retrievePetProfile(id);
        return new SwipePageViewModel(
                profile.getName(),
                profile.getAbout(),
                image
        );
    }
}
