package favPetPage.deleteAFavPet;

import dataAcessObject.UserDataAcessInterface;
import entity.user.AppUser;

public class DeleteUCI implements DeleteIB {
    private UserDataAcessInterface dao;
    private DeleteOB presenter;

    public DeleteUCI(UserDataAcessInterface userDataAccessObject, DeleteOB deleteFavoritePetPresenter) {
        this.dao = userDataAccessObject;
        this.presenter = deleteFavoritePetPresenter;
    }

    @Override
    public void execute(DeleteData inputData) {
        //precondition, inputData must contain a petID that is indeed a petId of the user's saved pet profile
        String username = inputData.username;
        int petId = inputData.id;
        AppUser user = dao.retrieve(username);
        user.deleteFavProfile(petId);
        dao.update(user);
        presenter.prepareSuccessView(petId);
    }
}
