package myPets.createRedirect;

public class CreateRedirectUCI implements createRedirecIB {
    private final CreateRedirectOB presenter;

    public CreateRedirectUCI(CreateRedirectOB redirectPresenter) {
        this.presenter =  redirectPresenter;
    }
    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
