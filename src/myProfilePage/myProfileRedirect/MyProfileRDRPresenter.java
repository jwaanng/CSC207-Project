package myProfilePage.myProfileRedirect;

import myProfilePage.MyProfileViewModel;
import viewModel.ViewModelManager;

public class MyProfileRDRPresenter implements MyProfileRDROB {
    private final ViewModelManager manager;
    private final MyProfileViewModel myProfileVM;

    public MyProfileRDRPresenter(ViewModelManager manager, MyProfileViewModel myProfileVM) {
        this.manager = manager;
        this.myProfileVM = myProfileVM;
    }

    @Override
    public void prepareSuccessView() {
        myProfileVM.getConfigProfileViewModel().firePropertyChanged(); //refresh the text field in case changed
        manager.setActiveViewName(myProfileVM.getViewName());
        manager.firePropertyChange();
    }
}
