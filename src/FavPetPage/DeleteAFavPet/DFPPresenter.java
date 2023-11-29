package FavPetPage.DeleteAFavPet;

import FavPetPage.FavPetPageViewModel;

public class DFPPresenter implements DFPOB{
    private final FavPetPageViewModel vm;

    public DFPPresenter(FavPetPageViewModel favPetPageViewModel) {
        this.vm = favPetPageViewModel;
    }



    @Override
    public void prepareSuccessView(int deletedId) {

        DeleteFavPetsState state = vm.getDeleteFavPetViewModel().getState();
        state.addId(deletedId);
    }
}
