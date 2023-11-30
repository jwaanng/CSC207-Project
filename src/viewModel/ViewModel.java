package viewModel;

import java.beans.PropertyChangeListener;
//this is the absolute highest viewModel hierarchy
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
