package dataAcessObject;

import entity.user.AppUser;

public interface UserDataAcessInterface {
    void add(AppUser user);
    void update(AppUser user);
    void delete(String username);
    AppUser retrieve(String username);
    boolean exist(String username);
}
