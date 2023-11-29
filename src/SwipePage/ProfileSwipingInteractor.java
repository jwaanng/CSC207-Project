package SwipePage;
import entity.PetProfiles.PetProfile;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ProfileSwipingInteractor {
    private Queue<PetProfile> profiles;

    public ProfileSwipingInteractor(List<PetProfile> profiles) {
        this.profiles = new LinkedList<>(profiles);
    }

    public PetProfile getNextProfile() {
        return profiles.poll();
    }

}
