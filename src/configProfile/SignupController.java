package configProfile;

import signupPage.signup.SignupInputBound;
import signupPage.signup.SignupInputData;

public class SignupController {

    final SignupInputBound userSignupUseCaseInteractor;
    public SignupController(SignupInputBound userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password, String repeatedPassword, String address, String instagram) {
        System.out.println("CONTROLLER executed");
        SignupInputData signupInputData = new SignupInputData(
                username, password, repeatedPassword, address, instagram);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
