package favPetPage.viewThisPetProfile;
/**
 * An implementation of the ViewThisPetProfile usecase presenter
 * Tasks with redirecting user to a popup window where a detail description of pet profile is displayed
 */
public class ViewThisPresenter implements ViewThisOB {
    /**
     * Send information to be displayed when the usecase failed
     *
     * @param outputData the ViewThisOPData output data that stores this information
     */

    @Override
    public void prepareSuccessView(ViewThisOPData outputData) {

    }
    /**
     * Send information to be displayed when the usecase success
     *
     * @param outputData the ViewThisOPData output data that stores this information
     */
    @Override
    public void prepareFailView(ViewThisOPData outputData) {

    }
}
