package favPetPage.innerviews;

import favPetPage.innerviewmodels.OnePetProfileDisplayViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;

/**
 * What user see for one pet profile
 */
public class OnePetProfile extends JPanel {
    private OnePetProfileDisplayViewModel vm = new OnePetProfileDisplayViewModel();

    private final int width;
    private final int height;
    private final int petId;
    private final JLabel petName;
    private final JButton unlike;
    private final JButton petPhoto;
    private final ActionListener view;
    private final ActionListener delete;

    /**
     * Construct a new OnePetProfile
     *
     * @param petId                      the id of pet profile
     * @param name                       the name of the pet
     * @param photo                      the image of the pet
     * @param deleteCommonActionListener activate the DeleteController associate to this action listener when user
     *                                   unlike this pet profile
     * @param viewProfileActionListener  activate the ViewThisController associate to this action listener when user
     *                                   clicks on the pet profile picture to view the profile
     * @param imagewidth                 the width of the image of the pet
     */
    public OnePetProfile(int petId, String name, Image photo, ActionListener deleteCommonActionListener,
                         ActionListener viewProfileActionListener, int imagewidth) {
        //TODO finalize error situation to not throw runtime error
        //TODO customize heart image size, border,....etc

        delete = deleteCommonActionListener;
        view = viewProfileActionListener;
        this.petId = petId;
        width = imagewidth;
        height = (int) Math.round(width * 1.25);
        //actual panel's height
        //want to leave 25% to put the name and like button
        //image height will also be the image's width, so it is squared
        setSize(new Dimension(width, height));
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY);
        setBorder(new LineBorder(Color.black));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        //First row
        petName = new JLabel();
        unlike = new JButton();
        //Second row
        this.petPhoto = new JButton();
        //Not visible button to photo,

        //customize
        updateName(name);
        updatePhoto(photo);

        //Size of the unlikeButton
        Dimension buttonDim = new Dimension((int) Math.floor(width * 0.25), height - width);
        unlike.setSize(buttonDim);
        //flooring, always leaves extraspace than having overlapped space.
        ImageIcon heart = new ImageIcon(Objects.requireNonNull(getClass().getResource(vm.HEART_PATH)));
        Image img = heart.getImage().getScaledInstance(unlike.getWidth(), unlike.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon resizedheart = new ImageIcon(img);
        unlike.setIcon(resizedheart);
        unlike.addActionListener(delete);
        unlike.setActionCommand(String.valueOf(petId));// This is how the outside view will identify which profile

        unlike.setBorder(new LineBorder(Color.GRAY, 1));
        petPhoto.setBorder(new LineBorder(Color.GRAY, 1));
        petName.setBorder(new LineBorder(Color.GRAY, 1));
        //Customize grid

        // Does not take up much vertical space

        gbc.gridx = 0; // First Column, row
        gbc.gridy = 0; //
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST; //Position to the top left
        gbc.fill = GridBagConstraints.BOTH;
        add(petName, gbc); // add the name

        //customize heart button;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 1; // Next column
        gbc.gridy = 0; // Same row
        gbc.anchor = GridBagConstraints.NORTHEAST;  // Position to the top right (north east)
        gbc.fill = GridBagConstraints.NONE;
        add(unlike, gbc);


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

    /**
     * Update the name of this pet
     *
     * @param petName the name of this pet
     */
    public void updateName(String petName) {
        this.petName.setText(petName);
        //Size of the petNameLabel
        Dimension petNameLabelDim = new Dimension((int) Math.floor(this.width * 0.75), height - this.width);
        this.petName.setSize(petNameLabelDim);
        //adjustsize font
        Font nameFont = new Font("Garamond", Font.BOLD, 12); //we will adjust the
        // font size to take up maximize space
        FontMetrics fontMetrics = this.petName.getFontMetrics(nameFont);
        int textWidth = fontMetrics.stringWidth(this.petName.getText());
        int textHeight = fontMetrics.getHeight();
        double widthRatio = (double) this.petName.getWidth() / textWidth;
        double heightRatio = (double) this.petName.getHeight() / textHeight;
        double adjustingRatio = Math.min(widthRatio, heightRatio); //taking the min ensures that the ratio the
        //adjusted font size will never let the text leaves the box
        Font adjustFont = nameFont.deriveFont((float) adjustingRatio * nameFont.getSize());
        this.petName.setFont(adjustFont);
        this.petName.setOpaque(true);
        this.petName.setBackground(Color.WHITE);
    }

    /**
     * Update the photo of this pet
     *
     * @param photo the image of this pet
     */
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
        petPhoto.addActionListener(view);
        petPhoto.setActionCommand(String.valueOf(petId));


    }

    /**
     * unlike this pet profile
     */
    public void unlike() {
        unlike.setEnabled(false);
    }

    /**
     * refresh the display of an updated pet profile
     */
    public void refresh() {
        revalidate();
        repaint();

    }

}
