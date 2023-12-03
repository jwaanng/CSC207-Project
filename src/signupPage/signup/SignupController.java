
package signupPage.signup;

/**
 * Controller class for user signup.
 * <p>
 * This class serves as a controller in the Model-View-Controller (MVC) architecture for the
 * user signup feature. It interacts with the corresponding use case interactor
 * (SignupInputBound) to execute the necessary actions based on user input.
 */
public class SignupController {
    final SignupIB userSignupUseCaseInteractor;

    /**
     * Constructor a SignupController object.
     *
     * @param userSignupUseCaseInteractor The use case interactor associated with this controller.
     */
    public SignupController(SignupIB userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }


    /**
     * Executes the user signup feature.
     * <p>
     * This method constructs an instance of SignUpInputData with the provided parameters
     * and delegates the execution of the user signup feature to the associated use case interactor.
     *
     * @param username         The username chosen by the user during signup.
     * @param password         The password chosen by the user during signup.
     * @param repeatedPassword The repeated password entered by the user during signup.
     * @param address          The address provided by the user during signup.
     * @param instagram        The Instagram handle provided by the user during signup.
     */
    public void execute(String username, String password, String repeatedPassword, String address, String instagram) {
        SignupIPData signupIPData = new SignupIPData(
                username, password, repeatedPassword, address, instagram);

        userSignupUseCaseInteractor.execute(signupIPData);

    }
}
