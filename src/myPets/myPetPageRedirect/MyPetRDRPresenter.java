package myPets.myPetPageRedirect;

import myPets.MyPetsViewModel;
import viewModel.ViewModelManager;

public class MyPetRDRPresenter implements MyPetRDROB {
    private final ViewModelManager manager;
    //TODO change to myPets main page view model
    private final MyPetsViewModel mrvm;


    public MyPetRDRPresenter(MyPetsViewModel mrvm, ViewModelManager manager) {
        this.mrvm = mrvm;
        this.manager = manager;
    }


    @Override
    public void prepareSuccessView() {
        manager.setActiveViewName(mrvm.getViewName());
        manager.firePropertyChange();
        mrvm.firePropertyChanged();
        manager.firePropertyChange();
    }
}
