package entity;

import entity.PetProfiles.PetProfile;
import recommendation.Recommendable;

import java.util.HashMap;

public class FinalMapUserToRecommendation {
    final HashMap<String, Recommendable<? extends PetProfile>> nameToRecommendation = new HashMap<>();

}
