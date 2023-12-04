package browsePage.browsePageRedirect;

import viewModel.ViewModelManager;

public class BrowsePageRDRPresenter implements BrowsePageRDROB {
    private final ViewModelManager manager;
    private final BrowsePageViewModel browsePageVM;

    public BrowsePageRDRPresenter(ViewModelManager manager, BrowsePageViewModel browsePageViewModel) {
        this.manager = manager;
        this.browsePageVM = browsePageViewModel;
    }

    @Override
    public void prepareSuccessView() {
        manager.setActiveViewName(browsePageVM.getViewName());
        manager.firePropertyChange();
    }
}
