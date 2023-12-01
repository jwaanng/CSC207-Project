package favPetPage.viewThisPetProfile;

/**
 * This interface specifies required methods for a viewThisPetProfile usecase presenter
 */
public interface ViewThisOB {
    void prepareSuccessView(ViewThisOPData outputData);

    void prepareFailView(ViewThisOPData outputData);
}
