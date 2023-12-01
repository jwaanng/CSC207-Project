package favPetPage.innerviewmodels;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

/**
 * This class stores all information retrievable by the screen to define what a favorite pet profile should display
 * in the user's list
 */
public class OnePetProfileDisplayViewModel extends ViewModel {
    //this is just a placeholder vieModel that contains info about how each petProfile will be displayed
    public final String HEART_PATH = "/favPetPage/like.png";

    /**
     * Construct a new OnePetProfileDisplayViewModel with preassigned view name
     */
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
