package signupPage.signup;

public class SignupState {
    private String username = "";
    private String error = null;
    private String password = "";
//    private String passwordError = null;
    private String repeatPassword = "";
    private String address = "";
    private String instagram = "";

    public SignupState(SignupState copy) {
        error = copy.error;
        username = copy.username;
//        usernameError = copy.usernameError;
        password = copy.password;
//        passwordError = copy.passwordError;
        repeatPassword = copy.repeatPassword;
//        repeatPasswordError = copy.repeatPasswordError;
        address = copy.address;
        instagram = copy.instagram;
//        addressError = copy.addressError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SignupState() {
    }

    public String getUsername() {
        return username;
    }


    public String getError() {
        return error;
    }

    public String getPassword() {
        return password;
    }


    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getAddress() {return address;}

    public void setUsername(String username) {
        this.username = username;
    }


    public void setError(String error) {
        this.error = error;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }


    public void setAddress(String adrress) {
        this.address = adrress;
    }

    public void setInstagram(String instagram) { this.instagram = instagram;}
    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", address='" + address + '\'' +
                ", error='" + error + '\'' +
                ", instagram='" + instagram +'\'' +
                '}';
    }

}



