package signUp;

import usecase.SignUp.SignUpInputData;
import usecase.SignUp.SignupInputBound;

public class SignupController {
    final SignupInputBound signupInteractor;
    public SignupController(SignupInputBound interactor) {
        this.signupInteractor = interactor;
    }

    public void execute(String username, String password1, String password2, String address) {
        SignUpInputData inputData = new SignUpInputData(username, password1,
                password2, address);
        signupInteractor.signup(inputData);
    }
}
