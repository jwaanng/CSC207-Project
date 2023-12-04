package myPets.myPetsRedirect;

public class MyRedirectUCI implements MyRedirectIB {
    private final MyRedirectOB presenter;

    public MyRedirectUCI(MyRedirectOB redirectPresenter) {
        this.presenter =  redirectPresenter;
    }

    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
