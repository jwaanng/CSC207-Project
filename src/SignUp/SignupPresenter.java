package SignUp;

import usecase.SignUp.SignupOutputBound;
import usecase.SignUp.SignupOutputData;

//public class SignupPresenter implements SignupOutputBound {
//    private final SignupViewModel signupViewModel;
//
//    public SignupPresenter(SignupViewModel signupViewModel) {
//        this.signupViewModel = signupViewModel;
//    }
//
//    @Override
//    public void prepareSignupSuccessView(SignupOutputData user) {
//
//    }
//
//    @Override
//    public void prepareSignUpFailView(String error) {
//        SignupState signupState = signupViewModel.getState();
//        signupState.setUsernameError(error);
//        signupViewModel.firePropertyChanged();
//    }
//}