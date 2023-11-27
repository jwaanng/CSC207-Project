package favPetPage;
import favPetPage.innerviewmodels.DisplayUserModel;
import favPetPage.innerviewmodels.FavPetDisplayViewModel;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import viewModel.PageRedirectViewModel;
import viewModel.ViewModel;

import java.beans.PropertyChangeListener;

public class MyFavPetPageViewModel extends ViewModel {


    private final FavPetDisplayViewModel petDisplay = new FavPetDisplayViewModel(); //this is a viewmodel corresponding
    // to the inner scroll pane display of pet profiles
    private final PageRedirectViewModel redirect = new PageRedirectViewModel();
    private final DisplayUserModel userinfo = new DisplayUserModel();

    private final NoFavPetDisplayViewModel noPetDisplay = new NoFavPetDisplayViewModel();
    public MyFavPetPageViewModel() {
        super("fav pet");

    }


    public FavPetDisplayViewModel getFavPetDisplayViewModel(){
        return petDisplay;
    }
    public  PageRedirectViewModel getPageRedirectViewModel(){
        return redirect;
    }
    public DisplayUserModel getDisplayUserModel(){
        return userinfo;
    }
    public NoFavPetDisplayViewModel getNoPetDisplayViewModel(){
        return noPetDisplay;
    }
    public void firePropertyChanged() {

    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
    }
}
