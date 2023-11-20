package ViewModel;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {
    String vmName;
    public ViewModel(String name){
        this.vmName = name;
    }
    public String getViewName(){
        return vmName;
    }
    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
