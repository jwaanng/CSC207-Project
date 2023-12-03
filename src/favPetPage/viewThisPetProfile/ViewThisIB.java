package favPetPage.viewThisPetProfile;

/**
 * This interface specifies required methods for a viewThisPetProfile usecase interactor
 */
public interface ViewThisIB {
    /***
     * an interactor of this usecase can execute to let user view a liked pet profile in detail
     */
    void execute(int petId);
}
