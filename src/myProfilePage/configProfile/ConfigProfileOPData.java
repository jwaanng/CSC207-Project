package myProfilePage.configProfile;

/**
 * The {@code ConfigProfileOPDATA} class encapsulates the output data after a configuration
 * profile operation, providing information about the operation's result.
 * Instances of this class are used to convey the outcome of the use case to the presentation layer.
 *
 * The class includes the name associated with the configuration profile and a flag indicating
 * whether the use case execution has failed.
 *
 * @author [Your Name]
 * @version 1.0
 */
public class ConfigProfileOPData {

    String address;
    String bio;
    String name;
    String preferredSize;
    String preferredSex;
    private boolean useCaseFailed;

    /**
     * Constructs a {@code ConfigProfileOPDATA} instance with the specified name and use case failure status.
     *
     * @param name           The name associated with the configuration profile.
     * @param useCaseFailed  A flag indicating whether the use case execution has failed.
     */
    public ConfigProfileOPData(String name, String address, String bio, String preferredSize, String preferredSex,
                               boolean useCaseFailed) {
        this.name = name;
        this.address = address;
        this.bio = bio;
        this.useCaseFailed = useCaseFailed;
        this.preferredSize = preferredSize;
        this.preferredSex = preferredSex;
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