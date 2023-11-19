package Login;

public class LGController {
    private final LGIB uci;

    public LGController(LGIB loginUseCaseInteractor) {
        this.uci  = loginUseCaseInteractor;
    }
    public void execute(String username, String password){
        LGIPData ipdata = new LGIPData(username, password);
        uci.execute(ipdata);
    }
}
