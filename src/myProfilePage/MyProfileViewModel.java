package myProfilePage;

import myProfilePage.changeProfile.ChangeProfileViewModel;
import myProfilePage.configProfile.ConfigProfileViewModel;
import org.checkerframework.checker.units.qual.C;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class MyProfileViewModel extends ViewModel {
    /**
     * Constructs a {@code ViewModel} with the specified name.
     *
     */
    private final ConfigProfileViewModel configProfileViewModel = new ConfigProfileViewModel();
    private final ChangeProfileViewModel changeProfileViewModel = new ChangeProfileViewModel();
    private final MyProfileRDRViewModel myProfileRDRViewModel = new MyProfileRDRViewModel();

    public MyProfileViewModel() {
        super("my profile page");
    }

    public ConfigProfileViewModel getConfigProfileViewModel() {
        return configProfileViewModel;
    }

    public ChangeProfileViewModel getChangeProfileViewModel() {
        return changeProfileViewModel;
    }

    public MyProfileRDRViewModel getMyProfileRDRViewModel() {return myProfileRDRViewModel;}
    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
