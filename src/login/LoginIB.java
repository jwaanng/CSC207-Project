package login;

/**
 * This interface specifies required methods for a login usecase interactor
 */
public interface LoginIB {
    /***
     * an interactor of this usecase can execute a user request's to log in
     */
    void execute(LoginIPData loginData);
}
