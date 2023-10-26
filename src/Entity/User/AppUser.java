package Entity.User;

import Entity.PetProfiles.PetProfile;

import java.util.ArrayList;
import java.util.List;

import static Entity.Constants.*;

public class AppUser {
    private String username;

    private String bio;
    private String password;
    private String address;
    private List<PetProfile> favPet;
    private List<String> roles;

    private List<PetProfile> myPet;


    public AppUser(){}
    public AppUser(String username, String password, String address) {
        /*Require password is valid */
        this.username = username;
        this.password = password;
        this.address = address;
        this.favPet = new ArrayList<PetProfile>();
        this.roles = new ArrayList<String>();
        roles.add(PETFINDER);
    }

    public void CertifyAsPetOwner() {
       /*require the user is not a petOwner*/
        roles.add(PETOWNER);
        myPet = new ArrayList<PetProfile>();
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

    public String getAddress() {
        return address;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean isPetFinder(){
        return roles.contains(PETFINDER);
    }

    public boolean isPetOwner(){
        return roles.contains(PETOWNER);
    }
    public boolean profileIsFav(PetProfile profile){
        return favPet.contains(profile);
    }
    public void addFavProfile(PetProfile profile){
        favPet.add(profile);
    }
    public void deleteFavProfile(PetProfile profile){
        /*profile must be in pet*/
        favPet.remove(profile);
    }

}