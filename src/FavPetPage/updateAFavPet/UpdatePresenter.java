package FavPetPage.updateAFavPet;

public class UpdatePresenter implements UpdateOB {
    private final UpdateViewModel updateVM;

    public UpdatePresenter(UpdateViewModel updateViewModel) {
        this.updateVM = updateViewModel;
    }


    @Override
    public void prepareSuccessView(UpdateOPData outputData) {
        UpdateState curr = updateVM.getState();
        curr.addPetNameAndPhoto(outputData.petId, outputData.petName, outputData.petPhotoUrl);
        updateVM.setState(curr);
        //Do not fire property change, queued until next time redirects to fav pet page
    }
}
