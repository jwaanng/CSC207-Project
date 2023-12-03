package usecase.ConfigProfile;

import configProfile.ConfigProfilePresenter;
import dataAcessObject.CommonUserDataAccessObject;
import dataAcessObject.UserDataAcessInterface;
import entity.user.AppUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigProfileInteractor implements ConfigProfileInputBoundary {
    final UserDataAcessInterface configProfileDataAccessInterface;
    final ConfigProfileOutputBoundary configProfilePresenter;

    public ConfigProfileInteractor(UserDataAcessInterface configProfileDataAccessInterface,  ConfigProfileOutputBoundary configProfilePresenter) {
        this.configProfileDataAccessInterface = configProfileDataAccessInterface;
        this.configProfilePresenter = configProfilePresenter;

    }

    // Helper method to help you see if a string contains any of these characters - jw
    public boolean containsSpecialChars(String s) {
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Incorrect format of string");
            return true;
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9, ]");
        Matcher m = p.matcher(s);
        return m.find();
    }

    @Override
    public void execute(ConfigProfileInputData data) {

        if (containsSpecialChars(data.getAddress())) {
            // if the name does contain any special characters
            System.out.println("INTERACTOR: FIRST IF");
            configProfilePresenter.prepareFailView("Make sure address doesn't contain special characters");
        } else if (data.getBio().length() > 150) {
            // if the bio is too long
            configProfilePresenter.prepareFailView("Keep bio under 150 characters.");
        } else {
            // TODO2 Done -ming: saving the info if all parameters are met.
            AppUser user = configProfileDataAccessInterface.retrieve(data.getUsername()); //TODO: get username
            // setting attributes to user
            user.setBio(data.getBio());
            user.setAddress(data.getAddress());
            user.setPreferredSize(data.getSize());
            user.setPreferredSex(data.getSex());

            System.out.println("INTERACTOR: " + user.getPreferredSex() + " " + user.getPreferredSize());


            configProfileDataAccessInterface.update(user);
            System.out.println("INTERACTOR after: " + user.getPreferredSex() + " " + user.getPreferredSize());
        }
    }
}
