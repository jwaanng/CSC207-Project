package login;

import browsePage.BrowsePageState;
import browsePage.BrowsePageViewModel;
import favPetPage.displayUser.DisplayUserViewModel;
import favPetPage.innerviews.DisplayUserView;
import myPets.MyPetsViewModel;
import myPets.createNewDog.CreateState;
import myPets.myPetDisplayRedirect.MyPetRedirectViewModel;
import myProfilePage.MyProfileView;
import myProfilePage.MyProfileViewModel;
import myProfilePage.changeProfile.ChangeProfileState;
import myProfilePage.changeProfile.ChangeProfileViewModel;
import myProfilePage.configProfile.ConfigProfileState;
import myProfilePage.configProfile.ConfigProfileViewModel;
import favPetPage.FavPetPageViewModel;
import favPetPage.addAFavPet.AddState;
import favPetPage.displayUser.DisplayUserState;
import viewModel.ViewModelManager;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

/**
 * The {@code LoginPresenter} class handles the presentation logic for the login feature, coordinating with
 * various view models and managing the transition between different states in the application.
 * <p>
 * An implementation of {@link  LoginOB}
 */

public class LoginPresenter implements LoginOB {
    private final LoginViewModel lgVM;
    private final FavPetPageViewModel fpVM;
    private final MyProfileViewModel myVM;
    private final BrowsePageViewModel browseVM;
    private final ViewModelManager manager;
    private final MyPetsViewModel petVM;


    /**
     * Constructs an {@code LGPresenter} instance with the specified view models and manager.
     *
     * @param manager             The {@link ViewModelManager} for handling different view models in the application.
     * @param loginViewModel      The {@link LoginViewModel} that stores all related
     *                            information for the login feature.
     * @param favPetPageViewModel The  {@link FavPetPageViewModel} that stores all related
     *                            information for the favorite pet page feature
     * @param myProfileViewModel  The {@link  MyProfileViewModel} that stores all related information for
     *                            my profile pet page feature
     */
    public LoginPresenter(ViewModelManager manager,
                          LoginViewModel loginViewModel,
                          FavPetPageViewModel favPetPageViewModel,
                          MyProfileViewModel myProfileViewModel,
                          BrowsePageViewModel browsePageViewModel,
                          MyPetsViewModel myPetsViewModel
                          ) {
        this.manager = manager;
        this.lgVM = loginViewModel;
        this.fpVM = favPetPageViewModel;
        this.myVM = myProfileViewModel;
        this.browseVM = browsePageViewModel;
        this.petVM = myPetsViewModel;

    }

    /**
     * Prepares the view for a successful login by updating the state of the favorite pet page and
     * triggering necessary property changes in the view models.
     *
     * @param outputData The output data containing information for the success view.
     */
    @Override

    public void prepareSuccessView(LoginOPData outputData) {
        //login will automatically be redirected to the favPetPage

        //Setting up the BrowsePage
        BrowsePageState browsePageState = browseVM.getState();
        browsePageState.setUsername(outputData.username);
        browseVM.setState(browsePageState);

        //Setting up the myProfile Page
        ChangeProfileViewModel changPVM = myVM.getChangeProfileViewModel();
        ChangeProfileState changeProfileState =  changPVM.getState();
        changeProfileState.setImage(outputData.profile);
        changPVM.setState(changeProfileState);
        changPVM.firePropertyChanged();

        ConfigProfileViewModel configPVM = myVM.getConfigProfileViewModel();
        ConfigProfileState configProfileState = configPVM.getState();
        configProfileState.setAddress(outputData.address);
        configProfileState.setPreferredSex(outputData.preferredSex);
        configProfileState.setBio(outputData.bio);
        configProfileState.setUsername(outputData.username);
        configProfileState.setPreferredSize(outputData.preferredSize);
        configPVM.setState(configProfileState);
        configPVM.firePropertyChanged();

        //Setting up the favPetPage
        DisplayUserViewModel dpVM = fpVM.getDisplayUserModel();
        DisplayUserState displayUserState = dpVM.getState();
        displayUserState.setUsername(outputData.username);
        displayUserState.setPhoto(outputData.profile);
        dpVM.setState(displayUserState);
        dpVM.firePropertyChanged();

        AddState state = new AddState(outputData);
        if (state.getKeyEntries().isEmpty()) {
            fpVM.getNoPetDisplayViewModel().firePropertyChanged();
        } else {
            fpVM.getAddViewModel().setState(state);
            fpVM.viewmodelsfirePropertyChanges();

        }
        manager.setActiveViewName(fpVM.getViewName()); // Redirect to the favorite pet page through manager
        manager.firePropertyChange();

        //Setting up the myPetsPage
        MyPetRedirectViewModel redirectVM = petVM.getMyPetRedirectViewModel();
        HashMap<Integer, String> id_Name = outputData.getPetID_to_Name_MyPet();
        HashMap<Integer, File> id_ImageFile = outputData.getPetID_to_Photo_MyPet();
        CreateState createState = petVM.getCreateViewModel().getState();
        if (!id_Name.keySet().isEmpty()) {
            for (int petId : id_Name.keySet()) {
                createState.addPetNameAndPhoto(petId,
                        id_Name.get(petId), id_ImageFile.get(petId));

            }
            petVM.getCreateViewModel().setState(createState);
            redirectVM.firePropertyChanged();
        }
        petVM.getRDRViewModel().setName(outputData.username);
        petVM.getRDRViewModel().firePropertyChanged();

    }

    /**
     * Prepares the view for a failed login by updating the state of the login view and triggering
     * necessary property changes in the view model.
     *
     * @param outputData The output data containing information for the fail view.
     */
    @Override
    public void prepareFailView(LoginOPData outputData) {
        LoginState state = new LoginState();
        state.setError(outputData.error);
        lgVM.setState(state);
        lgVM.firePropertyChanged();
    }
}
