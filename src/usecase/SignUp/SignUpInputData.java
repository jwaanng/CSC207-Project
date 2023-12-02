package usecase.SignUp;

public class SignUpInputData {
    String username;
    String password;
    String repeatedPassword;
    String address;

    String instagram;

    public SignUpInputData(String username, String password, String repeatedPassword, String address, String instagram) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.instagram = instagram;
//        this.address = address;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getAddress() {
        return address;
    }

    String getInstagram() {return instagram;}
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

}
