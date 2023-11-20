package Login;

public class LGState {
    private String username = "";
    private String password = "";

    private String error = null;

    public LGState(LGState copy){
        this.username = copy.username;
        this.password = copy.password;
    }
    public LGState(){}


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
