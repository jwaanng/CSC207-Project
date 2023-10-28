package usecase.ChangeMyPetProfilePublicStatus;

public interface OutputBound {
    void prepareMakePublicSuccessView();
    void prepareMakePublicFailView(String e);
    void prepareMakePrivateSuccessView();
}
