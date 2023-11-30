package usecase.SignUp;

import DataAcessObject.UserDataAcessInterface;
import Entity.User.AppUser;
import Entity.User.AppUserFactory;

public class SignupInteractor implements SignupInputBound{
    final UserDataAcessInterface userDataAccessObject;
    final SignupOutputBound userPresenter;
    final AppUserFactory userFactory;

    public SignupInteractor(UserDataAcessInterface userDataAccessObject, SignupOutputBound userPresenter, AppUserFactory userFactory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignUpInputData data) {
        if (userDataAccessObject.exist(data.getUsername())){
            System.out.println("INTERACTOR: username alredat exist execute revieved next: presenter");
            userPresenter.prepareSignUpFailView("Username already exists.");
        } else if (!data.getPassword().equals(data.getRepeatedPassword())) {
            System.out.println("usecase failed executed password does not match");
            userPresenter.prepareSignUpFailView("Passwords don't match.");
        } else {
            AppUser user = userFactory.createAppUser(data.getUsername(), data.getPassword(), data.getAddress());
            userDataAccessObject.add(user);
            System.out.println("user created");

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSignupSuccessView(signupOutputData);
        }
    }
}
