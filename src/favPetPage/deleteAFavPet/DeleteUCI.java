package favPetPage.deleteAFavPet;

import dataAcessObject.UserDataAccessInterface;
import entity.user.AppUser;

/**
 * A concrete implementation of {@link DeleteOB}
 * <p>
 * An implementation of a deleteAFavPet usecase interactor that deletes a unliked pet profile from a user's liked list
 */
public class DeleteUCI implements DeleteIB {
    private UserDataAccessInterface dao;
    private DeleteOB presenter;

    /**
     * Construct a new usecase interactor
     *
     * @param deleteFavoritePetOutPutBoundary a presenter implementing {@link DeleteOB} that is called by the
     *                                        interactor to finish usecase
     * @param userDataAccessInterface         a data access object implementing {@link UserDataAccessInterface}
     *                                        that can interact with the database that stores all users
     */

    public DeleteUCI(DeleteOB deleteFavoritePetOutPutBoundary, UserDataAccessInterface userDataAccessInterface) {
        this.dao = userDataAccessInterface;
        this.presenter = deleteFavoritePetOutPutBoundary;
    }

    /**
     * delete the pet profile from the user's liked list and notifies front end to update screen
     *
     * @param inputData DeleteIPData that stores all relevant information:
     *                  the username of the user that performs this action
     *                  the pet id to be deleted;
     */
    @Override
    public void execute(DeleteIPData inputData) {
        //precondition, inputData must contain a petID that is indeed a petId of the user's saved pet profile
        String username = inputData.username;
        int petId = inputData.id;
        AppUser user = dao.retrieve(username);
        user.deleteFavProfile(petId);
        dao.update(user);
        presenter.prepareSuccessView(petId);
    }
}
