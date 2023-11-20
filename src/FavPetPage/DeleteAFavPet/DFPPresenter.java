package FavPetPage.DeleteAFavPet;

import FavPetPage.FavPetDisplayState;
import FavPetPage.FavPetViewModel;

public class DFPPresenter implements DFPOB{
    private final FavPetViewModel vm;

    public DFPPresenter(FavPetViewModel favPetViewModel) {
        this.vm = favPetViewModel;
    }



    @Override
    public void prepareSuccessView(DFPOPData outputData) {
        FavPetDisplayState currState = vm.display.getState();
        currState.deleletePetNameAndPhoto(outputData.getDeletedPetId());
        vm.display.setState(currState);
        vm.display.firePropertyChanged();
    }
}
