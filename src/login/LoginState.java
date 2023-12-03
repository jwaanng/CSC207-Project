package login;


/**
 * The {@code LGState} class represents the state of the login view, including the entered username,
 * password, and any associated error messages.
 */
public class LoginState {

    /**
     * The entered username for the login view.
     */
    private String username = "";

    /**
     * The entered password for the login view.
     */
    private String password = "";

    /**
     * The error message associated with the login view.
     */
    private String error = null;


    /**
     * Constructs an {@code LoginState} instance by copying the data from another instance.
     *
     * @param copy The {@code LoginState} instance to copy.
     */
    public LoginState(LoginState copy) {
        this.username = copy.username;
        this.password = copy.password;
        this.error = copy.error;
    }

    /**
     * Constructs an empty {@code LoginState} instance.
     */
    public LoginState() {
        ;
    }


    /**
     * Gets the entered username for the login view.
     *
     * @return The entered username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the entered username for the login view.
     *
     * @param username The entered username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the entered password for the login view.
     *
     * @return The entered password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the entered password for the login view.
     *
     * @param password The entered password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the error message associated with the login view.
     *
     * @return The error message, or {@code null} if there is no error.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message for the login view.
     *
     * @param error The error message.
     */
    public void setError(String error) {
        this.error = error;
    }
}