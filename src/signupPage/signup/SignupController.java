package signupPage.signup;

public class SignupController {
    final SignupInputBound signupInteractor;
    public SignupController(SignupInputBound interactor) {
        this.signupInteractor = interactor;
    }

    public void execute(String username, String password1, String password2, String address, String instagram) {
        SignupInputData inputData = new SignupInputData(username, password1,
                password2, address, instagram);
        signupInteractor.execute(inputData);
    }
}
