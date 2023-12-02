package entity.user;

public class AppUserFactory {

    public AppUser createAppUser(String username, String password, String address,String instagram ){
        return new AppUser(username, password, address, instagram);

    }
}

