package signUp;

import usecase.signUp.SignUpInputData;
import usecase.signUp.SignupInputBound;

public class SignupControllerDontUse {
    final SignupInputBound signupInteractor;
    public SignupControllerDontUse(SignupInputBound interactor) {
        this.signupInteractor = interactor;
    }

    public void execute(String username, String password1, String password2, String address, String instagram) {
        SignUpInputData inputData = new SignUpInputData(username, password1,
                password2, address, instagram);
        signupInteractor.execute(inputData);
    }
}
