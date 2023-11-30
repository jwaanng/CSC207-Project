package favPetPage.browsePet;

public class BrowseUCI implements BrowseIB {

    private final BrowseOB presenter;
    public BrowseUCI(BrowseOB presenter){
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
