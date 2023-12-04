package myPets.innerViewModels;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class OnePetProfileDisplayViewModel extends ViewModel {
    public final String X_PATH = "/myPetPage/delete red x.png";
    public OnePetProfileDisplayViewModel() {
        super("one pet profile");
    }


    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
