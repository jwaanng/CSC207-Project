package usecase.changeMyPetProfilePublicStatus;

/**
 * The {@code OutputBound} interface defines methods for preparing views based on the success or failure
 * of making a pet profile public or private.
 */
public interface OutputBound {

    /**
     * Prepares the view for a successful operation of making a pet profile public.
     */
    void prepareMakePublicSuccessView();

    /**
     * Prepares the view for a failed operation of making a pet profile public.
     *
     * @param errorMessage The error message describing the cause of the failure.
     */
    void prepareMakePublicFailView(String errorMessage);

    /**
     * Prepares the view for a successful operation of making a pet profile private.
     */
    void prepareMakePrivateSuccessView();
}