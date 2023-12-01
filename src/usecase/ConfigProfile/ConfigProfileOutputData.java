package usecase.ConfigProfile;

public class ConfigProfileOutputData {
    private final String name;
    private boolean useCaseFailed;

    public ConfigProfileOutputData(String name, boolean useCaseFailed){
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }
    public String getName(){
        return name;
    }
}
