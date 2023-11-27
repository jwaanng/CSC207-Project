package usecase.ChangeMyPetProfilePublicStatus;

import entity.PetProfiles.PetProfile;

import static entity.Constants.*;

public class UCInteractor implements InputBound {
    final OutputBound changeProfileStatusPresenter;
    final DataAccessInterface changeProfileStatusDataAcessObject;

    public UCInteractor(OutputBound presenter, DataAccessInterface access){
        changeProfileStatusPresenter = presenter;
        changeProfileStatusDataAcessObject = access;
    }
    private String setProfilePublic(PetProfile profile) {
        if (profile.getName().isEmpty()) {
            return noNameErr;
        } else if (profile.getAge() <= 0) {
            return noAGErr;
        } else if (profile.getSex() == '\u0000') {
            return noSexErr;

        } else if (profile.getSize() == '\u0000') {
            return noSizeErr;
        } else {
            profile.setProfilePublic();
            return success;
        }
    }
    @Override
    public void execute(PublicStatusInputData data) {
        PetProfile pf = data.getPf();
        String outcome;
        if (data.getStatus()){
            outcome = setProfilePublic(pf);
            if (outcome == success){
            changeProfileStatusPresenter.prepareMakePublicSuccessView();
            }
            else changeProfileStatusPresenter.prepareMakePublicFailView(outcome);
        }
        else {
            pf.setProfilePrivate();
        changeProfileStatusPresenter.prepareMakePrivateSuccessView();
        }
    }
}
