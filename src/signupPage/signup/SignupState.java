package signupPage.signup;

/**
 * Represents the state of the user signup view.
 * <p>
 * This class encapsulates the current state of the user signup view, including fields such as
 * username, password, repeated password, address, Instagram handle, and any associated error messages.
 * It provides methods for getting and setting these fields, as well as creating a copy of the state.
 */
public class SignupState {
    private String username = "";
    private String error = null;

    private String password = "";

    private String repeatPassword = "";

    private String address = "";

    private String instagram = "";

    /**
     * Copy constructor for creating a deep copy of a SignupState object.
     *
     * @param copy The SignupState object to be copied.
     */
    public SignupState(SignupState copy) {
        error = copy.error;
        username = copy.username;
        password = copy.password;
        repeatPassword = copy.repeatPassword;
        address = copy.address;
        instagram = copy.instagram;
    }

    /**
     * Default constructor for creating a new SignupState object.
     */
    public SignupState() {
    }

    /**
     * Gets the username entered during signup.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the error message associated with the signup process, if any.
     *
     * @return The error message.
     */
    public String getError() {
        return error;
    }

    /**
     * Gets the password entered during signup.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the repeated password entered during signup.
     *
     * @return The repeated password.
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Gets the address entered during signup.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the Instagram handle entered during signup.
     *
     * @return The Instagram handle.
     */
    public String getInstagram() {
        return instagram;
    }

    /**
     * Sets the username.
     *
     * @param username The username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the error message.
     *
     * @param error The error message to be set.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Sets the password.
     *
     * @param password The password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the repeated password.
     *
     * @param repeatPassword The repeated password to be set.
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    /**
     * Sets the address.
     *
     * @param address The address to be set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the Instagram handle.
     *
     * @param instagram The Instagram handle to be set.
     */
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    /**
     * Overrides the default toString method to provide a string representation of the SignupState object.
     *
     * @return A string representation of the SignupState object.
     */
    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", address='" + address + '\'' +
                ", error='" + error + '\'' +
                ", instagram='" + instagram + '\'' +
                '}';
    }
}