package browsePage.swipe;

import entity.petProfile.PetProfile;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProfileQueueChainer {
    private Queue<PetProfile> profiles;

    public ProfileQueueChainer(List<PetProfile> profiles) {
        this.profiles = new LinkedList<>(profiles);
    }

    public PetProfile getNextProfile() {
        return profiles.poll();
    }


}
