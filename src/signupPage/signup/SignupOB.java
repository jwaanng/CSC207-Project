package signupPage.signup;

/**
 * This interface specifies required methods for a signup usercase presenter
 */
public interface SignupOB {
    /***
     * a presenter of this usecase can redirect the user to the login page if sign up is successful
     */
    void prepareSignupSuccessView(SignupOPData user);

    /***
     * a presenter of this usecase can display the error for sign up to fail
     */
    void prepareSignUpFailView(String error);
}