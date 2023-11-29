package SwipePage;
import entity.PetProfiles.PetProfile;
import entity.PetProfiles.DogProfile;


import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ProfileSwipingInteractor {
    private Queue<PetProfile> profiles;

    public ProfileSwipingInteractor(List<DogProfile> profiles) {
        this.profiles = new LinkedList<>(profiles);
    }

    public PetProfile getNextProfile() {
        return profiles.poll();
    }

}
