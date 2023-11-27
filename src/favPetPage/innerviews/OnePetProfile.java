package favPetPage.innerviews;

import favPetPage.innerviewmodels.OnePetProfileDisplayViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;


public class OnePetProfile extends JPanel {
    public static boolean isValidURL(String url){
        try{
            URL imgUrl = new URL(url);
            return true;
        } catch (MalformedURLException e){
            return false;
        }
    }
    private OnePetProfileDisplayViewModel vm = new OnePetProfileDisplayViewModel();

    public OnePetProfile(int petId, String petname, String petPhotoURL, ActionListener deleteCommonActionlistener,
                         ActionListener viewProfileActionListner,int imagewidth){
        //TODO finalize error situation to not throw runtime error
        //TODO customize heart image size, border,....etc
        try{
            int panelheight =  (int) Math.round(imagewidth * 1.25);
            //actual panel's height
            //want to leave 25% to put the name and like button
            //image height will also be the image's width, so it is squared
            //Toolkit toolkit = Toolkit.getDefaultToolkit();

            setSize(new Dimension(imagewidth, panelheight));
            System.out.println(getWidth());
            System.out.println(getHeight());
            setLayout(new GridBagLayout());
            setBackground(Color.GRAY);
            setBorder(new LineBorder(Color.black));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.NONE;
            //First row
            //JPanel nameLablePanel = new JPanel();
            //nameLablePanel.setBorder(new LineBorder(Color.black));
            JLabel petNameLabel = new JLabel(petname);
            //nameLablePanel.add(petNameLabel);
            JButton unlike = new JButton();
            //Second row
            //JPanel photoPanel = new JPanel();
            JButton petPhoto = new JButton();
            //Not visible button to petPhoto,
            //photoPanel.add(petPhoto)


            //customize
            //Size of the petNameLabel
            Dimension petNameLabelDim = new Dimension((int)Math.floor(imagewidth*0.75),panelheight-imagewidth);
            petNameLabel.setSize(petNameLabelDim);
            //adjustsize font
            Font nameFont = new Font("Garamond", Font.BOLD, 12); //we will adjust the
            // font size to take up maximize space
            FontMetrics fontMetrics = petNameLabel.getFontMetrics(nameFont);
            int textWidth = fontMetrics.stringWidth(petNameLabel.getText());
            int textHeight = fontMetrics.getHeight();
            double widthRatio = (double)  petNameLabel.getWidth()/textWidth;
            double heightRatio = (double) petNameLabel.getHeight()/ textHeight ;
            double adjustingRatio = Math.min(widthRatio,heightRatio); //taking the min ensures that the ratio the
            //adjusted font size will never let the text leaves the box
            Font adjustFont = nameFont.deriveFont((float) adjustingRatio * nameFont.getSize());
            petNameLabel.setFont(adjustFont);
            petNameLabel.setOpaque(true);
            petNameLabel.setBackground(Color.WHITE);



            //Size of the unlikeButton
            Dimension buttonDim = new Dimension( (int)Math.floor(imagewidth*0.25),panelheight-imagewidth);
            unlike.setSize(buttonDim);

            //flooring, always leaves extraspace than having overlapped space.
            ImageIcon heart = new ImageIcon(Objects.requireNonNull(getClass().getResource(vm.HEART_PATH)));
            Image img = heart.getImage().getScaledInstance(unlike.getWidth(), unlike.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon resizedheart = new ImageIcon(img);
            unlike.setIcon(resizedheart);
            unlike.addActionListener(deleteCommonActionlistener);
            unlike.setActionCommand(String.valueOf(petId)) ;// This is how the outside view will identify which profile



            //Size of the petPhoto
            Dimension petPhotoDim = new Dimension(imagewidth,imagewidth);
            petPhoto.setSize(petPhotoDim);
            Image petImage = ImageIO.read(URI.create(petPhotoURL).toURL());
            Image resizedPetImage = petImage.getScaledInstance(petPhoto.getWidth(),petPhoto.getHeight(),Image.SCALE_AREA_AVERAGING);
            ImageIcon petIcon = new ImageIcon(resizedPetImage);
            petPhoto.setIcon(petIcon);
            petPhoto.addActionListener(viewProfileActionListner);
            petPhoto.setActionCommand(String.valueOf(petId));

            //unlike.setBorderPainted(false);

            //to delete since each petId is unique

            unlike.setBorder(new LineBorder(Color.black, 1 ));
            petPhoto.setBorder(new LineBorder(Color.black, 1));
            petNameLabel.setBorder(new LineBorder(Color.black,1 ));





            //Customize grid

            // Does not take up much vertical space

            gbc.gridx = 0; // First Column, row
            gbc.gridy = 0; //
            gbc.weightx = 1;
            gbc.weighty = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST; //Position to the top left
            gbc.fill = GridBagConstraints.BOTH;
            add(petNameLabel, gbc); // add the name
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
        catch (IllegalArgumentException e){
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
