package login;

import dataAcessObject.PetProfileDataAccessObject;
import dataAcessObject.UserDataAcessInterface;
import entity.PetProfiles.PetProfile;
import entity.User.AppUser;

public class LGUCI implements LGIB{
    final LGOB presenter;
    final UserDataAcessInterface dao;

    final PetProfileDataAccessObject daoP;
    public LGUCI(LGOB presenter, UserDataAcessInterface dao, PetProfileDataAccessObject daoP) {
        this.presenter = presenter;
        this.dao = dao;
        this.daoP = daoP;
    }

    @Override
    public void execute(LGIPData loginData) {
        String name = loginData.getUsername();
        String pw = loginData.getPassword();

        if (!dao.exist(name)){

            presenter.prepareFailView(LGOPData.createFailData("Username does not exist"));
        }
        else {
            AppUser currUser = dao.retrieve(name);
            if(currUser.getPassword().equals(pw)){
                presenter.prepareFailView(LGOPData.createFailData("Password does not match"));
            }
            else{
                LGOPData successData = LGOPData.createSuccessData(name);
                for (int petId : currUser.getFavPet()){
                    PetProfile profile = daoP.getProfile(petId);
                     successData.addPetNameAndPHOTO(profile.getId(), profile.getName(), profile.getPetPhotoLink());
                }
                presenter.prepareSuccessView(successData);
            }
        }




    }
}
