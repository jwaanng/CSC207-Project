package favPetPage.innerviews;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

/**
 * A displayable detailed pet profile
 */
public class DetailFavPetProfile extends JPanel implements Scrollable {

    private final JLabel name;
    private final JLabel specie;
    private final JLabel age;
    private final JLabel sex;
    private final JLabel size;
    private final JLabel photo;
    private final JTextArea generalDescr;
    private final JTextArea likeDescr;
    private final JTextArea tempDescr;
    private final JLabel ownerName;
    private final JLabel ownerInstagram;

    private final JPanel centerPanel = new JPanel(new GridBagLayout());

    private final GridBagConstraints gbc = new GridBagConstraints();

    /**
     * Construct a new DetailFavPetProfile object
     */
    public DetailFavPetProfile() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        name = new JLabel();
        specie = new JLabel();
        age = new JLabel();
        sex = new JLabel();
        size = new JLabel();
        photo = new JLabel();
        generalDescr = new JTextArea();
        likeDescr = new JTextArea();
        tempDescr = new JTextArea();
        ownerName = new JLabel();
        ownerInstagram = new JLabel();

        //customize name label
        Font nameFont = new Font("Garamond", Font.BOLD | Font.ITALIC, 50);
        name.setFont(nameFont);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        setForeground(Color.DARK_GRAY);
        setBackground(Color.WHITE);
        add(name, BorderLayout.NORTH);
        JPanel sidePanel1 = new JPanel();
        sidePanel1.setBackground(Color.WHITE);
        sidePanel1.setPreferredSize(new Dimension(100, 100));

        //customize space filler in sides
        JPanel sidePanel2 = new JPanel();
        sidePanel2.setBackground(Color.WHITE);
        sidePanel2.setPreferredSize(new Dimension(100, 100));
        add(sidePanel1, BorderLayout.WEST);
        add(sidePanel2, BorderLayout.EAST);
        //customize InnerPanel
        centerPanel.setBackground(Color.WHITE);

        //photo
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        photo.setHorizontalAlignment(JLabel.CENTER);
        photo.setVerticalAlignment(JLabel.NORTH);
        photo.setAlignmentX(Component.CENTER_ALIGNMENT);
        photo.setPreferredSize((new Dimension(700, 500)));
        centerPanel.add(photo, gbc);
        add(centerPanel, BorderLayout.CENTER);

        //owner's name
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Font ownerNameFont = new Font("Arial", Font.ITALIC, 40);
        ownerName.setFont(ownerNameFont);
        ownerName.setHorizontalAlignment(JLabel.LEADING);
        ownerName.setVerticalAlignment(JLabel.TOP);
        ownerName.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerPanel.add(ownerName, gbc);
        add(centerPanel, BorderLayout.CENTER);

