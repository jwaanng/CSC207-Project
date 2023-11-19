package usecase.SignUp;

import Entity.User.AppUser;

public interface SignupUserDataAccessInterface {
    boolean existByName(String identifier);

    void save(AppUser user);
}
