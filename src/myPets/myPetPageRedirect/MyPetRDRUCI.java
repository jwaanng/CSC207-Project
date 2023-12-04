package myPets.myPetPageRedirect;

public class MyPetRDRUCI implements MyPetRDRIB {
    private final MyPetRDROB presenter;

    public MyPetRDRUCI(MyPetRDROB redirectPresenter) {
        this.presenter =  redirectPresenter;
    }

    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
