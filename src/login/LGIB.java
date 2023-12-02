package login;

/**
 * The LGIB (Login Interactor Base) interface defines the contract for login-related use case interactors.
 */
public interface LGIB {
    /**
     * calls execute using thedata from loginData
     *
     * @param loginData login data containing usernmae and pass
     */
    void execute(LGIPData loginData);
}
