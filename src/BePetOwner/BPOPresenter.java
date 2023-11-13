package BePetOwner;

public class BPOPresenter implements BPOOB{
    final BPOViewModel BPOvm;

    public BPOPresenter(BPOViewModel BPOvm) {
        this.BPOvm = BPOvm;
    }
    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
