package usecase.signUp;

/**
 * The {@code SignupOutputBound} interface defines the output boundary for presenting
 * the results of the user sign-up operation. Classes implementing this interface are
 * responsible for preparing and presenting views in case of operation success or failure.
 *
 * Implementing classes should handle the presentation of success views and failure views
 * based on the provided output data.
 */
public interface SignupOutputBound {

    /**
     * Prepares and presents a success view with the provided user output data.
     *
     * This method is called when the user sign-up operation is successful,
     * and the implementation should handle the presentation of success views.
     *
     * @param userData The output data containing user information after a successful sign-up.
     */
    void prepareSignupSuccessView(SignupOutputData userData);

    /**
     * Prepares and presents a failure view with the specified error message.
     *
     * This method is called when the user sign-up operation encounters an error,
     * and the implementation should handle the presentation of the error message or failure view.
     *
     * @param error The error message to be presented in the failure view.
     */
    void prepareSignUpFailView(String error);
}