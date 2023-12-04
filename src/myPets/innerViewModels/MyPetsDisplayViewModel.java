package myPets.innerViewModels;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class MyPetsDisplayViewModel extends ViewModel {

    public MyPetsDisplayViewModel(){
        super("my pets display");
    }

    @Override
    public void firePropertyChanged() {
        //support.firePropertyChange("state", null, this.state);
    }


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
