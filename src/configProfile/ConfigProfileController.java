package configProfile;

import usecase.ConfigProfile.ConfigProfileInputData;
import usecase.ConfigProfile.ConfigProfileInputBoundary;
import usecase.ConfigProfile.ConfigProfileInputData;

public class ConfigProfileController {
    final ConfigProfileInputBoundary configProfileUseCaseInteractor;
    public ConfigProfileController(ConfigProfileInputBoundary configProfileUseCaseInteractor) {
        this.configProfileUseCaseInteractor = configProfileUseCaseInteractor;
    }

    public void execute(String username, String address, String bio, String size, String sex) {
        System.out.println("CONTROLLER executed");
        ConfigProfileInputData configProfileInputData = new ConfigProfileInputData(username, address, bio, size, sex);

        configProfileUseCaseInteractor.execute(configProfileInputData);
    }
}
