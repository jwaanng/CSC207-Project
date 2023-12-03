package usecase.configProfile;

/**
 * The {@code ConfigProfileInputBoundary} interface defines the input boundary for interacting
 * with the use case related to configuration profile operations. Classes implementing this
 * interface are responsible for executing the use case based on the provided input data.
 *
 * Implementing classes should handle the execution of actions related to configuration profile
 * manipulation, such as updating, creating, or deleting profiles.
 *
 * @author [Your Name]
 * @version 1.0
 */
public interface ConfigProfileInputBoundary {

    /**
     * Executes the use case based on the provided input data.
     *
     * The implementation of this method should handle the logic for configuration profile
     * operations, considering the data provided in the {@code ConfigProfileInputData}.
     *
     * @param configProfileInputData The input data containing information about the
     *                                configuration profile operation.
     */
    void execute(ConfigProfileInputData configProfileInputData);
}