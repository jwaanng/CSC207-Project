package Recommendation;

import Entity.PetProfiles.PetProfile;

import java.util.List;

public class PetProfileRecBuilder implements RecBuilder<PetProfile>{
    @Override

    public Recommendable<PetProfile> build(List<PetProfile> collection) {
        return null;
    }
}
