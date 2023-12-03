package signupPage.signup;

/**
 * This class stores all information that user enter during sign up
 */
public class SignupIPData {
    String username;
    String password;
    String repeatedPassword;
    String address;
    String instagram;

    /**
     * Construct a new SignupIPData
     *
     * @param username         the username that user chose
     * @param password         the password that user chose
     * @param repeatedPassword the password that user reentered
     * @param address          the address that user entered
     * @param instagram        the instagram account name that the user entered
     */
    public SignupIPData(String username, String password, String repeatedPassword, String address, String instagram) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.instagram = instagram;
        this.address = address;
    }


}
