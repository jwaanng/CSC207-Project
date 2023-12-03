package login;

public class LoginState {
    private String username = "";
    private String password = "";

    private String error = null;

    public LoginState(LoginState copy){
        this.username = copy.username;
        this.password = copy.password;
    }
    public LoginState(){}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
