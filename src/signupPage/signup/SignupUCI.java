package signupPage.signup;

import dataAccessObject.UserDataAccessInterface;
import entity.user.AppUser;
import entity.user.AppUserFactory;

/**
 * A concrete implementation of {@link SignupIB}
 * <p>
 * An implementation of a signup usecase interactor that registers a user to the app
 */

public class SignupUCI implements SignupIB {
    private final UserDataAccessInterface userDataAccessObject;
    private final SignupOB userPresenter;
    private final AppUserFactory userFactory;

    /**
     * Construct a new usecase interactor
     *
     * @param userDataAccessInterface a data access object that implements {@link UserDataAccessInterface}
     *                                which can interact with the user database
     * @param userPresenter           a presenter implementing {@link SignupPresenter}
     *                                <p>
     *                                This is called by the interactor to  finishes the signup usecase
     * @param userFactory             a {@link AppUserFactory} that generates a new user to the app
     */
    public SignupUCI(UserDataAccessInterface userDataAccessInterface, SignupOB userPresenter, AppUserFactory userFactory) {
        this.userDataAccessObject = userDataAccessInterface;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    /**
     * sign up a user
     *
     * @param data the SignupIPData that stores all information that a user entered during signup
     *             which can interact with the user database
     */
    @Override
    public void execute(SignupIPData data) {
        if (userDataAccessObject.exist(data.username)) {
            userPresenter.prepareSignUpFailView("Username already exists.");
        } else if (!data.password.equals(data.repeatedPassword)) {
            userPresenter.prepareSignUpFailView("Passwords don't match.");
        } else {
            AppUser user = userFactory.createAppUser(data.username, data.password, data.address, data.instagram);
            userDataAccessObject.add(user);
            SignupOPData signupOPData = new SignupOPData(user.getUsername(), false);
            userPresenter.prepareSignupSuccessView(signupOPData);
        }
    }
}
