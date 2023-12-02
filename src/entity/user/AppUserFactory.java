package entity.user;

public class AppUserFactory {
    public AppUser createAppUser(String username, String password, String address, String instagramUsername){
        return new AppUser(username, password, address, instagramUsername);
    }
}

