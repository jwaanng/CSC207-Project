package favPetPage.updateAFavPet;

import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.PetProfileDataAccessObject;
import dataAcessObject.ProfilePictureDataAccessInterface;
import entity.petProfile.PetProfile;

/**
 * An implementation of a updateAFavPet usecase interactor that updates a pet profile in the user's liked list
 */

public class UpdateUCI implements UpdateIB {
    private final UpdateOB presenter;
    private final PetProfileDataAccessInterface daoPet;
    private final ProfilePictureDataAccessInterface daoPic;

    /**
     * Construct a new usecase interactor
     *
     * @param updateOutputBoundary              a presenter for the updateAFavPet usecase that is called by the
     *                                          interactor to finish usecase
     * @param petProfileDataAccessInterface     a data access object that can interact with the database that stores all
     *                                          pet profiles
     * @param profilePictureDataAccessInterface a data access object that can interact with the database that stores
     *                                          all profile photos of user and pet profiles
     */
    public UpdateUCI(UpdateOB updateOutputBoundary,
                     PetProfileDataAccessInterface petProfileDataAccessInterface,
                     ProfilePictureDataAccessInterface profilePictureDataAccessInterface) {
        this.presenter = updateOutputBoundary;
        this.daoPet = petProfileDataAccessInterface;
        this.daoPic = profilePictureDataAccessInterface;
    }

    /**
     * give directions to updating the pet profile with the given pet id
     *
     * @param petId the id of the pet profile
     */
    @Override
    public void execute(int petId) {
        PetProfile pet = daoPet.getProfile(petId);
        UpdateOPData outputData = new UpdateOPData();
        outputData.name = pet.getName();
        outputData.photo = daoPic.retrievePetProfile(petId);
        outputData.petId = pet.getId();
        presenter.prepareSuccessView(outputData);
    }
}
