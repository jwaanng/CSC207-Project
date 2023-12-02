package view;

import browsePage.BrowsePageViewModel;
import configProfile.ConfigProfileController;
import configProfile.ConfigProfilePresenter;
import configProfile.ConfigProfileState;
import configProfile.ConfigProfileViewModel;
import dataAcessObject.CommonUserDataAccessObject;
import usecase.configProfile.ConfigProfileInteractor;
import viewModel.ViewModelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class MyProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public static final String viewName = "my profile";
    private final JTextField usernameInputfield = new JTextField(15);
    private final JTextField bioInputfield= new JTextField(15);
    private final JTextField addressinputfield = new JTextField(15);
    private JRadioButton smallRadioButton;
    private JRadioButton bigRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton maleRadioButton;
    private JRadioButton bothRadioButton;

    private final ConfigProfileController configProfileController;
    private final ConfigProfileViewModel configProfileViewModel;

    public MyProfileView(ConfigProfileViewModel profileViewModel, ConfigProfileController configProfileController) {
        this.configProfileController = configProfileController;
        this.configProfileViewModel = profileViewModel;
        configProfileViewModel.addPropertyChangeListener(this);

        LabelTextPanel username = new LabelTextPanel(
                new JLabel(ConfigProfileViewModel.USERNAME_LABEL), usernameInputfield );
        LabelTextPanel bio = new LabelTextPanel(
                new JLabel(ConfigProfileViewModel.BIO_LABEL), bioInputfield );
        LabelTextPanel address = new LabelTextPanel(
                new JLabel(ConfigProfileViewModel.ADDRESS_LABEL), addressinputfield);

        smallRadioButton = new JRadioButton("Small");
        mediumRadioButton = new JRadioButton("Medium");
        bigRadioButton = new JRadioButton("Big");

        femaleRadioButton = new JRadioButton("Female");
        maleRadioButton = new JRadioButton("Male");
        bothRadioButton = new JRadioButton("Both");

        JPanel sizeGroup = new JPanel();
        sizeGroup.add(smallRadioButton);
        sizeGroup.add(mediumRadioButton);
        sizeGroup.add(bigRadioButton);

        JPanel sexGroup = new JPanel();
        sexGroup.add(femaleRadioButton);
        sexGroup.add(maleRadioButton);
        sexGroup.add(bothRadioButton);

        ButtonTextPanel size = new ButtonTextPanel(new JLabel(ConfigProfileViewModel.SIZE_LABEL),
                sizeGroup);
        ButtonTextPanel sex = new ButtonTextPanel(new JLabel(ConfigProfileViewModel.SEX_LABEL),
                sexGroup);

        JPanel buttons = new JPanel();
        JButton confirm = new JButton(ConfigProfileViewModel.CONFIRM_BUTTON);

        buttons.add(confirm);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInfo();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(bio);
        this.add(address);
        this.add(size);
        this.add(sex);
        this.add(buttons);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
    private Map<String, Boolean> getSelectedSex() {
        Map<String, Boolean> sexMap = new HashMap<>();

        sexMap.put("female", femaleRadioButton.isSelected());
        sexMap.put("male", maleRadioButton.isSelected());
        sexMap.put("both", bothRadioButton.isSelected());

        return sexMap;
    }
    private Map<String, Boolean> getSelectedGender() {
        Map<String, Boolean> sizeMap = new HashMap<>();

        sizeMap.put("small", smallRadioButton.isSelected());
        sizeMap.put("medium", mediumRadioButton.isSelected());
        sizeMap.put("large", bigRadioButton.isSelected());

        return sizeMap;
    }


    private void saveInfo() {
        String username = usernameInputfield.getText();
        String bio = bioInputfield.getText();
        String address = addressinputfield.getText();
        Map<String, Boolean> sexMap = getSelectedSex();
        Map<String, Boolean> sizeMap = getSelectedGender();

        ConfigProfileState currentState = configProfileViewModel.getState();

        currentState.setUsername(username);
        currentState.setBio(bio);
        currentState.setAddress(address);
        currentState.setSex(sexMap);
        currentState.setSize(sizeMap);

        System.out.println("Configuration: " + currentState.toString());

        smallRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(smallRadioButton.isSelected()) {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setSmall(true);
                            configProfileViewModel.setState(currentState);
                        }
                        else {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setSmall(false);
                            configProfileViewModel.setState(currentState);
                        }
                    }
                }
        );
        mediumRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(mediumRadioButton.isSelected()) {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setMedium(true);
                            configProfileViewModel.setState(currentState);
                        }
                        else {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setMedium(false);
                            configProfileViewModel.setState(currentState);
                        }
                    }
                }
        );
        bigRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(bigRadioButton.isSelected()) {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setLarge(true);
                            configProfileViewModel.setState(currentState);
                        }
                        else {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setLarge(false);
                            configProfileViewModel.setState(currentState);
                        }
                    }
                }
        );
        femaleRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(femaleRadioButton.isSelected()) {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setFemale(true);
                            configProfileViewModel.setState(currentState);
                        }
                        else {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setFemale(false);
                            configProfileViewModel.setState(currentState);
                        }
                    }
                }
        );
        maleRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(maleRadioButton.isSelected()) {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setMale(true);
                            configProfileViewModel.setState(currentState);
                        }
                        else {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setMale(false);
                            configProfileViewModel.setState(currentState);
                        }
                    }
                }
        );
        bothRadioButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(bothRadioButton.isSelected()) {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setBoth(true);
                            configProfileViewModel.setState(currentState);
                        }
                        else {
                            ConfigProfileState currentState = configProfileViewModel.getState();
                            currentState.setBoth(false);
                            configProfileViewModel.setState(currentState);
                        }
                    }
                }
        );

        if (bio.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ENTER ALL INFORMATION", "FAILED", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!femaleRadioButton.isSelected() && !maleRadioButton.isSelected() && !bothRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select the gender.", "Failed", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!smallRadioButton.isSelected() && !mediumRadioButton.isSelected() && !bigRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select the size.", "Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

//        configProfileController.execute(username, bio, address, currentState.getSex().toString(),
//                currentState.getSize().toString());

    }
    public static void main(String[] args) {
        JFrame application = new JFrame("MyProfile");
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewModelManager viewManagerModel = new ViewModelManager();
        new ViewManager(cardLayout, views, viewManagerModel);

        ConfigProfileViewModel configProfileViewModel = new ConfigProfileViewModel();
        ConfigProfilePresenter configProfilePresenter = new ConfigProfilePresenter(configProfileViewModel, new BrowsePageViewModel(), new ViewModelManager());
        ConfigProfileInteractor configProfileInteractor = new ConfigProfileInteractor(new CommonUserDataAccessObject(), configProfilePresenter);

        ConfigProfileController configProfileController = new ConfigProfileController(configProfileInteractor);

        viewManagerModel.setActiveViewName(MyProfileView.viewName);
        viewManagerModel.firePropertyChange();

        MyProfileView configProfileView = new MyProfileView(configProfileViewModel, configProfileController);
        views.add(configProfileView, MyProfileView.viewName);

        application.pack();
        application.setVisible(true);
    }
}
