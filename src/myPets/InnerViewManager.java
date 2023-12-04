package myPets;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InnerViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final MyPetsView myPets;
    private final InnerViewModelManager manager;

    public InnerViewManager(CardLayout cardLayout, MyPetsView myPets, InnerViewModelManager manager) {
        this.cardLayout = cardLayout;
        this.myPets = myPets;
        this.manager = manager;
        manager.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(InnerViewModelManager.propertyName)){
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(myPets, viewModelName);
        }
    }

}

