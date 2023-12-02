package usecase.changeMyPetProfilePublicStatus;

import entity.petProfile.PetProfile;

/**
 * The {@code UCInteractor} class represents the use case interactor responsible for handling
 * the logic related to changing the public status of a pet profile.
 * Implements the {@code InputBound} interface.
 *
 */
public class UCInteractor implements InputBound {

    // Constants for error messages and success indicator
    private static final String NO_NAME_ERR = "No name error";
    private static final String NO_AGE_ERR = "No age error";
    private static final String NO_SEX_ERR = "No sex error";
    private static final String NO_SIZE_ERR = "No size error";
    private static final String SUCCESS = "Success";

    // Presenter and Data Access objects
    private final OutputBound changeProfileStatusPresenter;
    private final DataAccessInterface changeProfileStatusDataAccessObject;

    /**
     * Constructs a {@code UCInteractor} with the specified presenter and data access objects.
     *
     * @param presenter The presenter responsible for handling the presentation of outcomes.
     * @param access    The data access object providing access to the underlying data storage.
     */
    public UCInteractor(OutputBound presenter, DataAccessInterface access) {
        this.changeProfileStatusPresenter = presenter;
        this.changeProfileStatusDataAccessObject = access;
    }

    /**
     * Sets the profile as public if all required fields are valid; otherwise, returns an error message.
     *
     * @param profile The pet profile to be set as public.
     * @return A success message if the profile is set as public, or an error message if validation fails.
     */
    private String setProfilePublic(PetProfile profile) {
        if (profile.getName().isEmpty()) {
            return NO_NAME_ERR;
        } else if (profile.getAge() <= 0) {
            return NO_AGE_ERR;
        } else if (profile.getSex().isEmpty()) {
            return NO_SEX_ERR;
        } else if (profile.getSize().isEmpty()) {
            return NO_SIZE_ERR;
        } else {
            profile.setProfilePublic();
            return SUCCESS;
        }
    }

    /**
     * Executes the use case based on the provided input data.
     *
     * @param data The input data containing the pet profile and the desired public status.
     */
    @Override
    public void execute(PublicStatusInputData data) {
        PetProfile pf = data.getPf();
        String outcome;

        if (data.getStatus()) {
            outcome = setProfilePublic(pf);
            if (outcome.equals(SUCCESS)) {
                changeProfileStatusPresenter.prepareMakePublicSuccessView();
            } else {
                changeProfileStatusPresenter.prepareMakePublicFailView(outcome);
            }
        } else {
            pf.setProfilePrivate();
            changeProfileStatusPresenter.prepareMakePrivateSuccessView();
        }
    }
}