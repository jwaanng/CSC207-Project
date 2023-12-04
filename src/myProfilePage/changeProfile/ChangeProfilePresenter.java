package myProfilePage.changeProfile;

import java.awt.*;

public class ChangeProfilePresenter implements ChangeProfileOB {
    private final ChangeProfileViewModel vm;

    public ChangeProfilePresenter(ChangeProfileViewModel vm) {
        this.vm = vm;
    }
    @Override
    public void prepareFailView(String error) {

        ChangeProfileState curr = vm.getState();
        curr.setError(error);
        vm.setState(curr);
    }

    @Override
    public void prepareSuccessView(Image newProfile) {
        ChangeProfileState curr = vm.getState();
        curr.setImage(newProfile);
        vm.setState(curr);
        vm.firePropertyChanged();
    }
}
