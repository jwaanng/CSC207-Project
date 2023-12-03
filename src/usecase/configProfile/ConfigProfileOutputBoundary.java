package usecase.configProfile;

/**
 * The {@code ConfigProfileOutputBoundary} interface defines the output boundary for presenting
 * the results of configuration profile operations. Classes implementing this interface are
 * responsible for preparing and presenting views in case of operation failures.
 *
 * Implementing classes should handle the presentation of error messages or failure views
 * to the user interface.
 */
public interface ConfigProfileOutputBoundary {

    /**
     * Prepares and presents a failure view with the specified error message.
     *
     * This method is called when a configuration profile operation encounters an error,
     * and the implementation should handle the presentation of the error message or failure view.
     *
     * @param error The error message to be presented in the failure view.
     */
    void prepareFailView(String error);
}