package FavPetPage.DeleteAFavPet;

import DataAcessObject.UserDataAcessInterface;
import Entity.User.AppUser;

public class DFPUCI implements DFPIB{
    private UserDataAcessInterface dao;
    private DFPOB presenter;

    public DFPUCI(UserDataAcessInterface userDataAccessObject, DFPOB deleteFavoritePetPresenter) {
        this.dao = userDataAccessObject;
        this.presenter = deleteFavoritePetPresenter;
    }

    @Override
    public void execute(DFPIPData inputData) {
        //precondition, inputData must contain a petID that is indeed a petId of the user's saved pet profile
        String username = inputData.username;
        int petId = inputData.id;
        AppUser user = dao.retrieve(username);
        user.deleteFavProfile(petId);
        dao.update(user);
        presenter.prepareSuccessView(petId);
    }
}
