package myPets.createRedirect;

public class CreateRedirectPresenter implements CreateRedirectOB {
    private final CreateRedirectViewModel crvm;

    public CreateRedirectPresenter(CreateRedirectViewModel mrvm) {
        this.crvm = mrvm;
    }

    @Override
    public void prepareSuccessView() {
        crvm.firePropertyChanged();
        System.out.println("createredirectpresenter");
    }
}
