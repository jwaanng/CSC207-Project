package usecase.SignUp;

public class SignUpInputData {
    String username;
    String password;
    String repeatedPassword;
    String address;

    public SignUpInputData(String username, String password, String repeatedPassword, String address) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
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
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

}
