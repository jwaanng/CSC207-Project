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

/**
 * What user sees for the favorite pet page
 */

public class FavPetPageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final FavPetPageViewModel vm;

    private final JPanel petDisplaySection; //only changing views that are directly related to this JPanel
    private final CardLayout yesNOFavPetLayout;

    /**
     * Construct a new favorite pet page (FavPEtPageView)
     *
     * @param favPetPageViewModel   the FavPetPageViewModel that stores all the information this view needs to display
     * @param deletePetController   the DeletePetController needed for user to initialize
     *                              the deleteAFavPet usecase(deleting a unliked favorite pet from their liked list)
     * @param viewThisPetController the ViewThisPetController needed for user to initialize the viewThisPetProfile
     *                              usecase(to see the details of a liked pet profile in a separate window)
     * @param browsePetController   the BrowsePetController needed for user to initialize the browsePet usecase(to
     *                              redirect user to the browse page)
     */
    public FavPetPageView(FavPetPageViewModel favPetPageViewModel,
                          DeleteController deletePetController,
                          ViewThisController viewThisPetController,
                          BrowseController browsePetController) {
        vm = favPetPageViewModel;
        AddViewModel addVM = vm.getAddViewModel();
        UpdateViewModel updateVM = vm.getUpdateViewModel();
        DeleteViewModel deleteVM = vm.getDeleteFavPetViewModel();
        NoFavPetDisplayViewModel noFavPetVM = vm.getNoPetDisplayViewModel();
        addVM.addPropertyChangeListener(this);
        noFavPetVM.addPropertyChangeListener(this);

        //all the subview components
        FavPetDisplayView petDisplayView = new FavPetDisplayView(
                addVM,
                updateVM,
                deleteVM,
                noFavPetVM,
                deletePetController,
                viewThisPetController);
        FavPetRDRView redirectView = new FavPetRDRView(vm.getFavPetRDRViewModel());
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
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        petDisplaySection.add(scrollPane, addVM.getViewName());
        petDisplaySection.add(noPetDisplayView, noFavPetVM.getViewName());
        yesNOFavPetLayout.show(petDisplaySection, noFavPetVM.getViewName());//default view
        add(petDisplaySection, BorderLayout.CENTER);
        JPanel sidePanel1 = new JPanel();
        sidePanel1.setBackground(Color.darkGray);
        sidePanel1.setPreferredSize(new Dimension(100, 100));
        JPanel sidePanel2 = new JPanel();
        sidePanel2.setBackground(Color.darkGray);
        sidePanel2.setPreferredSize(new Dimension(100, 100));
        add(sidePanel1, BorderLayout.WEST);
        add(sidePanel2, BorderLayout.EAST);
        //Bottom section redirects
        add(redirectView, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Construct a new favorite pet page (FavPEtPageView)
     * <p>
     * switch between the view where user sees when they have no pet profile liked and the view when
     * user has at least one pet profile liked
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == vm.getNoPetDisplayViewModel()) {
            yesNOFavPetLayout.show(petDisplaySection, vm.getNoPetDisplayViewModel().getViewName());
            petDisplaySection.revalidate();
            petDisplaySection.repaint();
        } else if (evt.getSource() == vm.getAddViewModel()) {
            System.out.println("switch view!");
            yesNOFavPetLayout.show(petDisplaySection, vm.getAddViewModel().getViewName());
            petDisplaySection.revalidate();
            petDisplaySection.repaint();
        }


    }
}
