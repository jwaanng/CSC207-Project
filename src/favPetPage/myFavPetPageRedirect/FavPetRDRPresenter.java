package favPetPage.myFavPetPageRedirect;

import favPetPage.FavPetPageViewModel;
import viewModel.ViewModelManager;
import redirect.PageRedirectViewModel;

/**
 * An implementation of the myFavPetPageRedirect usecase presenter
 * Tasks with setting up redirecting the user to the favorite pet page
 */
public class FavPetRDRPresenter implements FavPetRDROB {
    private final ViewModelManager manager;
    private final FavPetPageViewModel myFPPvm;

    /**
     * Construct an FavPetRDRPresenter
     *
     * @param favPetPageViewModel a viewmodel for the myFavPetPageRedirect usecase. This is called by the
     *                            FavPetRDRPresenter to redirect user
     * @param manager             manager for all the main page, tasks with switching the main pages that the user sees
     *                            ;
     */
    public FavPetRDRPresenter(FavPetPageViewModel favPetPageViewModel, ViewModelManager manager) {
        this.myFPPvm = favPetPageViewModel;
        this.manager = manager;
    }

    /**
     * Redirect the user to the favorite pet page
     */

    @Override
    public void prepareSuccessView() {
        myFPPvm.viewmodelsfirePropertyChanges();
        manager.setActiveViewName(myFPPvm.getViewName());
        myFPPvm.firePropertyChanged();
        manager.firePropertyChange();

    }
}
