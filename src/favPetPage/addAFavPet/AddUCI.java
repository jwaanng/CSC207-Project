package favPetPage.addAFavPet;

import dataAcessObject.*;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

/**
 * A concrete implementation of {@link AddIB}
 * <p>
 * A addAFavPet usecase interactor that adds a pet profile into a user's liked list
 */
public class AddUCI implements AddIB {
    private final AddOB presenter;
    private final UserDataAccessInterface dao;
    private final PetProfileDataAccessInterface daop;
    private final ProfilePictureDataAccessInterface daoPic;

    /**
     * Construct a new usecase interactor
     *
     * @param addAFavPetOutPutBoundary          a presenter implementing {@link AddOB}that is called by the
     *                                          interactor to finish usecase
     * @param userDataAccessInterface           a data access object implementing {@link UserDataAccessInterface}
     *                                          that can interact with the database that stores all users
     * @param petProfileDataAccessInterface     a data access object implementing {@link PetProfileDataAccessInterface}
     *                                          that can interact with the database that stores all
     *                                          pet profiles
     * @param profilePictureDataAccessInterface a data access object implementing {@link ProfilePictureDataAccessInterface}
     *                                          that can interact with the database that stores
     *                                          all profile photos of user and pet profiles
     */
    public AddUCI(AddOB addAFavPetOutPutBoundary,
                  UserDataAccessInterface userDataAccessInterface,
                  PetProfileDataAccessInterface petProfileDataAccessInterface,
                  ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {
        this.presenter = addAFavPetOutPutBoundary;
        this.dao = userDataAccessInterface;
        this.daop = petProfileDataAccessInterface;
        this.daoPic = profilePictureDataAccessInterface;
    }

    /**
     * Add a pet profile to the user's liked list
     *
     * @param username the username of the user
     * @param petId    the id of the pet profile
     */
    @Override
    public void execute(String username, int petId) {
        AppUser user = dao.retrieve(username);
        if (daop.exists(petId)) {
            user.addFavProfile(petId);
            PetProfile profile = daop.getProfile(petId);
            AddOPData outputData = new AddOPData();
            outputData.petID = profile.getId();
            outputData.petName = profile.getName();
            outputData.photo = daoPic.retrievePetProfile(petId);
            presenter.prepareSucessView(outputData);
        } else {
            AddOPData outputData = new AddOPData();
            outputData.error = "Sorry, pet owner just deleted the profile";
            presenter.prepareFailView(outputData);
        }


    }
}
