package myPets.createNewDog;

import java.io.File;

public class CreateController {
    final CreateIB createUCI;
    String username = "Bobby";
    public CreateController(CreateIB createUCI) {
        this.createUCI = createUCI;
    }

    public void execute(String name, String breed, boolean vaccinated, boolean neuter, int age, String sex, String size, File picture) {
        CreateIPData createInputData = new CreateIPData(name, breed, vaccinated, neuter, age, sex, size, picture);

        createUCI.execute(username, createInputData);
    }
}
