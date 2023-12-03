package usecase.signUp;

/**
 * The {@code SignupOutputData} class encapsulates the output data after a user sign-up operation,
 * providing information about the operation's result.
 * Instances of this class are used to convey the outcome of the sign-up use case to the presentation layer.
 *
 * The class includes the username associated with the signed-up user and a flag indicating
 * whether the use case execution has failed.
 */
public class SignupOutputData {

    private final String username;
    private boolean useCaseFailed;

    /**
     * Constructs a {@code SignupOutputData} instance with the specified username and use case failure status.
     *
     * @param username        The username associated with the signed-up user.
     * @param useCaseFailed   A flag indicating whether the use case execution has failed.
     */
    public SignupOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the username associated with the signed-up user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks if the use case execution has failed.
     *
     * @return {@code true} if the use case has failed; {@code false} otherwise.
     */
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}