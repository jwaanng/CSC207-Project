package login;

/**
 * The LGIPData (Login Input Data) class represents the data needed for the login process.
 */
public class LGIPData {

    private final String username;
    private final String password;

    /**
     * Constructs an instance of LGIPData with the provided username and password.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    public LGIPData(String username, String password) {
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