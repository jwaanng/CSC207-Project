package favPetPage.updateAFavPet;

import dataAcessObject.PetProfileDataAccessInterface;
import dataAcessObject.ProfilePictureDataAccessInterface;
import entity.petProfile.PetProfile;


/**
 * A concrete implementation of {@link UpdateIB}
 * <p>
 * An implementation of a updateAFavPet usecase interactor that updates a pet profile in the user's liked list
 */

public class UpdateUCI implements UpdateIB {
    private final UpdateOB presenter;
    private final PetProfileDataAccessInterface daoPet;
    private final ProfilePictureDataAccessInterface daoPic;

    /**
     * Construct a new usecase interactor
     *
     * @param updateOutputBoundary              a presenter implementing {@link UpdateOB} that is called by the
     *                                          interactor to finish usecase
     * @param petProfileDataAccessInterface     a data access object implementing {@link PetProfileDataAccessInterface}
     *                                          that can interact with the database that stores all
     *                                          pet profiles
     * @param profilePictureDataAccessInterface a data access object implementing {@link ProfilePictureDataAccessInterface}
     *                                          that can interact with the database that stores
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
