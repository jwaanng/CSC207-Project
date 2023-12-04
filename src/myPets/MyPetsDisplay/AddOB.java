package myPets.MyPetsDisplay;

/**
 * This interface specifies required methods for an addAFavPet usecase presenter
 */
public interface AddOB {
    void prepareFailView(AddOPData outputData);

    void prepareSucessView(AddOPData outputData);
}
