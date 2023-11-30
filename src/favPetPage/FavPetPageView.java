package favPetPage;


import favPetPage.browsePet.BrowseController;
import favPetPage.deleteAFavPet.DeleteController;
import favPetPage.deleteAFavPet.DeleteViewModel;
import favPetPage.innerviews.FavPetRDRView;
import favPetPage.updateAFavPet.UpdateViewModel;
import favPetPage.myFavPetPageRedirect.FavPetRDRController;
import favPetPage.viewThisPetProfile.ViewThisController;
import favPetPage.addAFavPet.AddViewModel;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import favPetPage.innerviews.DisplayUserView;
import favPetPage.innerviews.FavPetDisplayView;
import favPetPage.innerviews.NoFavPetsView;
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
                          DeleteController deletePetController,
                          ViewThisController viewThisPEtController,
                          FavPetRDRController favPetRDRController,
                          BrowseController browsePetController) {
        vm = favPetPageViewModel;
        AddViewModel addVM = vm.getAddViewModel();
        UpdateViewModel updateVM = vm.getUpdateViewModel();
        DeleteViewModel deleteVM = vm.getDeleteFavPetViewModel();
        NoFavPetDisplayViewModel noFavPetVM = vm.getNoPetDisplayViewModel();


        //all the subview components
        FavPetDisplayView petDisplayView = new FavPetDisplayView(
                addVM,
                updateVM,
                deleteVM,
                noFavPetVM,
                deletePetController,
                viewThisPEtController);
        FavPetRDRView redirectView = new FavPetRDRView(vm.getFavPetRDRViewModel(),favPetRDRController);
        NoFavPetsView noPetDisplayView = new NoFavPetsView(noFavPetVM, browsePetController);
        DisplayUserView displayUserView = new DisplayUserView(vm.getDisplayUserModel());


        setLayout(new BorderLayout());
        setOpaque(true);
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
        sidePanel1.setBackground(Color.darkGray);
        sidePanel1.setPreferredSize(new Dimension(100,100));
        JPanel sidePanel2 = new JPanel();
        sidePanel2.setBackground(Color.darkGray);
        sidePanel2.setPreferredSize(new Dimension(100,100));
        add(sidePanel1, BorderLayout.WEST);
        add(sidePanel2, BorderLayout.EAST);
        //Bottom section redirects
        add(redirectView, BorderLayout.SOUTH);

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
