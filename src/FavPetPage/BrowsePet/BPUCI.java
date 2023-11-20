package FavPetPage.BrowsePet;

public class BPUCI implements BPIB {

    private final BPOB presenter;
    public BPUCI(BPOB presenter){
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
