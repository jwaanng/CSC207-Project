package bePetOwner;

public class BPOController {
    final BPOIB interactor;
    BPOController(BPOIB interactor){
        this.interactor = interactor;
    }
    public void execute(String username){
        interactor.execute(username);
    }
}
