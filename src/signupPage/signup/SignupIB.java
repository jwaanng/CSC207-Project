package signupPage.signup;

/**
 * This interface specifies required methods for a sigun up usecase interactor
 */
public interface SignupIB {
    /***
     * an interactor of this usecase can execute a user request's to sign up
     */
    void execute(SignupIPData data);
}
