package entity.user;

import entity.petProfile.PetProfile;

import java.util.ArrayList;
import java.util.List;

import static entity.Constants.*;

/**
 * The AppUser class represents a user in the application.
 */
public class AppUser {

    private String username;
    private String bio;
    private String password;
    private String address;
    private String preferredSex;
    private String preferredSize;
    private List<Integer> favPet;
    private List<String> roles;
    private String instagramUsername;
    private List<Integer> myPet;

    /**
     * Default constructor for AppUser.
     */
    public AppUser() {}

    /**
     * Parameterized constructor for creating an AppUser with essential information.
     *
     * @param username           The username of the user.
     * @param password           The password of the user.
     * @param address            The address of the user.
     * @param instagramUsername  The Instagram username of the user.
     */
    public AppUser(String username, String password, String address, String instagramUsername) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.instagramUsername = instagramUsername;
        this.favPet = new ArrayList<>();
        this.roles = new ArrayList<>();
        roles.add(PETFINDER);
    }

    /**
     * Certifies the user as a pet owner.
     */
    public void certifyAsPetOwner() {
        roles.add(PETOWNER);
        myPet = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getPreferredSex() { return preferredSex; }

    public String getPreferredSize() {return preferredSize; }

    public String getAddress() {
        return address;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPreferredSize(String size) {
        this.preferredSize = size;
    }

    public void setPreferredSex(String sex) {
        this.preferredSex = sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPetFinder(){
        return roles.contains(PETFINDER);
    }

    public boolean isPetOwner(){
        return roles.contains(PETOWNER);
    }
    public boolean profileIsFav(PetProfile profile){
        return favPet.contains(profile.getId());
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public void createMyPetProfile(int petId){
        myPet.add(petId);
    }
    public void deleteMyPetProfile(int petId){
        myPet.remove(petId);
    }

    public void addFavProfile(int petId){
        favPet.add(petId);
    }

    /**
     * Deleteds a pet profile from favourite pets
     *
     * @param petId id of the pet needed to be deleted
     */
    public void deleteFavProfile(int petId){
        /*petId must be in favPet*/
        favPet.remove(petId);
    }
    /**
     * Gets roles
     *
     * @return a list of roles
     */
    public List<String> getRoles(){
        return new ArrayList<String>(roles);
    }
    /**
     * Gets list of fav pets
     *
     * @return a list of fav pets
     */
    public List<Integer> getFavPet(){
        return new ArrayList<>(this.favPet);
    } //new copy

    public List<Integer> getMyPet(){
        return  new ArrayList<>(this.myPet);
    }
}