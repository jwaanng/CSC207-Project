package FavPetPage.ViewThisPetProfile;

import DataAcessObject.PetProfileDataAccessInterface;
import Entity.PetProfiles.PetProfile;

public class VTPUCI implements VTPIB {
    private final PetProfileDataAccessInterface daoP;
    private final VTPOB presenter;
    public VTPUCI(PetProfileDataAccessInterface petProfileDataAccessObject, VTPOB viewThisPetProfilePresenter){
        this.daoP = petProfileDataAccessObject;
        this.presenter = viewThisPetProfilePresenter;
    }
    @Override
    public void execute(int petId) {
        if (!daoP.exists(petId)){
            VTPOPData output = new VTPOPData();
            output.setError("Sorry, the pet owner has just dismounted the pet from the app (");
            presenter.prepareFailView(output);
        }
        else{
        PetProfile petProfile = daoP.getProfile(petId);
        //TODO Prepare the right amount of information to be displayed

        }

    }
}
