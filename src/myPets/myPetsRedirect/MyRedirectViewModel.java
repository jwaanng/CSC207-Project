package myPets.myPetsRedirect;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;


public class MyRedirectViewModel extends PageRedirectViewModel {
    public final String propertyName = "redirect";

    public MyRedirectViewModel() {
        super("my pet redirect");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
