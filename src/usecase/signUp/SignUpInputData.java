package usecase.signUp;

/**
 * The {@code SignUpInputData} class encapsulates the input data required for the sign-up use case.
 * Instances of this class are used to pass relevant information to the {@code SignupInputBound} for
 * processing user registration.
 *
 * This class typically contains user registration details, such as username, password, repeated password,
 * address, and optional Instagram information.
 */
public class SignUpInputData {

    private String username;
    private String password;
    private String repeatedPassword;
    private String address;
    private String instagram;

    /**
     * Constructs a {@code SignUpInputData} instance with the specified parameters.
     *
     * @param username         The username for user registration.
     * @param password         The password for user registration.
     * @param repeatedPassword The repeated password for confirmation.
     * @param address          The address information for user registration.
     * @param instagram        The optional Instagram information for user registration.
     */
    public SignUpInputData(String username, String password, String repeatedPassword, String address, String instagram) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.address = address;
        this.instagram = instagram;
    }

    /**
     * Gets the username from the sign-up input data.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password from the sign-up input data.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the repeated password from the sign-up input data.
     *
     * @return The repeated password.
     */
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    /**
     * Gets the address from the sign-up input data.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the Instagram information from the sign-up input data.
     *
     * @return The Instagram information.
     */
    public String getInstagram() {
        return instagram;
    }
}