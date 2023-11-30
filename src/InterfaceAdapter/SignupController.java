package InterfaceAdapter;

import usecase.SignUp.SignupInputBound;
import usecase.SignUp.SignUpInputData;

public class SignupController {

    final SignupInputBound userSignupUseCaseInteractor;
    public SignupController(SignupInputBound userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password, String repeatedPassword, String address) {
        System.out.println("CONTROLLER executed");
        SignUpInputData signupInputData = new SignUpInputData(
                username, password, repeatedPassword, address);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
