package favPetPage.browsePet;

import browsePage.BrowsePageViewModel;
import viewModel.ViewModelManager;

/**
 * A concrete implementation of {@link BrowseOB}
 * <p>
 * An implementation of the browsePet usecase presenter
 * Tasks with notifying the frontend to switch screen to the page for browsing pets
 */
public class BrowsePresenter implements BrowseOB {

    private final ViewModelManager manager;
    private final BrowsePageViewModel vm;

    /**
     * Construct an BrowsePresenter object
     *
     * @param browsePageViewmodel a viewmodel for the browsePet usecase.
     *                            <p>
     *                            This is called by the BrowsePresenter to
     *                            realize switching view
     * @param manager             {@link ViewModelManager} that manages which main page of the application to be displayed
     */
    public BrowsePresenter(BrowsePageViewModel browsePageViewmodel, ViewModelManager manager) {
        this.manager = manager;
        this.vm = browsePageViewmodel;
    }

    /**
     * Switch to browse page
     */
    @Override
    public void prepareSuccessView() {
        manager.setActiveViewName(vm.getViewName()); //redirect to browsing pages
        manager.firePropertyChange();
    }
}
