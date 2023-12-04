package browsePage.swipePage;

import entity.petProfile.PetProfile;
import entity.user.AppUser;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProfileSwipingInteractor {
    private Queue<PetProfile> profiles;

    public ProfileSwipingInteractor(List<PetProfile> profiles) {
        this.profiles = new LinkedList<>(profiles);
    }

    public PetProfile getNextProfile() {
        return profiles.poll();
    }

    public void addPetToUserFav(PetProfile pet, AppUser user) {

    }
}
