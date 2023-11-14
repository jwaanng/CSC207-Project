package DataAcessObject;

import Entity.User.AppUser;

public interface UserDataAcessInterface {
    String add(AppUser user);
    String update(AppUser user);
    String delete(String username);
    AppUser retrieve(String username);
}
