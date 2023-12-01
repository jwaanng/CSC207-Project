package usecase.ConfigProfile;

// Get the input data from ConfigProfileView: name (user's name), address, bio (optional), size, sex
public class ConfigProfileInputData {
    final private String username;
    final private String address;
    final private String bio;

    final private String size;

    final private String sex;

    public ConfigProfileInputData(String username, String address, String bio, String size, String sex) {
        this.username = username;
        this.address = address;
        this.bio = bio;
        this.size = size;
        this.sex = sex;
    }

    String getUsername() {
        return username;
    }

    String getAddress() {
        return address;
    }

    public String getBio() {
        return bio;
    }

    String getSize() {
        return size;
    }

    String getSex() {return sex; }
}