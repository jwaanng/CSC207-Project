package favPetPage.addAFavPet;

import dataAcessObject.CommonUserDataAccessObject;
import dataAcessObject.PetProfileDataAccessObject;
import entity.petProfile.PetProfile;
import entity.user.AppUser;

public class AddUCI implements AddIB {
    private final AddOB presenter;
    private final CommonUserDataAccessObject dao;
    private final PetProfileDataAccessObject daop;

    public AddUCI(AddOB addAFavPetPresenter, CommonUserDataAccessObject userDataAccessObject,
                  PetProfileDataAccessObject petProfileDataAccessObject) {
        this.presenter = addAFavPetPresenter;
        this.dao = userDataAccessObject;
        this.daop = petProfileDataAccessObject;
    }

    @Override
    public void execute(String username, int petId) {
        AppUser user = dao.retrieve(username);
        if (daop.exists(petId)) {
            user.addFavProfile(petId);
            PetProfile profile = daop.getProfile(petId);
            AddOPData outputData = new AddOPData();
            outputData.petID = profile.getId();
            outputData.petName = profile.getName();
            outputData.petPhotoUrl = profile.getPetPhotoLink();
            presenter.prepareSucessView(outputData);
        }
        else {
            AddOPData outputData = new AddOPData();
            outputData.error = "Sorry, pet owner just deleted the profile";
            presenter.prepareFailView(outputData);
        }


    }
}
