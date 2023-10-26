package usecase.ChangeMyPetProfilePublicStatus;

import Entity.PetProfiles.PetProfile;

public class PublicStatusInputData {
    private boolean status; /*true == make public, false == make private */
    private PetProfile pf;

    public PublicStatusInputData(boolean status, PetProfile pf) {
        this.status = status;
        this.pf = pf;
    }

    public boolean getStatus() {
        return status;
    }


    public PetProfile getPf() {
        return pf;
    }
}
