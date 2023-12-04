package myPets.innerViews;

import myPets.InnerViewModelManager;
import myPets.createNewDog.CreateController;
import myPets.createNewDog.CreateState;
import myPets.createNewDog.CreateViewModel;
import myPets.myPetDisplayRedirect.MyPetRedirectController;
import myPets.myPetsRedirect.MyRedirectController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;


public class CreatePetView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = CreateViewModel.TITLE_LABEL;
    private JPanel createPetPanel;
    private JTextField petName = new JTextField(20);
    private JTextField breed = new JTextField(20);
    private JTextField age = new JTextField(20);
    private JRadioButton vacRadioButton;
    private JRadioButton notVacRadioButton;
    private JRadioButton neutRadioButton;
    private JRadioButton notNeutRadioButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton applyButton;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private ButtonGroup sizeGroup;
    private ButtonGroup vacGroup;
    private ButtonGroup neutGroup;
    private ButtonGroup sexGroup;
    private JButton selectImage;

    CreateViewModel createViewModel;
    CreateController createController;
    MyRedirectController redirectController;
    InnerViewModelManager innerViewModelManager;
    MyPetRedirectController myPetRedirectController;

    public CreatePetView(InnerViewModelManager innerViewModelManager, CreateViewModel createViewModel, CreateController createController, MyPetRedirectController myPetRedirectController) {
        this.createViewModel = createViewModel;
        this.createController = createController;
        this.redirectController = redirectController;
        this.innerViewModelManager = innerViewModelManager;
        createViewModel.addPropertyChangeListener(this);
        this.myPetRedirectController = myPetRedirectController;

        // Radio button group for vaccinations
        vacGroup = new ButtonGroup();
        vacRadioButton = new JRadioButton("Vaccinated");
        notVacRadioButton = new JRadioButton("Not Vaccinated");
        vacGroup.add(vacRadioButton);
        vacGroup.add(notVacRadioButton);

        // Radio button group for neutered
        neutGroup = new ButtonGroup();
        neutRadioButton = new JRadioButton("Neutered");
        notNeutRadioButton = new JRadioButton("Not Neutered");
        neutGroup.add(neutRadioButton);
        neutGroup.add(notNeutRadioButton);

        // Radio button group for sex
        sexGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        sexGroup.add(maleRadioButton);
        sexGroup.add(femaleRadioButton);

        //Radio Button Group for Size
        sizeGroup = new ButtonGroup();
        smallRadioButton = new JRadioButton("Small");
        mediumRadioButton = new JRadioButton("Medium");
        largeRadioButton = new JRadioButton("Large");

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(CreateViewModel.PET_NAME_LABEL), petName);
        LabelTextPanel breedInfo = new LabelTextPanel(
                new JLabel(CreateViewModel.BREED_LABEL), breed);
        LabelTextPanel ageInfo = new LabelTextPanel(
                new JLabel(CreateViewModel.AGE_LABEL), age);

        ButtonTextPanel vacInfo = new ButtonTextPanel(new JLabel("Vaccinated"), vacGroup);
        ButtonTextPanel neutInfo = new ButtonTextPanel(new JLabel("Neutered"), neutGroup);
        ButtonTextPanel sexInfo = new ButtonTextPanel(new JLabel("Sex"), sexGroup);
        ButtonTextPanel sizeInfo = new ButtonTextPanel(new JLabel("Size"), sizeGroup);

        JLabel selectImageLabel = new JLabel("Choose your image");
        selectImage = new JButton("select");

        applyButton = new JButton("apply");

        JPanel buttons = new JPanel();
        buttons.add(vacRadioButton);
        buttons.add(notVacRadioButton);
        buttons.add(neutRadioButton);
        buttons.add(notNeutRadioButton);
        buttons.add(maleRadioButton);
        buttons.add(femaleRadioButton);
        buttons.add(applyButton);
        buttons.add(selectImage);



        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(applyButton)) {
                    CreateState currentState = createViewModel.getState();

                    createController.execute(currentState.getName(),
                            currentState.getBreed(),
                            currentState.isVaccinated(),
                            currentState.isNeutered(),
                            currentState.getAge(),
                            currentState.getSex(),
                            currentState.getSize(),
                            currentState.getImage()
                    );

                    myPetRedirectController.execute();
                    createViewModel.setState(new CreateState());

                }
            }
        });

        selectImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(selectImage)) {
                    JFileChooser chooser = new JFileChooser();
                    //Types of images allowed
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
                            "Select PNG",  "png");
                    chooser.setFileFilter(filter);


                    int returnVal = chooser.showOpenDialog(null);
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                        System.out.println("You chose to open this file: " +
                                chooser.getSelectedFile().getName());
                        File file = chooser.getSelectedFile();
                        String path = file.getPath();
//                       Image image = null;
//                        try {
//                            image = ImageIO.read(file);
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
                        createViewModel.getState().setImageFile(file);

                    }

                }
            }
        });

        petName.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateState currentState = createViewModel.getState();
                        String text = petName.getText() + e.getKeyChar();
                        currentState.setName(text);
                        createViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
        breed.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateState currentState = createViewModel.getState();
                        String text = breed.getText() + e.getKeyChar();
                        currentState.setBreed(text);
                        createViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        age.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateState currentState = createViewModel.getState();
                        String text = age.getText() + e.getKeyChar();
                        if(isInt(text)) {
                            currentState.setAge(Integer.parseInt(text));
                        }else{
                            //TODO add error
                            JDialog onlyNums = new JDialog();
                            System.out.println("enter only numbers!");
                        }
                        createViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //this.add(title);
        this.add(nameInfo);
        this.add(breedInfo);
        this.add(ageInfo);
        this.add(vacInfo);
        this.add(neutInfo);
        this.add(sexInfo);
        this.add(sizeInfo);
        this.add(selectImageLabel);
        this.add(buttons);



//        setTitle("Create Your Pet Profile!");
//        setContentPane(createPetPanel);
//        setMinimumSize(new Dimension(1000, 700));
//        setModal(true);
//        setLocationRelativeTo(parent);
//        setVisible(true);
//
//        applyButton.addActionListener(new ActionListener() { // Action listener for clicking 'confirm'
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                createPet();
//            }
//        });
//
//        private void createPet(){
//
//            String name = petName;
//            String breed;
//            boolean vaccinated;
//            boolean neutered;
//            int age;
//            char sex;
//        }
//
//    }



    }
    private boolean isInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "apply");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateState state = (CreateState) evt.getNewValue();
    }
}
