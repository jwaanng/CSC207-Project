package favPetPage.deleteAFavPet;

import dataAcessObject.UserDataAcessInterface;
import entity.user.AppUser;

/**
 * An implementation of a addAFavPet usecase interactor that deletes a unliked pet profile from a user's liked list
 */
public class DeleteUCI implements DeleteIB {
    private UserDataAcessInterface dao;
    private DeleteOB presenter;

    /**
     * Construct a new usecase interactor
     *
     * @param deleteFavoritePetOutPutBoundary a presenter for the deleteAFavPet usecase that is called by the
     *                                        interactor to finish usecase
     * @param userDataAcessInterface          a data access object that can interact with the database that stores all users
     */

    public DeleteUCI(DeleteOB deleteFavoritePetOutPutBoundary, UserDataAcessInterface userDataAcessInterface) {
        this.dao = userDataAcessInterface;
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
