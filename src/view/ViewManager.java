package view;

import viewModel.ViewModelManager;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private final ViewModelManager manager;

    public ViewManager(CardLayout cardLayout, JPanel views, ViewModelManager manager) {
        this.cardLayout = cardLayout;
        this.views = views;
        this.manager = manager;
        manager.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ViewModelManager.propertyName)){
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}
