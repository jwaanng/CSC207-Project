package configProfile;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ConfigProfileViewModel extends ViewModel {
    public static final String TITLE_LABEL = "My Profile";
    public static final String USERNAME_LABEL = "Username";
    public static final String CONFIRM_BUTTON = "Confirm";
    public static final String BIO_LABEL = "Bio";
    public static final String ADDRESS_LABEL = "Address";
    public static final String SIZE_LABEL = "Size";
    public static final String SEX_LABEL = "Sex";

    private ConfigProfileState state = new ConfigProfileState();

    public ConfigProfileViewModel() {
        super("My Profile");
    }

    public void setState(ConfigProfileState state) {
        this.state = state;
    }
    public ConfigProfileState getState() {
        return state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        System.out.println("VIEWMODEL: property change fired");
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
