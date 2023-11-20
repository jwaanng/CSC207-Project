package DataAcessObject;

import Entity.PetProfiles.PetProfile;

public interface PetProfileDataAccessInterface {
    void add(PetProfile profile);
    void update(PetProfile profile);
    PetProfile getProfile(String name, String petOwnerName , String specie);
    void delete(String name, String petOwnerName , String specie);
}
