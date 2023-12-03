package configProfile;

import java.util.HashMap;
import java.util.Map;
// TODO: write docs

public class ConfigProfileState {
    private String username = "";
    private String address = "";
    private String password = "";
    private String bio = "";
    private String error = null;
    private Map<String, Boolean> sex;
    private Map<String, Boolean> size;

    public ConfigProfileState(ConfigProfileState copy){
        username = copy.username;
        address = copy.address;
        password = copy.password;
        bio = copy.bio;
        size = copy.size;
        sex = copy.sex;


        sex.put("female", false);
        sex.put("male", false);
//        sex.put("both", false);
        size.put("small", false);
        size.put("big", false);
        size.put("medium", false);
    }
    public String getName() {
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
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public ConfigProfileState() {}
    public String getSex() {
        StringBuilder selectedSex = new StringBuilder();
        for (Map.Entry<String, Boolean> entry : sex.entrySet()) {
            if (entry.getValue()) {
                if (selectedSex.length() > 0) {
                    selectedSex.append(", ");
                }
                selectedSex.append(entry.getKey());
            }
        }
        return selectedSex.toString();
    }
    public String getSize() {
        StringBuilder selectedSize = new StringBuilder();
        for (Map.Entry<String, Boolean> entry : size.entrySet()) {
            if (entry.getValue()) {
                if (selectedSize.length() > 0) {
                    selectedSize.append(", ");
                }
                selectedSize.append(entry.getKey());
            }
        }
        return selectedSize.toString();
    }
    public void setSex(Map<String, Boolean> sex) {
        this.sex = sex;
    }
    public void setSize(Map<String, Boolean> size) {
        this.size = size;
    }
    public void setSmall(boolean small) {
        size.put("small", small);
    }
    public void setMedium(boolean medium) {
        size.put("medium", medium);
    }
    public void setLarge(boolean large) {
        size.put("large", large);
    }
    public void setFemale(boolean female) {
        sex.put("female", female);
    }
    public void setMale(boolean male) {
        sex.put("male", male);
    }
    public void setBoth(boolean both) {
        sex.put("both", both);
    }
    public boolean isFemale() {
        return sex.get("female");
    }
    public boolean isMale() {
        return sex.get("male");
    }
    public boolean isSmall() {
        return size.get("small");
    }
    public boolean isMedium() {
        return size.get("medium");
    }
    public boolean isLarge() {
        return size.get("large");
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ConfigProfileState: ");
        sb.append("username='").append(username).append('\'');
        sb.append(", bio='").append(bio).append('\'');
        sb.append(", address='").append(address).append('\'');

        boolean hasSexEntries = false;
        sb.append(", sex=");
        for (Map.Entry<String, Boolean> entry : sex.entrySet()) {
            if (entry.getValue()) {
                if (hasSexEntries) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                hasSexEntries = true;
            }
        }

        boolean hasSizeEntries = false;
        sb.append(", size=");
        for (Map.Entry<String, Boolean> entry : size.entrySet()) {
            if (entry.getValue()) {
                if (hasSizeEntries) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                hasSizeEntries = true;
            }
        }

        sb.append(", error='").append(error).append('\'');
        return sb.toString();
    }
}


