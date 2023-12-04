package myProfilePage.configProfile;

/**
 * Controller class for configuring user profiles.
 *
 * This class serves as a controller in the Model-View-Controller (MVC) architecture for the
 * user profile configuration feature. It interacts with the corresponding use case interactor
 * (ConfigProfileInputBoundary) to execute the necessary actions based on user input.
 */
public class ConfigProfileController {

    /**
     * The use case interactor responsible for handling the business logic associated with
     * configuring user profiles.
     */
    final ConfigProfileIB configProfileUseCaseInteractor;

    /**
     * Constructor for the ConfigProfileController class.
     *
     * @param configProfileIB The use case interactor associated with this controller.
     */
    public ConfigProfileController(ConfigProfileIB configProfileIB) {
        this.configProfileUseCaseInteractor = configProfileIB;
    }

    /**
     * Executes the user profile configuration feature.
     *
     * This method constructs an instance of ConfigProfileInputData with the provided parameters
     * and delegates the execution of the user profile configuration feature to the associated
     * use case interactor.
     *
     * @param username The username of the user for whom the profile is being configured.
     * @param address  The new address to be set in the user's profile.
     * @param bio      The new biography to be set in the user's profile.
     * @param size     The new size pref information to be set in the user's profile.
     * @param sex      The new gender pref information to be set in the user's profile.
     */
    public void execute(String username, String address, String bio, String size, String sex) {
        ConfigProfileIPData configProfileIPData = new ConfigProfileIPData(username, address, bio, size, sex);
        configProfileUseCaseInteractor.execute(configProfileIPData);
    }
}