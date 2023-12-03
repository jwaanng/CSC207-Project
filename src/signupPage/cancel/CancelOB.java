package signupPage.cancel;
/**
 * this interface specifies the required methods needed for a presenter usecase interactor
 * */
public interface CancelOB {
    /**
     * presenter must send direction for redirecting to login page
     * usecase is always successful
     * */
    void prepareSuccessView();
}
