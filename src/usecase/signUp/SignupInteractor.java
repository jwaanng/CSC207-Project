package usecase.signUp;

import dataAccessObject.UserDataAccessInterface;
import entity.user.AppUser;
import entity.user.AppUserFactory;

/**
 * The {@code SignupInteractor} class represents the use case interactor responsible for handling
 * the logic related to user sign-up. Implements the {@code SignupInputBound} interface.
 * This class validates input data, performs necessary checks, and initiates user registration.
 */
public class SignupInteractor implements SignupInputBound {

    private final UserDataAccessInterface userDataAccessObject;
    private final SignupOutputBound userPresenter;
    private final AppUserFactory userFactory;

    /**
     * Constructs a {@code SignupInteractor} with the specified data access interface, output boundary,
     * and user factory.
     *
     * @param userDataAccessObject The data access object for interacting with user data.
     * @param userPresenter         The output boundary for presenting success or failure views.
     * @param userFactory           The factory for creating new AppUser instances.
     */
    public SignupInteractor(UserDataAccessInterface userDataAccessObject, SignupOutputBound userPresenter, AppUserFactory userFactory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    /**
     * Executes the sign-up use case based on the provided sign-up input data.
     * Validates input data, performs necessary checks, and initiates user registration.
     *
     * @param data The input data containing user registration information.
     */
    @Override
    public void execute(SignUpInputData data) {
        if (userDataAccessObject.exist(data.getUsername())){
            System.out.println("INTERACTOR: username already exists, execute received next: presenter");
            userPresenter.prepareSignUpFailView("Username already exists.");
        } else if (!data.getPassword().equals(data.getRepeatedPassword())) {
            System.out.println("use case failed executed, password does not match");
            userPresenter.prepareSignUpFailView("Passwords don't match.");
        } else {
            AppUser user = userFactory.createAppUser(data.getUsername(), data.getPassword(), data.getAddress(), data.getInstagram());
            userDataAccessObject.add(user);
            System.out.println("User created");

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSignupSuccessView(signupOutputData);
        }
    }
}