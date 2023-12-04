package myPets.innerViews;

import myPets.MyPetsView;
import myPets.MyPetsViewModel;
import myPets.createNewDog.CreateController;
import myPets.createNewDog.CreateState;
import myPets.createNewDog.CreateViewModel;
import myPets.myPetDisplayRedirect.MyPetRedirectController;
import myPets.myPetPageRedirect.MyPetRDRController;
import myPets.InnerViewModelManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class CreatePetView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = CreateViewModel.TITLE_LABEL;
    private JPanel createPetPanel;
    private JTextField petName = new JTextField(20);
    private JTextField breed = new JTextField(20);
    private JTextField age = new JTextField(20);
    private JTextField temper = new JTextField(200);
    private JTextField description = new JTextField(200);
    private JTextField likes = new JTextField(100);
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
    private JPanel sizeGroup;
    private JPanel vacGroup;
    private JPanel neutGroup;
    private JPanel sexGroup;
    private JButton selectImage;

    CreateViewModel createViewModel;
    CreateController createController;
    MyPetRDRController redirectController;
    InnerViewModelManager innerViewModelManager;
    MyPetRedirectController myPetRedirectController;

    public CreatePetView( InnerViewModelManager innerViewModelManager, CreateViewModel createViewModel, CreateController createController, MyPetRedirectController myPetRedirectController) {
        this.createViewModel = createViewModel;
        this.createController = createController;
        this.redirectController = redirectController;
        this.innerViewModelManager = innerViewModelManager;
        createViewModel.addPropertyChangeListener(this);
        this.myPetRedirectController = myPetRedirectController;

        // Radio button group for vaccinations
        vacGroup = new JPanel();
        vacRadioButton = new JRadioButton("Vaccinated");
        notVacRadioButton = new JRadioButton("Not Vaccinated");
        vacGroup.add(vacRadioButton);
        vacGroup.add(notVacRadioButton);

        // Radio button group for neutered
        neutGroup = new JPanel();
        neutRadioButton = new JRadioButton("Neutered");
        notNeutRadioButton = new JRadioButton("Not Neutered");
        neutGroup.add(neutRadioButton);
        neutGroup.add(notNeutRadioButton);

        // Radio button group for sex
        sexGroup = new JPanel();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        sexGroup.add(maleRadioButton);
        sexGroup.add(femaleRadioButton);

        //Radio Button Group for Size
        sizeGroup = new JPanel();
        smallRadioButton = new JRadioButton("Small");
        mediumRadioButton = new JRadioButton("Medium");
        largeRadioButton = new JRadioButton("Large");
        sizeGroup.add(smallRadioButton);
        sizeGroup.add(mediumRadioButton);
        sizeGroup.add(largeRadioButton);


        JPanel selectImageInfo = new JPanel();
        selectImage = new JButton("select");
        selectImageInfo.add(selectImage);


        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(CreateViewModel.PET_NAME_LABEL), petName);
        LabelTextPanel breedInfo = new LabelTextPanel(
                new JLabel(CreateViewModel.BREED_LABEL), breed);
        LabelTextPanel ageInfo = new LabelTextPanel(
                new JLabel(CreateViewModel.AGE_LABEL), age);
        LabelTextPanel temperInfo = new LabelTextPanel(
                new JLabel("Pet Temper"), temper);
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Pet Description"), description);
        LabelTextPanel likesInfo = new LabelTextPanel(
                new JLabel("Pets likes and dislikes"), likes);

        ButtonTextPanel vacInfo = new ButtonTextPanel(new JLabel("Vaccinated:"), vacGroup);
        ButtonTextPanel neutInfo = new ButtonTextPanel(new JLabel("Neutered:"), neutGroup);
        ButtonTextPanel sexInfo = new ButtonTextPanel(new JLabel("Sex:"), sexGroup);
        ButtonTextPanel sizeInfo = new ButtonTextPanel(new JLabel("Size:"), sizeGroup);

        ButtonTextPanel imageInfo = new ButtonTextPanel(new JLabel("Choose your image"), selectImageInfo);
        applyButton = new JButton("apply");

        JPanel buttons = new JPanel();
//        buttons.add(vacRadioButton);
//        buttons.add(notVacRadioButton);
//        buttons.add(neutRadioButton);
//        buttons.add(notNeutRadioButton);
//        buttons.add(maleRadioButton);
//        buttons.add(femaleRadioButton);
        buttons.add(applyButton);
//        buttons.add(selectImage);

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(applyButton)) {
                    CreateState currentState = createViewModel.getState();

                    createController.execute( currentState.getName(),
                            currentState.getBreed(),
                            currentState.isVaccinated(),
                            currentState.isNeutered(),
                            currentState.getAge(),
                            currentState.getSex(),
                            currentState.getSize(),
                            currentState.getImage(),
                            currentState.getTemper(),
                            currentState.getDescription(),
                            currentState.getLikes()
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
        temper.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateState currentState = createViewModel.getState();
                        String text = temper.getText() + e.getKeyChar();
                        currentState.setTemper(text);
                        createViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
        description.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateState currentState = createViewModel.getState();
                        String text = description.getText() + e.getKeyChar();
                        currentState.setDescription(text);
                        createViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
        likes.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateState currentState = createViewModel.getState();
                        String text = likes.getText() + e.getKeyChar();
                        currentState.setLikes(text);
                        createViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //this.add(title);
        this.add(nameInfo);
        this.add(breedInfo);
        this.add(temperInfo);
        this.add(descriptionInfo);
        this.add(likesInfo);
        this.add(ageInfo);
        this.add(vacInfo);
        this.add(neutInfo);
        this.add(sexInfo);
        this.add(sizeInfo);
        this.add(imageInfo);
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
