package favPetPage.browsePet;

import browsePage.BrowsePageViewModel;
import browsePage.browsePageRedirect.BrowsePageRDRController;
import viewModel.ViewModelManager;

/**
 * A concrete implementation of {@link BrowseOB}
 * <p>
 * An implementation of the browsePet usecase presenter
 * Tasks with notifying the frontend to switch screen to the page for browsing pets
 */
public class BrowsePresenter implements BrowseOB {

   private BrowsePageRDRController browsePageRDRController;
    /**
     * Construct an BrowsePresenter object
     *
     */
    public BrowsePresenter(BrowsePageRDRController browsePageRDRController) {
        this.browsePageRDRController = browsePageRDRController;

    }

    /**
     * Switch to browse page
     */
    @Override
    public void prepareSuccessView() {
        browsePageRDRController.execute();

    }
}
