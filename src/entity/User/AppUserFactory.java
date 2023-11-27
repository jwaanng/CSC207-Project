package entity.User;

public class AppUserFactory {
    public AppUser createAppUser(String username, String password, String address){
        return new AppUser(username, password, address);
    }
}

