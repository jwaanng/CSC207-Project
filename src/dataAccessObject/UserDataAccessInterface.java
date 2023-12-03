package dataAccessObject;

import entity.user.AppUser;

/**
 * Interface for accessing and manipulating user data.
 */
public interface UserDataAccessInterface {

    /**
     * Adds a new user to the data source.
     *
     * @param user The AppUser object representing the user to be added.
     */
    void add(AppUser user);

    /**
     * Updates an existing user in the data source.
     *
     * @param user The AppUser object representing the updated user information.
     */
    void update(AppUser user);

    /**
     * Deletes a user from the data source.
     *
     * @param username The username of the user to be deleted.
     */
    void delete(String username);

    /**
     * Retrieves a user's information from the data source.
     *
     * @param username The username of the user to be retrieved.
     * @return The AppUser object representing the retrieved user information.
     */
    AppUser retrieve(String username);

    /**
     * Checks if a user with the specified username exists in the data source.
     *
     * @param username The username to check for existence.
     * @return True if the user exists, false otherwise.
     */
    boolean exist(String username);
}