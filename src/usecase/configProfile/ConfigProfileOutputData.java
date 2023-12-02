package usecase.configProfile;

/**
 * The {@code ConfigProfileOutputData} class encapsulates the output data after a configuration
 * profile operation, providing information about the operation's result.
 * Instances of this class are used to convey the outcome of the use case to the presentation layer.
 *
 * The class includes the name associated with the configuration profile and a flag indicating
 * whether the use case execution has failed.
 *
 * @author [Your Name]
 * @version 1.0
 */
public class ConfigProfileOutputData {

    private final String name;
    private boolean useCaseFailed;

    /**
     * Constructs a {@code ConfigProfileOutputData} instance with the specified name and use case failure status.
     *
     * @param name           The name associated with the configuration profile.
     * @param useCaseFailed  A flag indicating whether the use case execution has failed.
     */
    public ConfigProfileOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the name associated with the configuration profile.
     *
     * @return The name.
     */
    public String getName() {
        return name;
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