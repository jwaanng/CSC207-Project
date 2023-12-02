package usecase.configProfile;

/**
 * The {@code ConfigProfileDataAccessInterface} defines the contract for accessing configuration
 * profile data, providing methods for checking the existence of a profile by name and saving
 * profile information to the underlying database.
 *
 * Implementation of this interface should provide concrete functionality for these operations.
 */
public interface ConfigProfileDataAccessInterface {

    /**
     * Checks the existence of a configuration profile with the specified name.
     *
     * @param identifier The name or identifier of the configuration profile to check.
     * @return {@code true} if a profile with the given name exists; {@code false} otherwise.
     */
    boolean existsByName(String identifier);

    // TODO2 done : a 'save' method to save the info into the db. - in db

}