package myProfilePage.changeProfile;

import dataAccessObject.ProfilePictureDataAccessInterface;
import favPetPage.displayUser.DisplayUserController;

public class ChangeProfileUCI implements ChangeProfileIB {
    private final ProfilePictureDataAccessInterface daoPic;
    private final ChangeProfileOB presenter;
    private final DisplayUserController favPetPageDisplayCtr; //everytime profile updates favPetPage profile must
    // update too


    public ChangeProfileUCI(ProfilePictureDataAccessInterface daoPic, ChangeProfileOB presenter, DisplayUserController displayUserController) {
        this.daoPic = daoPic;
        this.presenter = presenter;
        favPetPageDisplayCtr = displayUserController;
    }

    @Override
    public void execute(ChangeProfileIPData data ) {

        if (data.photofile.toString().endsWith(".png")){
            System.out.println(data.username);
            System.out.println(data.photofile);
            daoPic.uploadUserProfile(data.username, data.photofile);
            presenter.prepareSuccessView(daoPic.retrieveUserProfile(data.username));
            favPetPageDisplayCtr.execute(data.username);

        }
        else presenter.prepareFailView("System error, file is not of type png");
    }
}
