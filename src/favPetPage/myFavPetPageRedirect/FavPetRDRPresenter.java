package favPetPage.myFavPetPageRedirect;

import favPetPage.FavPetPageViewModel;
import viewModel.ViewModelManager;
import redirect.PageRedirectViewModel;

public class FavPetRDRPresenter implements FavPetRDROB {
    private final ViewModelManager manager;
    private final FavPetPageViewModel myFPPvm;

    public FavPetRDRPresenter(FavPetPageViewModel myFPPvm, ViewModelManager manager) {
        this.myFPPvm = myFPPvm;
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