        //general description
        generalDescr.setWrapStyleWord(true);
        generalDescr.setLineWrap(true);
        generalDescr.setEditable(false);
        generalDescr.setBackground(null);
        generalDescr.setAlignmentY(Component.TOP_ALIGNMENT);
        generalDescr.setAlignmentX(Component.LEFT_ALIGNMENT);
        Font generalDesrcFont = new Font("Arial", Font.PLAIN, 20);
        generalDescr.setFont(generalDesrcFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 20, 0, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(generalDescr, gbc);

        //basicinfo icon
        JLabel basicinfoIcon = new JLabel();
        try {
            Image infoIcon = ImageIO.read(getClass().getResource("/petBasicinfo.png"));
            basicinfoIcon.setIcon(new ImageIcon(infoIcon.getScaledInstance(70, 70,
                    Image.SCALE_SMOOTH)));

        } catch (IOException e) {
            throw new RuntimeException("basicinfoIcon does not exist in resource folder");
        }

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        centerPanel.add(basicinfoIcon, gbc);

        //basic info label
        JLabel basicinfo = new JLabel("Base information:");
        basicinfo.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        centerPanel.add(basicinfo, gbc);
        Font basicInfoFont = new Font("Arial", Font.BOLD, 20);
        // specie  label
        specie.setFont(basicInfoFont);
        specie.setAlignmentX(LEFT_ALIGNMENT);
        specie.setHorizontalAlignment(JLabel.LEADING);
        gbc.insets = new Insets(0, 70, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(specie, gbc);

        //age label
        age.setFont(basicInfoFont);
        age.setAlignmentX(LEFT_ALIGNMENT);
        age.setHorizontalAlignment(JLabel.LEADING);
        gbc.insets = new Insets(0, 70, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(age, gbc);

        //sex label
        sex.setFont(basicInfoFont);
        sex.setAlignmentX(LEFT_ALIGNMENT);
        sex.setHorizontalAlignment(JLabel.LEADING);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(sex, gbc);

        //size label
        size.setFont(basicInfoFont);
        size.setAlignmentX(LEFT_ALIGNMENT);
        size.setHorizontalAlignment(JLabel.LEADING);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(size, gbc);

        //moreinfo
        JLabel moreInfo = new JLabel("More information");
        moreInfo.setFont(new Font("Arial", Font.BOLD, 30));
        moreInfo.setHorizontalAlignment(JLabel.LEADING);
        moreInfo.setAlignmentX(LEFT_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.fill = GridBagConstraints.BOTH;
        centerPanel.add(moreInfo, gbc);

        //like Descr
        Font likeDescrFont = new Font("Arial", Font.PLAIN, 20);
        likeDescr.setFont(likeDescrFont);
        likeDescr.setWrapStyleWord(true);
        likeDescr.setLineWrap(true);
        likeDescr.setEditable(false);
        likeDescr.setBackground(null);
        likeDescr.setAlignmentY(Component.TOP_ALIGNMENT);
        likeDescr.setAlignmentX(Component.LEFT_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 20, 30, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(likeDescr, gbc);

        //temp descr
        Font tempDescrFont = new Font("Arial", Font.PLAIN, 20);
        tempDescr.setFont(tempDescrFont);
        tempDescr.setWrapStyleWord(true);
        tempDescr.setLineWrap(true);
        tempDescr.setEditable(false);
        tempDescr.setBackground(null);
        tempDescr.setAlignmentY(Component.TOP_ALIGNMENT);
        tempDescr.setAlignmentX(Component.LEFT_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 20, 40, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(tempDescr, gbc);


    }

    /**
     * Set the pet name to be displayed
     *
     * @param name name of the pet
     */
    public void setPetName(String name) {
        this.name.setText(name);

    }

    /**
     * Set the pet photo to be displayed
     *
     * @param photo photo of the pet
     */
    public void setPhoto(Image photo) {
        this.photo.setIcon(new ImageIcon(
                photo.getScaledInstance(700, 500, Image.SCALE_SMOOTH)));

    }

    /**
     * Set the owner name to be displayed
     *
     * @param ownerName the pet's owner's name
     */

    public void setOwnerName(String ownerName) {
        this.ownerName.setText("Owned by " + ownerName);
    }

    /**
     * Set the general description to be displayed
     *
     * @param generalDescr the pet's general description
     */

    public void setGeneralDescr(String generalDescr) {
        this.generalDescr.setText(generalDescr);
    }

    /**
     * Set the specie to be displayed
     *
     * @param specie the pet's specie
     */

    public void setSpecie(String specie) {
        this.specie.setText("Specie: " + specie);
    }


    /**
     * Set the age  to be displayed
     *
     * @param age the pet's age
     */

    public void setAge(int age) {
        this.age.setText("Age: I am " + String.valueOf(age) + " years old");
    }

    /**
     * Set the sex to be displayed
     *
     * @param sex the pet's sex
     */

    public void setSex(String sex) {
        this.sex.setText("Gender: " + sex);
    }

    /**
     * Set the size to be displayed
     *
     * @param size the pet's size
     */
    public void setSize(String size) {
        this.size.setText("Size: " + size);
    }

    /**
     * Set the like description to be displayed
     *
     * @param likeDescr the description of what this pet likes
     */

    public void setLikeDescr(String likeDescr) {
        this.likeDescr.setText(likeDescr);
    }

    /**
     * Set the temper description to be displayed
     *
     * @param tempDescr the description of this pet's temper;
     */
    public void setTempDescr(String tempDescr) {
        this.tempDescr.setText(tempDescr);
    }

    /**
     * Set the owner's instagram to be displayed
     *
     * @param ownerInstagram the pet's owner's instagram
     */
    public void setOwnerInstagram(String ownerInstagram) {
        this.ownerInstagram.setFont(new Font("Arial", Font.ITALIC, 20));
        this.ownerInstagram.setHorizontalAlignment(JLabel.TRAILING);
        gbc.insets = new Insets(0, 0, 50, 0);
        gbc.gridx = 0;
        gbc.gridy = gbc.gridy + 1;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.ownerInstagram, gbc);


        this.ownerInstagram.setText("Contact me through my instagram: " + ownerInstagram);
    }

    /**
     * Set additional attributes specific to the pet's specie to be dsiaplyed
     *
     * @param additionalAttributes the pet's additional attributes
     */
    public void setAdditionalAttributes(String specie, Map<String, String> additionalAttributes) {
        JLabel specificInfo = new JLabel(specie + " related information: ");
        gbc.gridy = gbc.gridy + 1;
        ;
        specificInfo.setFont(new Font("Arial", Font.BOLD, 30));
        specificInfo.setHorizontalAlignment(JLabel.LEADING);
        specificInfo.setAlignmentX(LEFT_ALIGNMENT);
        gbc.gridx = 0;
        gbc.weighty = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(specificInfo, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        //additional info
        for (String attributeName : additionalAttributes.keySet()) {

            gbc.gridy++;
            Font additionalInfoFont = new Font("Arial", Font.BOLD, 20);
            JLabel info = new JLabel(attributeName + ": " + additionalAttributes.get(attributeName));
            info.setForeground(Color.BLACK);
            info.setFont(additionalInfoFont);
            info.setAlignmentX(LEFT_ALIGNMENT);
            info.setHorizontalAlignment(JLabel.LEADING);
            gbc.insets = new Insets(0, 20, 0, 0);
            centerPanel.add(info, gbc);

        }

    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 10;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return ((orientation == SwingConstants.VERTICAL) ? visibleRect.height : visibleRect.width) - 10;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
