package myPets.myPetsRedirect;

import myPets.InnerViewModelManager;
import myPets.MyPetsViewModel;

public class MyRedirectPresenter implements MyRedirectOB {
    private final InnerViewModelManager manager;
    //TODO change to myPets main page view model
    private final MyPetsViewModel mrvm;


    public MyRedirectPresenter(MyPetsViewModel mrvm, InnerViewModelManager manager) {
        this.mrvm = mrvm;
        this.manager = manager;
    }


    @Override
    public void prepareSuccessView() {
        //cpvm.viewmodelsfirePropertyChanges();
        manager.setActiveViewName(mrvm.getViewName());
        manager.firePropertyChange();
        System.out.println("Redirect to MyPets");
        mrvm.firePropertyChanged();
        manager.firePropertyChange();
    }
}
