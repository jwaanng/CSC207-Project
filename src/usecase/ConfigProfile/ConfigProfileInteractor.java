package usecase.ConfigProfile;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigProfileInteractor implements ConfigProfileInputBoundary {
    ConfigProfileDataAccessInterface configProfileDataAccessInterface;
    ConfigProfileOutputBoundary configProfilePresenter; // this sets the output view (fail/success)

    public ConfigProfileInteractor(ConfigProfileDataAccessInterface configProfileDataAccessInterface, ConfigProfileInteractor configProfilePresenter, ConfigProfileOutputBoundary configProfileOutputBoundary) {
        this.configProfileDataAccessInterface = configProfileDataAccessInterface;
        this.configProfilePresenter = configProfileOutputBoundary;
    }

    // Helper method to help you see if a string contains any of these characters - jw
    public static boolean containsSpecialChars(String str) {
        Pattern specialChars = Pattern.compile("[`!@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?~]");
        Matcher matcher = specialChars.matcher(str);
        return matcher.find();
    }

    @Override
    public void execute(ConfigProfileInputData configProfileInputData) {

        if (containsSpecialChars(configProfileInputData.getName())) {
            // if the name does contain any special characters
            configProfilePresenter.prepareFailView("Make sure name doesn't contain special characters");
            // TODO: haven't implemented failView yet- jw
        } else if (configProfileInputData.getBio().length() > 150) {
            // if the bio is too long
            configProfilePresenter.prepareFailView("Keep bio under 150 characters.");
        } else {
//            LocalDateTime now = LocalDateTime.now();
//            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), now);
//            userDataAccessObject.save(user);
//
//            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), now.toString(), false);
//            userPresenter.prepareSuccessView(signupOutputData);
            // TODO 2: saving the info if all parameters are met.
        }
    }
}
