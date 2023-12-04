package myPets.myPetDisplayRedirect;

public class MyPetRedirectPresenter implements MyPetRedirectOB {
    private final MyPetRedirectViewModel mpvm;

    public MyPetRedirectPresenter(MyPetRedirectViewModel mpvm) {
        this.mpvm = mpvm;
    }

    @Override
    public void prepareSuccessView() {
        mpvm.firePropertyChanged();
    }
}
