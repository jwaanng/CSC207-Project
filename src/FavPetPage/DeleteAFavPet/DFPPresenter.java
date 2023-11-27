package FavPetPage.DeleteAFavPet;

import FavPetPage.FavPetDisplayState;
import FavPetPage.MyFavPetPageViewModel;

public class DFPPresenter implements DFPOB{
    private final MyFavPetPageViewModel vm;

    public DFPPresenter(MyFavPetPageViewModel myFavPetPageViewModel) {
        this.vm = myFavPetPageViewModel;
    }



    @Override
    public void prepareSuccessView(DFPOPData outputData) {
        FavPetDisplayState currState = vm.getFavPetDisplayViewModel().getState();
        currState.deleletePetNameAndPhoto(outputData.getDeletedPetId());
        vm.getFavPetDisplayViewModel().setState(currState);
        //TODO notifies redirect so the nextime somebody redirects to this page, the redirect will notify the view to
        // rebuild its list of petprofiles.
    }
}
