package configProfile;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ConfigProfileViewModel extends ViewModel {
    public ConfigProfileViewModel() {
        super("config profile");
    }
    private ConfigProfileState state = new ConfigProfileState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ConfigProfileViewModel(String name) {
        super(name);
    }

    @Override
    public void firePropertyChanged() {
        System.out.println("VIEWMODEL: firing property change");
        support.firePropertyChange("state", null, state);
        System.out.println("VIEWMODEL: property change fired");
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ConfigProfileState getState() {
        System.out.println(state.toString());
        return state;
    }

    public void setState(ConfigProfileState state) {
        this.state = state;
    }
}

