package favPetPage.redirect;

import viewModel.PageRedirectViewModel;
import viewModel.ViewModelManager;

public class RDPresenter implements RDOB{
    private final PageRedirectViewModel vm;
    private final ViewModelManager manager;

    public RDPresenter(PageRedirectViewModel pageRedirectViewModel, ViewModelManager manager) {
        this.vm = pageRedirectViewModel;
        this.manager = manager;
    }


    @Override
    public void prepareSuccessView(RDOPData outputData) {
        manager.setActiveViewName(outputData.getViewName());
        manager.firePropertyChange();
    }
}
