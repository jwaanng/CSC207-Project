package myPets.myPetDisplayRedirect;

public class MyPetRedirectUCI implements MyPetRedirectIB {
    private final MyPetRedirectOB presenter;

    public MyPetRedirectUCI(MyPetRedirectOB redirectPresenter) {
        this.presenter =  redirectPresenter;
    }
    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
