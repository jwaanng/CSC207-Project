package myPets.createNewDog;

import viewModel.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateViewModel extends ViewModel {
    public final String propertyName = "state";
    public final int PROFILE_DISPLAY_IN_ONE_ROW = 2;
    public final int SIZE_OF_ONE_PET_PROFILE_IN_PIXEL = 300;
    private CreateState state = new CreateState();
    private PropertyChangeSupport support  = new PropertyChangeSupport(this);

    public static final String TITLE_LABEL = "Create View";
    public static final String PET_NAME_LABEL = "Enter Pet Name";
    public static final String BREED_LABEL = "Enter Pet Breed";
    public static final String VACCINATED_LABEL = "Is Your Pet Vaccinated?";
    public static final String NEUTERED_LABEL = "Is Your Pet Neutered?";
    public static final String AGE_LABEL = "How Old Is Your Pet?";
    public static final String SEX_LABEL = "What Is Your Pet's Sex?";


    public static final String APPLY_BUTTON_LABEL = "Apply";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public CreateViewModel() {
        super("create");
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange(propertyName, null, state);
//        setState(new CreateState()); //refresh
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CreateState getState() {
        return state;
    }

    public void setState(CreateState state) {
        this.state = state;
    }
}
