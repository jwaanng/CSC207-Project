package favPetPage.deleteAFavPet;

public class DFPIPData {
    private String username;
    private int id;

    public DFPIPData(String username, int petId){
        this.username = username;
        this.id = petId;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }
}
