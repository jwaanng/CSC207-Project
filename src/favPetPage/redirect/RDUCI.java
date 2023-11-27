package favPetPage.redirect;

public class RDUCI implements RDIB{
    private final RDOB presenter;

    public RDUCI(RDOB redirectPresenter) {
        this.presenter =  redirectPresenter;
    }

    @Override
    public void execute(RDIPData inputData) {
        presenter.prepareSuccessView(new RDOPData(inputData.getViewName()));
    }
}
