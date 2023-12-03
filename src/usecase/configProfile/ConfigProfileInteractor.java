package usecase.configProfile;

import configProfile.ConfigProfilePresenter;
import dataAcessObject.CommonUserDataAccessObject;
import dataAcessObject.UserDataAcessInterface;
import entity.user.AppUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code ConfigProfileInteractor} class represents the use case interactor responsible for handling
 * the logic related to configuring user profiles. Implements the {@code ConfigProfileInputBoundary} interface.
 * This class validates input data, performs necessary checks, and updates user profiles accordingly.
 */
public class ConfigProfileInteractor implements ConfigProfileInputBoundary {
    final UserDataAcessInterface configProfileDataAccessInterface;
    final ConfigProfileOutputBoundary configProfilePresenter;

    /**
     * Constructs a {@code ConfigProfileInteractor} with the specified data access interface and output boundary.
     *
     * @param configProfileDataAccessInterface The data access interface for interacting with user profiles.
     * @param configProfilePresenter          The output boundary for presenting success or failure views.
     */
    public ConfigProfileInteractor(UserDataAcessInterface configProfileDataAccessInterface, ConfigProfileOutputBoundary configProfilePresenter) {
        this.configProfileDataAccessInterface = configProfileDataAccessInterface;
//        this.configProfileOutputBoundary = configProfilePresenter;
        this.configProfilePresenter = configProfilePresenter;
    }

    /**
     * Checks if a given string contains any special characters.
     *
     * @param s The string to be checked for special characters.
     * @return {@code true} if the string contains special characters; {@code false} otherwise.
     */
    public boolean containsSpecialChars(String s) {
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Stringempth");
            return true;
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9, ]");
        Matcher m = p.matcher(s);
        return m.find();
    }

    /**
     * Executes the use case based on the provided configuration profile input data.
     * Validates input data, performs necessary checks, and updates user profiles accordingly.
     *
     * @param data The input data containing information for configuring the user profile.
     */
    @Override
    public void execute(ConfigProfileInputData data) {

        if (containsSpecialChars(data.getAddress())) {
            // if the address contains special characters
            System.out.println("INTERACTOR: FIRST IF");
            configProfilePresenter.prepareFailView("Make sure address doesn't contain special characters");
        } else if (data.getBio().length() > 150) {
            // if the bio is too long
            configProfilePresenter.prepareFailView("Keep bio under 150 characters.");
        } else {
            // TODO2 Done -ming: saving the info if all parameters are met.
            AppUser user = configProfileDataAccessInterface.retrieve(data.getUsername()); //TODO: get username
            // setting attributes to user
            user.setBio(data.getBio());
            user.setAddress(data.getAddress());
            user.setPreferredSize(data.getSize());
            user.setPreferredSex(data.getSex());

            System.out.println("INTERACTOR: " + user.getPreferredSex() + " " + user.getPreferredSize());

            configProfileDataAccessInterface.update(user);
            System.out.println("INTERACTOR after: " + user.getPreferredSex() + " " + user.getPreferredSize());
        }
    }
}