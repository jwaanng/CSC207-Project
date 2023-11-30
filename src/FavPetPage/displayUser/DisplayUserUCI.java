package favPetPage.displayUser;

public class DisplayUserUCI implements DisplayUserIB{
    private final DisplayUserOB presenter;

    public DisplayUserUCI(DisplayUserOB displayUserPresenter) {
        this.presenter = displayUserPresenter;
    }

    @Override
    public void execute(String username, String profilePhotoUrl) {
    }


}
