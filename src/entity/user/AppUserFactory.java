package entity.user;

/**
 * The AppUserFactory class is responsible for creating instances of AppUser.
 */
public class AppUserFactory {

<<<<<<< HEAD
    /**
     * Creates a new instance of AppUser with the provided information.
     *
     * @param username           The username of the user.
     * @param password           The password of the user.
     * @param address            The address of the user.
     * @param instagramUsername  The Instagram username of the user.
     * @return A new AppUser instance.
     */
    public AppUser createAppUser(String username, String password, String address, String instagramUsername) {
        return new AppUser(username, password, address, instagramUsername);
=======
    public AppUser createAppUser(String username, String password, String address,String instagram ){
        return new AppUser(username, password, address, instagram);

>>>>>>> 0e5a9c58a3fe9df328499a5cc6f7b8bb67495f99
    }
}

