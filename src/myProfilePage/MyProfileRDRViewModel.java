package myProfilePage;

import redirect.PageRedirectViewModel;

import java.beans.PropertyChangeListener;

public class MyProfileRDRViewModel extends PageRedirectViewModel {
    /**
     * Creates a new instance of {@code PageRedirectViewModel}.
     *
     */
    public MyProfileRDRViewModel() {
        super("my profile redirect");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
