package entity.comparator;

import entity.petProfile.PetProfile;

import java.util.Comparator;

class PetProfileComparatorByAge implements Comparator<PetProfile> {
    private final int targetAge;
    public PetProfileComparatorByAge(int targetAge){
        this.targetAge = targetAge;
    }
    @Override
    public int compare(PetProfile p1, PetProfile p2)
    {
        return (p1.getAge() - targetAge) - (p2.getAge()- targetAge);

    }

}
