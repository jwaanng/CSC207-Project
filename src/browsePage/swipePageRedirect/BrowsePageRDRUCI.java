package browsePage.swipePageRedirect;

public class BrowsePageRDRUCI {

    private final BrowsePageRDRPresenter presenter;

    public BrowsePageRDRUCI(BrowsePageRDRPresenter swipePageRDRPresenter) {
        presenter = swipePageRDRPresenter;
    }

    public void execute() {
        presenter.prepareSuccessView();
    }
}
