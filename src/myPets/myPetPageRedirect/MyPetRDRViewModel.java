package myPets.myPetPageRedirect;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;


public class MyPetRDRViewModel extends PageRedirectViewModel {
    public final String propertyName = "redirect";

    public MyPetRDRViewModel() {
        super("my pet redirect");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
