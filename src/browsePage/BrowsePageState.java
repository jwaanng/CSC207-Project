package browsePage;

import entity.petProfile.PetProfile;
import login.LoginOPData;

import java.util.ArrayList;
import java.util.List;

public class BrowsePageState {

    private String username = "" ;
    private List<PetProfile> recommendation = new ArrayList<>();
    public BrowsePageState(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println(this.username);
    }

    public List<PetProfile> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(List<PetProfile> recommendation) {
        this.recommendation = recommendation;
    }
}

