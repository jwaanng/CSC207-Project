package bePetOwner;

import dataAccessObject.UserDataAccessInterface;
import entity.user.AppUser;

import static entity.Constants.PETOWNER;

/**
 * Use Case Interactor class for the Be Pet Owner (BPO) feature.
 * <p>
 * This class implements the {@link BPOIB} interface and is responsible for handling the business logic
 * associated with the Be Pet Owner feature. It interacts with the data access layer (UserDataAcessInterface)
 * to retrieve and update user data, and communicates with the presenter (BPOOB) to prepare views based on
 * the execution results.
 */
public class BPOUCI implements BPOIB {

    final UserDataAccessInterface dao;
    final BPOOB presenter;

    /**
     * Constructor for the BPOUCI class.
     *
     * @param dao       The data access interface for interacting with user data.
     * @param presenter The presenter associated with this use case interactor.
     */
    public BPOUCI(UserDataAccessInterface dao, BPOOB presenter) {
        this.dao = dao;
        this.presenter = presenter;
    }

    /**
     * Executes the business logic for the Be Pet Owner feature.
     * <p>
     * Retrieves the user with the provided username, checks if the user is already registered as a pet owner,
     * and either prepares a failure view if already registered or certifies the user as a pet owner and prepares
     * a success view.
     *
     * @param username The username of the user initiating the Be Pet Owner feature.
     */
    @Override
    public void execute(String username) {
        AppUser user = dao.retrieve(username);
        if (user.getRoles().contains(PETOWNER)) {
            presenter.prepareFailView("Already registered as petOwner");
        } else {
            user.certifyAsPetOwner();
            dao.update(user);
            presenter.prepareSuccessView();
        }
    }
}
