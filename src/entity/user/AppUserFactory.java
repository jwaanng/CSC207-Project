package entity.user;

public class AppUserFactory {
    public AppUser createAppUser(String username, String password, String address){
        return new AppUser(username, password, address);
    }
}

