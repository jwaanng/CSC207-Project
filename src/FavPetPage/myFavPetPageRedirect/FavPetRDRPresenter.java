package FavPetPage.myFavPetPageRedirect;

import FavPetPage.FavPetPageViewModel;
import ViewModel.ViewModelManager;
import redirect.PageRedirectViewModel;

public class FavPetRDRPresenter implements FavPetRDROB {
    private final PageRedirectViewModel vm;
    private final ViewModelManager manager;
    private final FavPetPageViewModel myFPPvm;

    public FavPetRDRPresenter(FavPetPageViewModel myFPPvm, ViewModelManager manager) {
        this.myFPPvm = myFPPvm;
        this.vm = myFPPvm.getFavPetRDRViewModel();
        this.manager = manager;
    }


    @Override
    public void prepareSuccessView() {
        myFPPvm.viewmodelsfirePropertyChanges();
        manager.setActiveViewName(myFPPvm.getViewName());
        myFPPvm.firePropertyChanged();
        manager.firePropertyChange();

    }
}
