package swipePage;

import dataAccessObject.CommonProfileDataAccessObject;
import entity.petProfile.PetProfile;

import java.awt.*;

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
            return new SwipePageViewModel("No more profiles", "", null);
        }

        int id = profile.getId();
        CommonProfileDataAccessObject commonProfileDataAccessObject = new CommonProfileDataAccessObject();
        Image image = commonProfileDataAccessObject.retrievePetProfile(id);

        System.out.println(image);

        return new SwipePageViewModel(
                profile.getName(),
                profile.getAbout(),
                image
        );
    }
}
