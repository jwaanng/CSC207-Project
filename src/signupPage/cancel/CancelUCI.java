package signupPage.cancel;
/**
 * An implementation of a cancel usecase interactor
 * */
public class CancelUCI implements  CancelIB{
    private final CancelOB presenter;
    /**
     *  Constructs a CancelUCI
     * @param cancelOutputBoundary the cancel usecase presenter that can redirect to the login page
     * */
    public CancelUCI(CancelOB cancelOutputBoundary) {
        this.presenter = cancelOutputBoundary;
    }
    /**
     *  Instructs to redirect to login page
     * */
    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
