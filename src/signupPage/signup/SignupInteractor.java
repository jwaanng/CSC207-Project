package signupPage.signup;

import dataAcessObject.UserDataAcessInterface;
import entity.user.AppUser;
import entity.user.AppUserFactory;

public class SignupInteractor implements SignupInputBound {
    private final UserDataAcessInterface userDataAccessObject;
    private final SignupOutputBound userPresenter;
    private final AppUserFactory userFactory;

    public SignupInteractor(UserDataAcessInterface userDataAccessObject, SignupOutputBound userPresenter, AppUserFactory userFactory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignupInputData data) {
        if (userDataAccessObject.exist(data.getUsername())){
            userPresenter.prepareSignUpFailView("Username already exists.");
        } else if (!data.getPassword().equals(data.getRepeatedPassword())) {
            userPresenter.prepareSignUpFailView("Passwords don't match.");
        } else {
            AppUser user = userFactory.createAppUser(data.getUsername(), data.getPassword(), data.getAddress(), data.getInstagram());
            userDataAccessObject.add(user);
            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSignupSuccessView(signupOutputData);
        }
    }
}
