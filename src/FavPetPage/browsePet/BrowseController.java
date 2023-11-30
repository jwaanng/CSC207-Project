package favPetPage.browsePet;

public class BrowseController {
    BrowseIB uci;

    public BrowseController(BrowseIB browsePetUsecaseInteracter){
        uci = browsePetUsecaseInteracter;
    }

    public void execute(){
        uci.execute();
    }
}
