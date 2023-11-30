package favPetPage.addAFavPet;

public class AddPresenter implements AddOB {

    private final AddViewModel addUpdateVM;

    public AddPresenter(AddViewModel addUpdateVM) {
        this.addUpdateVM = addUpdateVM;
    }

    @Override
    public void prepareFailView(AddOPData outputData) {
        //TODO  browsePage fire propertychange and error;

    }

    @Override
    public void prepareSucessView(AddOPData outputData) {
        AddState curr = addUpdateVM.getState();
        curr.addPetNameAndPhoto(outputData.petID, outputData.petName, outputData.petPhotoUrl);
        //do not fire property change, this will be queued until user redirects to fav pet page
    }
}
