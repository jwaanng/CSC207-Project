package app;

import browsePage.BrowsePageView;
import browsePage.swipePage.PetProfilePresenter;
import browsePage.swipePage.ProfileSwipingInteractor;
import browsePage.swipePage.SwipePageController;
import browsePage.swipePage.SwipePageView;
import dataAccessObject.CommonProfileDataAccessObject;
import dataAccessObject.PetProfileDataAccessObject;
import favPetPage.FavPetPageView;
import favPetPage.FavPetPageViewModel;
import favPetPage.addAFavPet.AddController;
import favPetPage.addAFavPet.AddPresenter;
import favPetPage.addAFavPet.AddUCI;

import javax.swing.*;

public class BrowsePetPageFactory {
//    static public BrowsePageView createBrowsePage(){
//
////        ProfileSwipingInteractor interactor = new ProfileSwipingInteractor(sortedPetProfiles);
////        PetProfilePresenter presenter = new PetProfilePresenter();
////        PetProfileDataAccessObject petProfileDataAccessObject = new PetProfileDataAccessObject();
////        CommonProfileDataAccessObject commonProfileDataAccessObject = new CommonProfileDataAccessObject();
////
////        SwipePageView view = new SwipePageView(null);
////
////        FavPetPageViewModel favPetPageViewModel = new FavPetPageViewModel();
////        AddPresenter addPresenter = new AddPresenter(favPetPageViewModel.getAddViewModel());
////        AddUCI addUCI = new AddUCI(addPresenter, dao, petProfileDataAccessObject, commonProfileDataAccessObject);
////        AddController addController = new AddController(addUCI);
////
////        SwipePageController controller = new SwipePageController(interactor, presenter, view, dao.retrieve("Sean Beans").getUsername(), addController);
////        view.setController(controller);
////        SwingUtilities.invokeLater(() -> view.setVisible(true));
////        controller.loadNextProfile();
//
// }
}
