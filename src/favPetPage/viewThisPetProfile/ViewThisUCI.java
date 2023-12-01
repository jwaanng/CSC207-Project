package favPetPage.viewThisPetProfile;

import dataAcessObject.PetProfileDataAccessInterface;
import entity.petProfile.PetProfile;

/**
 * An implementation of a viewThisPetProfile usecase interactor that redirects the user to a window where a detailed
 * version of the pet profile is displayed
 */

public class ViewThisUCI implements ViewThisIB {
    private final PetProfileDataAccessInterface daop;
    private final ViewThisOB presenter;

    /**
     * Construct a new usecase interactor
     *
     * @param viewThisPresenter             the ViewThisPresenter that takes in the direction from this usecase interactor to
     *                                      finish usecase
     * @param petProfileDataAccessInterface a data access object that can interact with the database that stores all
     *                                      pet profiles
     */
    public ViewThisUCI(ViewThisOB viewThisPresenter, PetProfileDataAccessInterface petProfileDataAccessInterface) {
        this.daop = petProfileDataAccessInterface;
        this.presenter = viewThisPresenter;
    }

    /**
     * open the detailed version of this pet profile from the  user's liked list
     *
     * @param petId the id of this pet profile
     */
    @Override
    public void execute(int petId) {
        if (!daop.exists(petId)) {
            ViewThisOPData output = new ViewThisOPData();
            output.error = "Sorry, the pet owner has just dismounted the pet from the app :(";
            presenter.prepareFailView(output);
        } else {
            PetProfile petProfile = daop.getProfile(petId);
            //TODO Prepare the right amount of information to be displayed

        }

    }
}
