package favPetPage.viewThisPetProfile;

import dataAcessObject.PetProfileDataAccessInterface;
import entity.petProfile.PetProfile;

public class ViewThisUCI implements ViewThisIB {
    private final PetProfileDataAccessInterface daoP;
    private final ViewThisOB presenter;
    public ViewThisUCI(PetProfileDataAccessInterface petProfileDataAccessObject, ViewThisOB viewThisPetProfilePresenter){
        this.daoP = petProfileDataAccessObject;
        this.presenter = viewThisPetProfilePresenter;
    }
    @Override
    public void execute(int petId) {
        if (!daoP.exists(petId)){
            ViewThisOPData output = new ViewThisOPData();
            output.setError("Sorry, the pet owner has just dismounted the pet from the app (");
            presenter.prepareFailView(output);
        }
        else{
        PetProfile petProfile = daoP.getProfile(petId);
        //TODO Prepare the right amount of information to be displayed

        }

    }
}
