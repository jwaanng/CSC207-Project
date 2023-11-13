package Entity;

import Entity.PetProfiles.PetProfile;
import Recommendation.Recommendable;

import java.util.HashMap;

public class FinalMapUserToRecommendation {
    final HashMap<String, Recommendable<? extends PetProfile>> nameToRecommendation = new HashMap<>();

}
