package login;


/**
 * The LoginIPData (Login Input Data) class represents the data needed for the login process.
 */
public class LoginIPData {
    private String username;
    private String password;


    /**
     * Constructs an instance of LoginIPData with the provided username and password.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    public LoginIPData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }
}