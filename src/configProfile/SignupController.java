package configProfile;

import signupPage.signup.SignupIB;
import signupPage.signup.SignupIPData;

public class SignupController {

    final SignupIB userSignupUseCaseInteractor;
    public SignupController(SignupIB userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password, String repeatedPassword, String address, String instagram) {

        SignupIPData signupIPData = new SignupIPData(
                username, password, repeatedPassword, address, instagram);

        userSignupUseCaseInteractor.execute(signupIPData);
    }
}
