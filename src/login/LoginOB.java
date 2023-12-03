package login;

/**
 * This interface specifies required methods for a login usercase presenter
 */
public interface LoginOB {
    /***
     * a presenter of this usecase can tell the screen to set up the user's information when the login is successful
     */
    void prepareSuccessView(LoginOPData outdata);

    /***
     * a presenter of this usecase can tell the screen to display the reason the login failed
     */
    void prepareFailView(LoginOPData outdata);
}
