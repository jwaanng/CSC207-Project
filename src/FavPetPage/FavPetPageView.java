package FavPetPage;

import FavPetPage.BrowsePet.BPController;
import FavPetPage.DeleteAFavPet.DFPController;
import FavPetPage.DeleteAFavPet.DeleteFavPetViewModel;
import FavPetPage.updateAFavPet.UpdateViewModel;
import FavPetPage.myFavPetPageRedirect.FavPetRDRController;
import FavPetPage.ViewThisPetProfile.ViewThisController;
import FavPetPage.addAFavPet.AddViewModel;
import FavPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import FavPetPage.innerviews.DisplayUserView;
import FavPetPage.innerviews.FavPetDisplayView;
import FavPetPage.innerviews.NoFavPetsView;
import redirect.CommonRedirectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FavPetPageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final FavPetPageViewModel vm;

    private final JPanel petDisplaySection; //only changing views that are directly related to this JPanel
    private final CardLayout yesNOFavPetLayout;

    public FavPetPageView(FavPetPageViewModel favPetPageViewModel,
                          DFPController deletePetController,
                          ViewThisController viewThisPEtController,
                          FavPetRDRController favPetRDRController,
                          BPController browsePetController) {
        vm = favPetPageViewModel;
        setLayout(new BorderLayout());
        AddViewModel addVM = vm.getAddViewModel();
        UpdateViewModel updateVM = vm.getUpdateViewModel();
        DeleteFavPetViewModel deleteVM = vm.getDeleteFavPetViewModel();
        NoFavPetDisplayViewModel noFavPetVM = vm.getNoPetDisplayViewModel();


        //all the subview components
        FavPetDisplayView petDisplayView = new FavPetDisplayView(
                addVM,
                updateVM,
                deleteVM,
                deletePetController,
                viewThisPEtController);
        CommonRedirectView commonRedirectView = new CommonRedirectView(vm.getFavPetRDRViewModel(),favPetRDRController);
        commonRedirectView.inMyPetPage();
        NoFavPetsView noPetDisplayView = new NoFavPetsView(noFavPetVM, browsePetController);
        DisplayUserView displayUserView = new DisplayUserView(vm.getDisplayUserModel());

        //Top section displays user, app info
        add(displayUserView, BorderLayout.NORTH);
        //Middle section displays pet info
        yesNOFavPetLayout = new CardLayout();
        petDisplaySection = new JPanel(yesNOFavPetLayout);
        JScrollPane scrollPane = new JScrollPane(petDisplayView);
        //customize cardboard/scrollPane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        petDisplaySection.add(scrollPane, addVM.getViewName());
        petDisplaySection.add(noPetDisplayView,noFavPetVM.getViewName());
        yesNOFavPetLayout.show(petDisplaySection,noFavPetVM.getViewName());//default view
        add(petDisplaySection, BorderLayout.CENTER);
        //TODO Debugging
        JPanel sidePanel1 = new JPanel();
        sidePanel1.setBackground(Color.blue);
        JPanel sidePanel2 = new JPanel();
        sidePanel2.setBackground(Color.red);
        add(sidePanel1, BorderLayout.WEST);
        add(sidePanel2, BorderLayout.EAST);
        //Bottom section redirects
        add(commonRedirectView, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == vm.getNoPetDisplayViewModel()){
            yesNOFavPetLayout.show(petDisplaySection,vm.getNoPetDisplayViewModel().getViewName());
        }
        else if (evt.getSource() == vm.getAddViewModel()){
            yesNOFavPetLayout.show(petDisplaySection, vm.getAddViewModel().getViewName());
        }


    }
}
