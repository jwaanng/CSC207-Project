package signupPage.signup;

/**
 * This class stores information on the state after a user finishes sign up
 */

public class SignupOPData {
    final String username;
    boolean useCaseFailed;

    /***
     * Construct a SignupOPData
     * @param username - the username of the user that tries to sign up
     * @param useCaseFailed - this tells if the user signup is successful or not
     */
    public SignupOPData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

}