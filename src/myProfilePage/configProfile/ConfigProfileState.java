package myProfilePage.configProfile;

import login.LoginOPData;
import login.LoginState;

import java.util.Map;
// TODO: write docs

public class ConfigProfileState {
    private String username = "";
    private String address = "";
    private String bio = "";
    private String error = null;
    private String preferredSize = "";
    private String  preferredSex = "";
    public ConfigProfileState(ConfigProfileState copy) {
        username = copy.username;
        address = copy.address;
        bio = copy.bio;
        preferredSize = copy.preferredSize;
         preferredSex = copy.preferredSex;
    }
    public String getUserName() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPreferredSize() {
        return preferredSize;
    }

    public void setPreferredSize(String preferredSize) {
        this.preferredSize = preferredSize;
    }

    public String getPreferredSex() {
        return preferredSex;
    }

    public void setPreferredSex(String preferredSex) {
        this.preferredSex = preferredSex;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public ConfigProfileState() {}


}


