package usecase.SignUp;

public interface SignupOutputBound {
    void prepareSignupSuccessView(SignupOutputData user);
    void prepareSignUpFailView(String error);
}