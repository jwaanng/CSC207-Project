package myProfilePage.changeProfile;

import dataAccessObject.ProfilePictureDataAccessInterface;

public class ChangeProfileUCI implements ChangeProfileIB {
    private final ProfilePictureDataAccessInterface daoPic;
    private final ChangeProfileOB presenter;


    public ChangeProfileUCI(ProfilePictureDataAccessInterface daoPic, ChangeProfileOB presenter) {
        this.daoPic = daoPic;
        this.presenter = presenter;
    }

    @Override
    public void execute(ChangeProfileIPData data ) {

        if (data.photofile.toString().endsWith(".png")){
            System.out.println(data.username);
            System.out.println(data.photofile);
            daoPic.uploadUserProfile(data.username, data.photofile);
            presenter.prepareSuccessView(daoPic.retrieveUserProfile(data.username));
        }
        else presenter.prepareFailView("System error, file is not of type png");
    }
}
