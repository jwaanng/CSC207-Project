package login;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel{
    public final String APPNAME_LABEL = "PetPal";
    public final String USERNAME_NAME_LABEL = "Username";
    public  final String PASSWORD_NAME_LABEL = "Password";
    public final String LOGIN_LABEL = "Log In";
    public final String CANCEL_LABEL = "Cancel";
    private LoginState state = new LoginState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public LoginViewModel(){super("log in");}

    public void setState(LoginState state){
        this.state = state;
    }

    public LoginState getState(){return state;}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }
}
