package myPets.deleteMyPet;

public class DeleteMyPetPresenter implements DeleteMyPetOB {
    private final DeleteMyPetViewModel vm;

    public DeleteMyPetPresenter(DeleteMyPetViewModel deleteMyPetViewModel) {
        this.vm = deleteMyPetViewModel;
    }



    @Override
    public void prepareSuccessView(int deletedId) {
        DeleteMyPetState state = vm.getState();
        state.addId(deletedId);
        vm.firePropertyChanged();
        System.out.println("deletedPresenter");
    }
}
