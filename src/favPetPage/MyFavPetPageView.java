package favPetPage;

import favPetPage.browsePet.BPController;
import favPetPage.deleteAFavPet.DFPController;
import favPetPage.redirect.RDController;
import favPetPage.viewThisPetProfile.VTPController;
import favPetPage.innerviewmodels.FavPetDisplayViewModel;
import favPetPage.innerviewmodels.NoFavPetDisplayViewModel;
import favPetPage.innerviews.DisplayUserView;
import favPetPage.innerviews.FavPetDisplayView;
import favPetPage.innerviews.NoFavPetsView;
import favPetPage.innerviews.RedirectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyFavPetPageView extends JPanel implements ActionListener, PropertyChangeListener {

    private final MyFavPetPageViewModel vm;


    private final JPanel petDisplaySection; //only changing views that are directly related to this JPanel
    private final CardLayout yesNOFavPetLayout;

    public MyFavPetPageView(MyFavPetPageViewModel myFavPetPageViewModel,
                            DFPController deletePetController,
                            VTPController viewThisPEtController,
                            RDController redirectController,
                            BPController browsePetController){
        vm = myFavPetPageViewModel;
        setLayout(new BorderLayout());
        FavPetDisplayViewModel favPetVM = vm.getFavPetDisplayViewModel();
        NoFavPetDisplayViewModel noFavPetVM = vm.getNoPetDisplayViewModel();
        //all the subview components
        FavPetDisplayView petDisplayView = new FavPetDisplayView(favPetVM,
                deletePetController,
                viewThisPEtController);
        RedirectView redirectView = new RedirectView(vm.getPageRedirectViewModel(), redirectController);
        NoFavPetsView noPetDisplayView = new NoFavPetsView(noFavPetVM, browsePetController);
        DisplayUserView displayUserView = new DisplayUserView(vm.getDisplayUserModel());

        //petDisplayViewModel needs to inform this view when to switch the between petDisplayView and noPetDisplayView
        vm.getFavPetDisplayViewModel().addPropertyChangeListener(this);

        //Top section displays user, app info
        add(displayUserView, BorderLayout.NORTH);

        //Middle section displays pet info
        yesNOFavPetLayout = new CardLayout();
        petDisplaySection = new JPanel(yesNOFavPetLayout);
        JScrollPane scrollPane = new JScrollPane(petDisplayView);
        //customize cardboard/scrollPane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        petDisplaySection.add(scrollPane, favPetVM.getViewName());
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
        add(redirectView, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        FavPetDisplayState currState = (FavPetDisplayState) evt.getNewValue();
        if (currState.getKeyEntries().isEmpty()){
            yesNOFavPetLayout.show(petDisplaySection,vm.getNoPetDisplayViewModel().getViewName());
        }
        else
            yesNOFavPetLayout.show(petDisplaySection, vm.getFavPetDisplayViewModel().getViewName());

    }
}
