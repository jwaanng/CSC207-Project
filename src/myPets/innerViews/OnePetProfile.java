package myPets.innerViews;

import myPets.innerViewModels.OnePetProfileDisplayViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class OnePetProfile extends JPanel{
    private OnePetProfileDisplayViewModel vm = new OnePetProfileDisplayViewModel();

    private final int width;
    private final int height;
    private final int petId;
    private final JLabel name;
    private final JButton deleteButton;
    private final JButton petPhoto;
    private final ActionListener view;
    private final ActionListener delete;
    private final File image;
    public OnePetProfile(int petId, String petName, File image, ActionListener deleteCommonActionlistener,
                         ActionListener viewProfileActionListner, int imagewidth){
        //TODO finalize error situation to not throw runtime error
        //TODO customize heart image size, border,....etc

        this.image = image;
        delete = deleteCommonActionlistener;
        view = viewProfileActionListner;
        this.petId = petId;
        width = imagewidth;
        height = (int) Math.round(width * 1.25);
        //actual panel's height
        //want to leave 25% to put the name and like button
        //image height will also be the image's width, so it is squared

        setSize(new Dimension(width, height));
        System.out.println(getWidth());
        System.out.println(getHeight());
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY);
        setBorder(new LineBorder(Color.black));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;

        //First row
        name = new JLabel();
        deleteButton = new JButton();
        //Second row
        petPhoto = new JButton();
        //Not visible button to petPhoto,

        //create Image
        Image imgTemp = null;
        try{
            imgTemp = ImageIO.read(image);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        //customize
        updateName(petName);
        updatePhoto(imgTemp);

        //Size of the unlikeButton
        Dimension buttonDim = new Dimension((int) Math.floor(width * 0.25), height - width);
        deleteButton.setSize(buttonDim);
        //flooring, always leaves extraspace than having overlapped space.
        ImageIcon xImage = new ImageIcon(Objects.requireNonNull(getClass().getResource(vm.X_PATH)));
        Image img = xImage.getImage().getScaledInstance(deleteButton.getWidth(), deleteButton.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon resizedX = new ImageIcon(img);
        deleteButton.setIcon(resizedX);
        deleteButton.addActionListener(deleteCommonActionlistener);
        deleteButton.setActionCommand(String.valueOf(petId));// This is how the outside view will identify which profile
        //Customize grid

        // Does not take up much vertical space

        gbc.gridx = 0; // First Column, row
        gbc.gridy = 0; //
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST; //Position to the top left
        gbc.fill = GridBagConstraints.BOTH;
        add(name, gbc); // add the name

        //customize heart button;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 1; // Next column
        gbc.gridy = 0; // Same row
        gbc.anchor = GridBagConstraints.NORTHEAST;  // Position to the top right (north east)
        gbc.fill = GridBagConstraints.NONE;
        add(deleteButton, gbc);


        //Second row
        gbc.gridx = 0; // Column
        gbc.gridy = 1; // Next row
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weighty = 1; // Span across all columns
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        // Position to the center
        //gbc.insets = new Insets(10, 10, 10, 10); // Padding
        add(petPhoto, gbc);
    }
    public void updateName(String petName){
        name.setText(petName);
        //Size of the petNameLabel
        Dimension petNameLabelDim = new Dimension((int)Math.floor(this.width *0.75), height- this.width);
        name.setSize(petNameLabelDim);
        //adjustsize font
        Font nameFont = new Font("Garamond", Font.BOLD, 12); //we will adjust the
        // font size to take up maximize space
        FontMetrics fontMetrics = name.getFontMetrics(nameFont);
        int textWidth = fontMetrics.stringWidth(name.getText());
        int textHeight = fontMetrics.getHeight();
        double widthRatio = (double)  name.getWidth()/textWidth;
        double heightRatio = (double) name.getHeight()/ textHeight ;
        double adjustingRatio = Math.min(widthRatio,heightRatio); //taking the min ensures that the ratio the
        //adjusted font size will never let the text leaves the box
        Font adjustFont = nameFont.deriveFont((float) adjustingRatio * nameFont.getSize());
        name.setFont(adjustFont);
        name.setOpaque(true);
        name.setBackground(Color.WHITE);
    }


    public void updatePhoto(Image photo) {
        //Size of the petPhoto
        Dimension petPhotoDim = new Dimension(width, width);
        petPhoto.setSize(petPhotoDim);
        Image resizedPetImage = photo.getScaledInstance(
                petPhoto.getWidth(),
                petPhoto.getHeight(),
                Image.SCALE_AREA_AVERAGING);
        ImageIcon petIcon = new ImageIcon(resizedPetImage);
        petPhoto.setIcon(petIcon);
        //petPhoto.addActionListener(view);
        petPhoto.setActionCommand(String.valueOf(petId));

            //unlike.setBorderPainted(false);

            //to delete since each petId is unique

//            unlike.setBorder(new LineBorder(Color.black, 1));
//            petPhoto.setBorder(new LineBorder(Color.black, 1));
//            name.setBorder(new LineBorder(Color.black, 1));

    }
    public void deletePet(){
        deleteButton.setEnabled(true);
    }
    public void refresh(){
        revalidate();
        repaint();

    }

}
