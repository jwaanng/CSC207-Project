package BePetOwner;

import Entity.User.AppUser;
import Entity.Constants;

import static Entity.Constants.PETOWNER;

public class BPOUCI implements BPOIB {
    final BPODAI dao;
    final BPOOB presenter;
    public BPOUCI(BPODAI dao, BPOOB presenter){
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
            dao.save(user);
            presenter.prepareSuccessView();
        }

    }
}
