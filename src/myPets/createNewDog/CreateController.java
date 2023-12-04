package myPets.createNewDog;

import java.awt.*;
import java.io.File;

public class CreateController {
    final CreateIB createUCI;
    String username = "Rob";
    public CreateController(CreateIB createUCI) {
        this.createUCI = createUCI;
    }

    public void execute(String name, String breed, boolean vaccinated, boolean neuter, int age, String sex, String size, File picture, String temper, String description, String likes) {
        CreateIPData createInputData = new CreateIPData(name, breed, vaccinated, neuter, age, sex, size, picture, temper, description, likes);

        createUCI.execute(username, createInputData);
    }
}
