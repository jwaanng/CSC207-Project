package SwipePage;
import entity.petProfile.DogProfile;
import entity.petProfile.DogProfileBuilder;
import entity.petProfile.PetProfile;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import javax.imageio.ImageIO;


public class NewSwipePage extends JFrame {
    private JLabel nameLabel, bioLabel, photosLabel;
    private JButton likeButton, dislikeButton;
    private SwipePageController controller;

    public NewSwipePage(SwipePageController controller) {
        this.controller = controller;
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

        likeButton.addActionListener(e -> controller.onLike());
        dislikeButton.addActionListener(e -> controller.onDislike());

        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public void updateProfile(SwipePageViewModel viewModel) {
//        nameLabel.setText(viewModel.getDisplayName());
//        sizeLabel.setText(viewModel.getDisplayBio());
//
//        try {
//            URL url = new URL(viewModel.getDisplayPhotoUrl());
//            ImageIcon photo = new ImageIcon(ImageIO.read(url));
//            photosLabel.setIcon(photo);
//        } catch (Exception e) {
//            photosLabel.setIcon(null);
//            photosLabel.setText("Photo not available");
//            e.printStackTrace();
//        }
//    }

    public void updateProfile(SwipePageViewModel viewModel) {
        nameLabel.setText(viewModel.getDisplayName());
        bioLabel.setText(viewModel.getDisplayBio());

        try {
            URL url = new URL(viewModel.getDisplayPhotoUrl());
            BufferedImage originalImage = ImageIO.read(url);

            if (originalImage != null) {
                ImageIcon photo = resizeImageToSquare(originalImage, 550); // 200x200 square
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

    public static void main(String[] args) {
        // Sample PetProfiles delete later.
        List<PetProfile> profiles = new ArrayList<>();
        DogProfileBuilder JasonBuilder = new DogProfileBuilder("Jason");
        DogProfileBuilder SallyBuilder = new DogProfileBuilder("Sally");
        DogProfileBuilder DavidBuilder = new DogProfileBuilder("David");
        DogProfileBuilder GregBuilder = new DogProfileBuilder("Greg");
        DogProfileBuilder MirandaBuilder = new DogProfileBuilder("Miranda");
        DogProfile JasonDogRosy = JasonBuilder.build();
        DogProfile SallyDogDawson = SallyBuilder.build();
        DogProfile DavidDogRandy = DavidBuilder.build();
        DogProfile GregDogAlex = GregBuilder.build();
        DogProfile MirandaDogNemo = MirandaBuilder.build();
        JasonDogRosy.setName("Rosy");
        SallyDogDawson.setName("Dawson");
        DavidDogRandy.setName("Randy");
        GregDogAlex.setName("Alex");
        MirandaDogNemo.setName("Nemo");
        JasonDogRosy.setSex('F');
        SallyDogDawson.setSex('M');
        DavidDogRandy.setSex('M');
        GregDogAlex.setSex('M');
        MirandaDogNemo.setSex('M');
        JasonDogRosy.setBreed("Shiba Inu");
        SallyDogDawson.setBreed("Literal Wolf");
        DavidDogRandy.setBreed("Husky");
        GregDogAlex.setBreed("Dachshund");
        MirandaDogNemo.setBreed("Dalmatian");
        JasonDogRosy.setPetPhotoLink("https://i.ibb.co/jTXH1Mt/shiba.png");
        SallyDogDawson.setPetPhotoLink("https://i.ibb.co/Mgr786p/wolf.jpg");
        DavidDogRandy.setPetPhotoLink("https://i.ibb.co/6yDwJcJ/husky.png");
        GregDogAlex.setPetPhotoLink("https://i.ibb.co/yPpRMh7/daschund.png");
        MirandaDogNemo.setPetPhotoLink("https://i.ibb.co/BKV8Svz/dalmatian.png");
        JasonDogRosy.setAge(2);
        SallyDogDawson.setAge(3);
        DavidDogRandy.setAge(4);
        GregDogAlex.setAge(5);
        MirandaDogNemo.setAge(6);
        profiles.add(JasonDogRosy);
        profiles.add(SallyDogDawson);
        profiles.add(DavidDogRandy);
        profiles.add(GregDogAlex);
        profiles.add(MirandaDogNemo);

        ProfileSwipingInteractor interactor = new ProfileSwipingInteractor(profiles);
        PetProfilePresenter presenter = new PetProfilePresenter();
        NewSwipePage view = new NewSwipePage(null);

        SwipePageController controller = new SwipePageController(interactor, presenter, view);
        view.setController(controller);

        SwingUtilities.invokeLater(() -> view.setVisible(true));
        controller.loadNextProfile();
    }

    public void setController(SwipePageController controller) {
        this.controller = controller;
    }
}