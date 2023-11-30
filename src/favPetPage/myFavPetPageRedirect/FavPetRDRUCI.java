package favPetPage.myFavPetPageRedirect;

public class FavPetRDRUCI implements FavPetRDRIB {
    private final FavPetRDROB presenter;

    public FavPetRDRUCI(FavPetRDROB redirectPresenter) {
        this.presenter =  redirectPresenter;
    }

    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
