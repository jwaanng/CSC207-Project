package login;

/**
 * The LGController class is responsible for controlling login-related functionality.
 */
public class LGController {

    private final LGIB loginUseCaseInteractor;

    /**
     * Constructs an LGController with the provided LoginUseCaseInteractor.
     *
     * @param loginUseCaseInteractor The login use case interactor to be used.
     */
    public LGController(LGIB loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the login process with the provided username and password.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    public void execute(String username, String password) {
        LGIPData loginInputData = new LGIPData(username, password);
        loginUseCaseInteractor.execute(loginInputData);
    }
}