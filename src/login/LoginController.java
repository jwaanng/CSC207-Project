package login;

public class LoginController {
    private final LoginIB uci;

    public LoginController(LoginIB loginUseCaseInteractor) {
        this.uci  = loginUseCaseInteractor;
    }
    public void execute(String username, String password){
        LoginIPData ipdata = new LoginIPData(username, password);
        uci.execute(ipdata);
    }
}
