package favPetPage.deleteAFavPet;

import favPetPage.FavPetPageViewModel;

public class DeletePresenter implements DeleteOB {
    private final FavPetPageViewModel vm;

    public DeletePresenter(FavPetPageViewModel favPetPageViewModel) {
        this.vm = favPetPageViewModel;
    }



    @Override
    public void prepareSuccessView(int deletedId) {

        DeleteState state = vm.getDeleteFavPetViewModel().getState();
        state.addId(deletedId);
    }
}
