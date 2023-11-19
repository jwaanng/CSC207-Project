package usecase.SignUp;

public class SiggnupOutputData {
    private final String username;
    private final String password;
    private final String address;
    private boolean useCaseFailed;

    public SiggnupOutputData(String username, boolean useCaseFailed){
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }
    public String getUsername(){
        return username;
    }
    public String getAddress(){
        return address;
    }

}