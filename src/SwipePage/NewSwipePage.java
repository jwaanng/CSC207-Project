package SwipePage;
import entity.PetProfiles.DogProfile;
import entity.PetProfiles.DogProfileBuilder;
import view.ConfigProfileView;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import java.net.URL;
import javax.imageio.ImageIO;


public class NewSwipePage extends JFrame {
    private JLabel nameLabel, sizeLabel, photosLabel;
    private JButton likeButton, dislikeButton;
    private SwipePageController controller;

    public NewSwipePage(SwipePageController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Profile panel
        JPanel profilePanel = new JPanel(new GridLayout(3, 1));
        nameLabel = new JLabel();
        sizeLabel = new JLabel();
        photosLabel = new JLabel();
        profilePanel.add(nameLabel);
        profilePanel.add(sizeLabel);
        profilePanel.add(photosLabel);
        add(profilePanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        likeButton = new JButton("Like");
        dislikeButton = new JButton("Dislike");
        buttonPanel.add(likeButton);
        buttonPanel.add(dislikeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        likeButton.addActionListener(e -> controller.onLike());
        dislikeButton.addActionListener(e -> controller.onDislike());

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        controller.loadNextProfile();
    }

    public void updateProfile(SwipePageViewModel viewModel) {
        nameLabel.setText(viewModel.getDisplayName());
        sizeLabel.setText(viewModel.getDisplaySize());
        photosLabel.setText(viewModel.getDisplayPhotos());
    }

    public static void main(String[] args) {
        // Sample PetProfiles delete later.
        List<DogProfile> profiles = new ArrayList<>();
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
        JasonDogRosy.setPetPhotoLink("https://imgur.com/a/wJUKlHV");
        SallyDogDawson.setPetPhotoLink("https://imgur.com/a/0LAsMJC");
        DavidDogRandy.setPetPhotoLink("https://imgur.com/a/ead0cdP");
        GregDogAlex.setPetPhotoLink("https://imgur.com/a/gdqcnmc");
        MirandaDogNemo.setPetPhotoLink("https://imgur.com/a/piu3f6E");
        JasonDogRosy.setAge(2);
        SallyDogDawson.setAge(3);
        DavidDogRandy.setAge(4);
        GregDogAlex.setAge(5);
        MirandaDogNemo.setAge(6);


        ProfileSwipingInteractor interactor = new ProfileSwipingInteractor(profiles);
        PetProfilePresenter presenter = new PetProfilePresenter();
        NewSwipePage view = new NewSwipePage();

        SwipePageController controller = new SwipePageController(interactor, presenter, view);
        view.controller(controller);
        view.setVisible(true);


    }
}