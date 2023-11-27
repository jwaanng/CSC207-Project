package favPetPage.deleteAFavPet;

import dataAcessObject.UserDataAcessInterface;
import entity.User.AppUser;

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
        String username = inputData.getUsername();
        int petId = inputData.getId();
        AppUser user = dao.retrieve(username);
        user.deleteFavProfile(petId);
        dao.update(user);
        DFPOPData deletedPet = new DFPOPData(petId);
        presenter.prepareSuccessView(deletedPet);


    }
}
