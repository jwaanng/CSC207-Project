package favPetPage.browsePet;

public class BPController {
    BPIB uci;

    public BPController(BPIB browsePetUsecaseInteracter){
        uci = browsePetUsecaseInteracter;
    }

    public void execute(){
        uci.execute();
    }
}
