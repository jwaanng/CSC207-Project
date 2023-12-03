package usecase.signUp;

/**
 * The {@code SignupInputBound} interface defines the input boundary for the sign-up use case.
 * Classes implementing this interface are responsible for executing the sign-up operation based
 * on the provided input data, typically containing user registration information.
 *
 * Implementing classes should handle the logic for user registration, validation, and storage.
 */
public interface SignupInputBound {

    /**
     * Executes the sign-up use case based on the provided input data.
     *
     * The implementation of this method should handle the logic for user registration, including
     * validation of input data and storage of user information.
     *
     * @param data The input data containing user registration information.
     */
    void execute(SignUpInputData data);
}