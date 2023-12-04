package myPets.updateMyPet;

public class UpdateMyPetsPresenter implements UpdateMyPetsOB {
    private final UpdateMyPetsViewModel updateVM;

    public UpdateMyPetsPresenter(UpdateMyPetsViewModel updateViewModel) {
        this.updateVM = updateViewModel;
    }


    @Override
    public void prepareSuccessView(UpdateMyPetsOPData outputData) {
        UpdateMyPetsState curr = updateVM.getState();
        curr.addPetNameAndPhoto(outputData.petId, outputData.petName, outputData.photo);
        updateVM.setState(curr);
        //Do not fire property change, queued until next time redirects to fav pet page
    }
}
