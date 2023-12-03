package favPetPage.browsePet;

/**
 * A concrete implemenetatoin of {@link BrowseOB}
 * <p>
 * An implementation of a browsePet usecase interactor that redirects a user who does not have any
 * favorite pet to the browse page
 */
public class BrowseUCI implements BrowseIB {

    private final BrowseOB presenter;

    /**
     * Construct a new usecase interactor
     *
     * @param browsePetOutPutBoundary a presenter implementing {@link BrowseOB} for the browsePet usecase
     *                                that is called by the interactor
     *                                to finish usecase
     */
    public BrowseUCI(BrowseOB browsePetOutPutBoundary) {
        this.presenter = browsePetOutPutBoundary;
    }

    /**
     * Redirect to the main page - browse page
     */
    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
