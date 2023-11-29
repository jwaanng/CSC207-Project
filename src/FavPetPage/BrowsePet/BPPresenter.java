package FavPetPage.BrowsePet;

import BrowsePage.BrowsePageViewModel;
import ViewModel.ViewModelManager;

public class BPPresenter implements BPOB{

    private final ViewModelManager manager;
    private final BrowsePageViewModel vm;

    public BPPresenter(BrowsePageViewModel browsePageviewmodel, ViewModelManager manager) {
        this.manager = manager;
        this.vm = browsePageviewmodel;
    }

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
