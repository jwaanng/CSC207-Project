package usecase.configProfile;

// Get the input data from ConfigProfileView: name (user's name), address, bio (optional), size, sex
/**
 * The {@code ConfigProfileInputData} class encapsulates the input data required for configuring
 * a user profile. Instances of this class are used to pass relevant information to the
 * {@code ConfigProfileInputBoundary} for processing configuration profile operations.
 *
 * This class is typically instantiated with the necessary information, such as username, address,
 * bio, size, and sex, to represent the desired configuration changes.
 *
 * @author iwanna sleep
 */
public class ConfigProfileInputData {

    private final String username;
    private final String address;
    private final String bio;
    private final String size;
    private final String sex;

    /**
     * Constructs a {@code ConfigProfileInputData} instance with the specified parameters.
     *
     * @param username The new username for the configuration profile.
     * @param address  The new address for the configuration profile.
     * @param bio      The new bio for the configuration profile.
     * @param size     The new size information for the configuration profile.
     * @param sex      The new sex information for the configuration profile.
     */
    public ConfigProfileInputData(String username, String address, String bio, String size, String sex) {
        this.username = username;
        this.address = address;
        this.bio = bio;
        this.size = size;
        this.sex = sex;
    }

    /**
     * Gets the username from the configuration profile input data.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the address from the configuration profile input data.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the bio from the configuration profile input data.
     *
     * @return The bio.
     */
    public String getBio() {
        return bio;
    }

    /**
     * Gets the size information from the configuration profile input data.
     *
     * @return The size information.
     */
    public String getSize() {
        return size;
    }

    /**
     * Gets the sex information from the configuration profile input data.
     *
     * @return The sex information.
     */
    public String getSex() {
        return sex;
    }
}