package BePetOwner;

import Entity.User.AppUser;

public interface BPODAI {
    void save(AppUser user);
    AppUser retrieve(String username);

}
