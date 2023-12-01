package favPetPage.deleteAFavPet;

import favPetPage.FavPetPageViewModel;

/**
 * An implementation of the deleteAFavPet usecase presenter
 * Tasks with sending information of the unliked pet profiles that need to be disposed in user's screen
 */
public class DeletePresenter implements DeleteOB {
    private final DeleteViewModel vm;

    /**
     * Construct an AddPresenter
     *
     * @param deleteViewModel viewmodel for the deleteAFavPet usecase. This is called by the DeletePresenter
     *                        to update information of pet profiles that needed to be removed from the screen
     */
    public DeletePresenter(DeleteViewModel deleteViewModel) {
        this.vm = deleteViewModel;
    }


    /**
     * Send the id of the pet profile that needs to disappear from screen
     *
     * @param deletedId the id of the pet profile that the user wants to remove from their liked list
     */

    @Override
    public void prepareSuccessView(int deletedId) {

        DeleteState state = vm.getState();
        state.addId(deletedId);
    }
}
