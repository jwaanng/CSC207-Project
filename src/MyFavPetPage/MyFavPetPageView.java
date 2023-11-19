package MyFavPetPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFavPetPagePanel extends JPanel implements Ac{
    public MyFavPetPagePanel(){
        setLayout(new BorderLayout());
        /*======================================================================================*/
        //TopBox
        JPanel topPanel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0; //only one row of grid
        topPanel.setLayout(new GridBagLayout());
        //leftBox of topBox
        JPanel leftBox = new JPanel();
        leftBox.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //gray color border
        //leftBox + gbc settings
        gbc.gridx = 0; //box in first row
        gbc.weightx = 0.7; //occupy 70% of the topBox space
        topPanel.add(leftBox,gbc);
        //rightBox of topBox
        JPanel rightBox = new JPanel();
        rightBox.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //gray color border
        //rightBox + gbc settings
        gbc.gridx = 0;  //box in first row
        gbc.weightx = 0.3; //occupy 30% of the topBox space
        topPanel.add(rightBox, gbc);
        add(topPanel, BorderLayout.NORTH); //add the topBox to the MyPetPagePanel
        /*======================================================================================*/
        //MiddleBox where favorite profile are displayed and user can scroll;
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(middlePanel); //add ScrollPane to the middle box
        add(middlePanel, BorderLayout.CENTER); //add the middleSection to the MyGavPetPage
        /*======================================================================================*/
        //ButtomBox where currently 4 pages redirect icon are added, with MyPetPage being the current one
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new GridLayout(1,5)); // 5 equal size box in the buttom


        //All panels and buttons for buttom page
        //Search page Panel of BottomBox;
        JPanel searchPanel = new JPanel();
        ImageIcon searchIcon = new ImageIcon(getClass().getResource(
                "/MyFavPetPage/BottomPageRedirectingIcons/search.png")); // icon to the button
        JButton search = new JButton(searchIcon);
        searchPanel.add(search);

        //Scroll page Panel of ButtomBox
        JPanel scrollPanel = new JPanel();
        ImageIcon scrollIcon = new ImageIcon(getClass().getResource(
                "/MyFavPetPage/BottomPageRedirectingIcons/scroll.png"));
        JButton scroll = new JButton(scrollIcon);
        scrollPanel.add(scroll);

        //FavPet page Panel of ButtomBox
        //TODO add something to distinguish this panel from others since this is the current page in application,
        //TODO no button will be associated so button will be temporaily set not visible
        JPanel favPanel = new JPanel();
        ImageIcon fIcon = new ImageIcon(getClass().getResource(
                "/MyFavPetPage/ButtomPageRedirectionIcons/fav.png"));
        JButton fav = new JButton(fIcon);
        fav.setVisible(false);


        //JPanel myPets Panel of ButtomBox
        JPanel myPetsPanel = new JPanel();
        ImageIcon myPetIcon = new ImageIcon(getClass().getResource(
                "/MyFavPetPage/ButtomPageRedirectionIcons/myPet.png"));
        JButton myPet = new JButton(myPetIcon);
        myPetsPanel.add(myPet);

        //Jpanel myProfile Panel of ButtomBox
        JPanel myProfilePanel = new JPanel();
        ImageIcon myProfileIcon = new ImageIcon(getClass().getResource(
                "/MyFavPetPage/ButtomPageRedirectionIcons/myProfile.png"));
        JButton myProfile = new JButton(myProfileIcon);
        myProfilePanel.add(myProfile);
        ActionListener buttomPageListener = new ActionListener() { // shared actionListener in buttom page
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(search)) {
                    //TODO do something, call viewmodel, set searchpage as active viewmodel via manager
                    ;
                }
                else if (e.getSource().equals(scroll)){
                    //TODO do something, call viewmodel, set scrollpage as active viewmodel via manager
                    ;
                }
                else if (e.getSource().equals(myPet)){
                    //TODO do something, call viewmodel, set mypetpage as active viewmodel via manager
                    ;
                }
                else if (e.getSource().equals(myProfile)){
                    //TODO do something, call viewmodel, setmyprofilepage as active viewmodel via manager
                }

            }
        };
        //addActionlistner to all buttons
        search.addActionListener(buttomPageListener);
        scroll.addActionListener(buttomPageListener);
        myPet.addActionListener(buttomPageListener);
        myProfile.addActionListener(buttomPageListener);




    }

}
