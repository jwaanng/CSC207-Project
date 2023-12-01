package configProfile;

public class ConfigProfileState {

    private String username = "";
    private String address = "";
    private String bio = "";
    private String size = "";
    private String sex = "";
    private String error = null;

    public ConfigProfileState(ConfigProfileState copy) {
        error = copy.error;
        address = copy.address;
        bio = copy.bio;
        size = copy.size;
        sex = copy.sex;
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ConfigProfileState() {
    }

    public String getAddress() {
        return address;
    }

    public String getUsername(){
        return username;
    }

    public String getError() {
        return error;
    }

    public String getBio() {
        return bio;
    }

    public String getSex() {
        return sex;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setUsername(String username) { this.username = username; }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public void setSize(String size) {
        this.size = size;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ConfigProfileState{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", bio='" + bio + '\'' +
                ", size='" + size + '\'' +
                ", sex='" + sex + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}




