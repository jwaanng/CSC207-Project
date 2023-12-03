package swipePage;
import entity.petProfile.PetProfile;
import dataAccessObject.CommonProfileDataAccessObject;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class ProfileSwipingInteractor {
    private Queue<PetProfile> profiles;

    public ProfileSwipingInteractor(List<PetProfile> profiles) {
        this.profiles = new LinkedList<>(profiles);
    }

    public PetProfile getNextProfile() {
        return profiles.poll();
    }

//    public ArrayList getNextProfile() {
//        PetProfile tempProfile = profiles.poll();
//        ArrayList<Object> list = new ArrayList<>();
//        list.add(tempProfile);
//        list.add(tempProfile.getId());
//        return list;
//    }

}
