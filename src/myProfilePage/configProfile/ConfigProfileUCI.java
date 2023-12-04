package myProfilePage.configProfile;

import dataAccessObject.UserDataAccessInterface;
import entity.user.AppUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code ConfigProfileUCI} class represents the use case interactor responsible for handling
 * the logic related to configuring user profiles. Implements the {@code ConfigProfileInputBoundary} interface.
 * This class validates input data, performs necessary checks, and updates user profiles accordingly.
 */
public class ConfigProfileUCI implements ConfigProfileIB {
    final UserDataAccessInterface userDataAccessInterface;
    final ConfigProfileOB configProfilePresenter;

    /**
     * Constructs a {@code ConfigProfileUCI} with the specified data access interface and output boundary.
     *
     * @param userDataAccessInterface The data access interface for interacting with user profiles.
     * @param configProfilePresenter          The output boundary for presenting success or failure views.
     */
    public ConfigProfileUCI(UserDataAccessInterface userDataAccessInterface, ConfigProfileOB configProfilePresenter) {
        this.userDataAccessInterface = userDataAccessInterface;
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
    public void execute(ConfigProfileIPData data) {

        if (containsSpecialChars(data.getAddress())) {
            // if the address contains special characters
            configProfilePresenter.prepareFailView("Make sure address doesn't contain special characters");
        } else if (data.getBio().length() > 150) {
            // if the bio is too long
            configProfilePresenter.prepareFailView("Keep bio under 150 characters.");
        } else {
            // TODO2 Done -ming: saving the info if all parameters are met.
            AppUser user = userDataAccessInterface.retrieve(data.getUsername());
            // setting attributes to user
            user.setBio(data.getBio());
            user.setAddress(data.getAddress());
            user.setPreferredSize(data.getSize());
            user.setPreferredSex(data.getSex());
            userDataAccessInterface.update(user);
            ConfigProfileOPData opData = new ConfigProfileOPData(data.getUsername(),
                    data.getAddress(),
                    data.getBio(),
                    data.getSize(), data.getSex(), false);
            configProfilePresenter.prepareSuccessView(opData);
        }
    }
}