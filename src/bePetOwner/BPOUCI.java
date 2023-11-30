package bePetOwner;

import dataAcessObject.UserDataAcessInterface;
import entity.user.AppUser;

import static entity.Constants.PETOWNER;

public class BPOUCI implements BPOIB {
    final UserDataAcessInterface dao;
    final BPOOB presenter;
    public BPOUCI(UserDataAcessInterface dao, BPOOB presenter){
        this.dao = dao;
        this.presenter = presenter;
    }

    @Override
    public void execute(String username) {
        AppUser user = dao.retrieve(username);
        if(user.getRoles().contains(PETOWNER)){
            presenter.prepareFailView("Already registered as petOwner");
        }
        else{
            user.certifyAsPetOwner();
            dao.update(user);
            presenter.prepareSuccessView();
        }

    }
}
