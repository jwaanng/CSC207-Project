package view;

import viewModel.ViewModelManager;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The {@code ViewManager} class is responsible for managing views using a CardLayout based on
 * property changes in the associated {@code ViewModelManager}.
 *
 * It implements the {@code PropertyChangeListener} interface to listen for changes in the
 * active view model name. When a change occurs, it switches the displayed view using a CardLayout.
 */
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private final ViewModelManager manager;

    /**
     * Constructs a {@code ViewManager} with the specified CardLayout, container JPanel, and ViewModelManager.
     *
     * @param cardLayout The CardLayout to manage multiple views.
     * @param views      The container JPanel that holds multiple views.
     * @param manager    The ViewModelManager associated with this ViewManager.
     */
    public ViewManager(CardLayout cardLayout, JPanel views, ViewModelManager manager) {
        this.cardLayout = cardLayout;
        this.views = views;
        this.manager = manager;
        manager.addPropertyChangeListener(this);
    }

    /**
     * Invoked when a property change event occurs in the associated ViewModelManager.
     * Switches the displayed view based on the new value of the active view model name.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ViewModelManager.propertyName)){
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}
