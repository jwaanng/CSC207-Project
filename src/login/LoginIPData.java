package login;

public class LoginIPData {
    private String username;
    private String password;

    public LoginIPData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
