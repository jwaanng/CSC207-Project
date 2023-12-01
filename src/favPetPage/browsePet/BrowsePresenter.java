package favPetPage.browsePet;

import browsePage.BrowsePageViewModel;
import viewModel.ViewModelManager;

/**
 * An implementation of the browsePet usecase presenter
 * Tasks with notifying the frontend to switch screen to the page for browsing pets
 */
public class BrowsePresenter implements BrowseOB {

    private final ViewModelManager manager;
    private final BrowsePageViewModel vm;

    /**
     * Construct an BrowsePresenter
     *
     * @param browsePageViewmodel a viewmodel for the browsePet usecase. This is called by the BrowsePresenter to
     *                            realize switching view
     * @param manager             a manager that manages which main page of the application to be displayed
     */
    public BrowsePresenter(BrowsePageViewModel browsePageViewmodel, ViewModelManager manager) {
        this.manager = manager;
        this.vm = browsePageViewmodel;
    }

    /**
     * Switch the main page to browse page
     */
    @Override
    public void prepareSuccessView() {
        //TODO
        /* need output data that contains a list of recommendation based on geocoordinates distance,
           this will be used to set a state in the BrowsePageViewModel which the view will get information and
           display the appropriate profile to the user.
           Thoughts, the view which is a Jpanel in cardboardlayout will be dynamic, i.e. it will contain JPanel each
           representing a recommendation petprofile that will be created based on the state
           */
        manager.setActiveViewName(vm.getViewName()); //redirect to browsing pages
        manager.firePropertyChange();
    }
}
