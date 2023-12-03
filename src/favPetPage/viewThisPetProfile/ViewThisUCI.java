package favPetPage.viewThisPetProfile;

import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.ProfilePictureDataAccessInterface;
import dataAcessObject.UserDataAcessInterface;
import entity.petProfile.PetProfile;

/**
 * An implementation of a viewThisPetProfile usecase interactor that redirects the user to a window where a detailed
 * version of the pet profile is displayed
 */

public class ViewThisUCI implements ViewThisIB {
    private final PetProfileDataAccessInterface daoP;
    private final ProfilePictureDataAccessInterface daoPic;
    private final UserDataAcessInterface dao;
    private final ViewThisOB presenter;

    /**
     * Construct a new usecase interactor
     *
     * @param viewThisPresenter                 the ViewThisPresenter that takes in the direction from this usecase
     *                                          interactor to
     *                                          finish usecase
     * @param userDataAccessInterface           a data access object that can interact with the database that stores all
     *                                          users
     * @param petProfileDataAccessInterface     a data access object that can interact with the database that stores all
     *                                          pet profiles
     * @param profilePictureDataAccessInterface a data access object that can interact with the database that stores all
     *                                          pictures of pet profiles (also the user photos, but this functionality
     *                                          is not needed in this usecase).
     */
    public ViewThisUCI(ViewThisOB viewThisPresenter, UserDataAcessInterface userDataAccessInterface,
                       PetProfileDataAccessInterface petProfileDataAccessInterface,
                       ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {
        daoP = petProfileDataAccessInterface;
        dao = userDataAccessInterface;
        daoPic = profilePictureDataAccessInterface;
        presenter = viewThisPresenter;
    }

    /**
     * open the detailed version of this pet profile from the user's liked list,
     * user will recieve notification if the pet profile just got deleted as the user clicked on pet profile to open it
     *
     * @param petId the id of this pet profile
     */
    @Override
    public void execute(int petId) {
        if (!daoP.exists(petId)) {
            ViewThisOPData output = new ViewThisOPData();
            output.error = "Sorry, the pet owner has just dismounted the pet from the app :(, " +
                    "please refresh your page by checking out other pages first ;)";
            presenter.prepareFailView(output);
        } else {
            PetProfile petProfile = daoP.getProfile(petId);
            ViewThisOPData output = new ViewThisOPData();
            output.ownerName = petProfile.getPetOwnerName();
            output.photo = daoPic.retrievePetProfile(petProfile.getId());
            output.name = petProfile.getName();
            output.specie = petProfile.getSpecie();
            output.sex = petProfile.getSex();
            output.age = petProfile.getAge();
            output.size = petProfile.getSize();
            output.generalDescr = petProfile.getGeneralDescr();
            output.tempDescr = petProfile.getTemperDescr();
            output.likeDescr = petProfile.getLikeDescr();

            output.specieSpecificInformation = petProfile.getDisplayAdditionalInformation();
            output.ownerInstagram = dao.retrieve(petProfile.getPetOwnerName()).getInstagramUsername();
            presenter.prepareSuccessView(output);

        }

    }
}
