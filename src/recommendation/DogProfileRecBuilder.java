package recommendation;

import entity.petProfile.DogProfile;

import java.util.List;

public class DogProfileRecBuilder implements RecBuilder<DogProfile>{
    @Override
    public Recommendable<DogProfile> build(List<DogProfile> collection) {
        return null;
    }
}
