package browsePage;

import browsePage.swipe.DynamicSwipePageController;
import browsePage.swipe.PetProfilePresenter;
import browsePage.swipe.ProfileQueueChainer;
import browsePage.swipe.SwipePageViewModel;
import favPetPage.addAFavPet.AddController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class SwipePageView extends JPanel implements PropertyChangeListener {
    private JLabel nameLabel, bioLabel, photosLabel;
    private JButton likeButton, dislikeButton;
    private DynamicSwipePageController swipeController;
    private final PetProfilePresenter presenter;
    private final AddController addController;
    private final BrowsePageViewModel browsePageVM;

    public SwipePageView(PetProfilePresenter petProfilePresenter,
            AddController addController,
            BrowsePageViewModel browsePageViewModel) {
        this.swipeController = swipeController;
        this.addController = addController;
        this.browsePageVM= browsePageViewModel;
        this.presenter =petProfilePresenter;
        browsePageVM.addPropertyChangeListener(this);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Profile panel
        nameLabel = new JLabel();
        bioLabel = new JLabel();
        photosLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        photosLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font labelFont20 = new Font("Helvetica", Font.BOLD, 20);
        Font labelFont40 = new Font("Helvetica", Font.BOLD, 40);
        nameLabel.setFont(labelFont40);
        bioLabel.setFont(labelFont20);

        JPanel profilePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Name label
        gbc.gridy = 0;
        gbc.weighty = 0; // Name label should not stretch vertically
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 0, 0); // Minimal top margin, no margin between name and photo
        profilePanel.add(nameLabel, gbc);

        // Photos label
        gbc.gridy = 1;
        gbc.weighty = 1; // Photo label takes up remaining space
        gbc.fill = GridBagConstraints.BOTH; // Fills the entire cell
        gbc.anchor = GridBagConstraints.CENTER; // Anchor the photo in the center of its space
        gbc.insets = new Insets(0, 0, 0, 0); // No insets for the photo label
        profilePanel.add(photosLabel, gbc);

        // Bio label
        gbc.gridy = 2;
        gbc.weighty = 0.1; // minimal vertical space
        profilePanel.add(bioLabel, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        likeButton = new JButton("Like");
        dislikeButton = new JButton("Dislike");
        buttonPanel.add(likeButton);
        buttonPanel.add(dislikeButton);
        add(profilePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        likeButton.addActionListener(e -> swipeController.onLike());
        dislikeButton.addActionListener(e -> swipeController.onDislike());

    }

    public void updateProfile(SwipePageViewModel viewModel) {
        nameLabel.setText(viewModel.getDisplayName());
        bioLabel.setText(viewModel.getDisplayBio());

        try {
            Image image = viewModel.getDisplayPhoto();

            if (image != null) {
                BufferedImage bufImage = toBufferedImage(image);
                ImageIcon photo = resizeImageToSquare(bufImage, 550);
                photosLabel.setIcon(photo);
            } else {
                throw new IOException("Image could not be loaded.");
            }
        } catch (Exception e) {
            photosLabel.setIcon(null);
            photosLabel.setText("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private ImageIcon resizeImageToSquare(BufferedImage originalImage, int sideLength) {
        // Calculate the scale to resize the image
        double scale = Math.min((double) sideLength / originalImage.getWidth(),
                (double) sideLength / originalImage.getHeight());

        int newWidth = (int) (originalImage.getWidth() * scale);
        int newHeight = (int) (originalImage.getHeight() * scale);

        // Create a new scaled image
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Create a square image with the scaled image at the center
        BufferedImage squareImage = new BufferedImage(sideLength, sideLength, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = squareImage.createGraphics();

        // Fill with background color or make transparent
        g2.setColor(Color.WHITE); // You can change the background color
        g2.fillRect(0, 0, sideLength, sideLength);

        // Draw the scaled image
        int x = (sideLength - newWidth) / 2;
        int y = (sideLength - newHeight) / 2;
        g2.drawImage(scaledImage, x, y, null);
        g2.dispose();

        return new ImageIcon(squareImage);
    }

    private static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    public static void main(String[] args) {


//        PetProfileDataAccessObject petProfileDataAccessObject = new PetProfileDataAccessObject();
//        CommonProfileDataAccessObject commonProfileDataAccessObject = new CommonProfileDataAccessObject();
//
//        SwipePageView view = new SwipePageView(null);
//
//        FavPetPageViewModel favPetPageViewModel = new FavPetPageViewModel();
//        AddPresenter addPresenter = new AddPresenter(favPetPageViewModel.getAddViewModel());
//
//
//        view.setSwipeController(controller);
//
//        controller.
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getSource() == browsePageVM){
                BrowsePageState state = browsePageVM.getState();
                ProfileQueueChainer interactor = new ProfileQueueChainer(state.getRecommendation());
                swipeController = new DynamicSwipePageController(interactor, presenter,
                        this,
                        state.getUsername(),
                        addController);
                SwingUtilities.invokeLater(() -> this.setVisible(true));
                if (swipeController.loadNextProfile()){
                    JOptionPane.showMessageDialog(this, "No more pet profiles!" +
                            " Please go check out the other features first, maybe somebody will add more pets later");
                }



        }
    }
}