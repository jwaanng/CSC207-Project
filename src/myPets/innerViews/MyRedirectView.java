package myPets.innerViews;

import myPets.myPetsRedirect.MyRedirectController;
import myPets.myPetsRedirect.MyRedirectViewModel;
import redirect.CommonRedirectView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyRedirectView extends CommonRedirectView {
    public String viewName = "Redirect View";
    private MyRedirectController controller;
    public MyRedirectView(MyRedirectViewModel myRedirectViewModel, MyRedirectController myRedirectController){
        super(myRedirectViewModel);
        controller = myRedirectController;
        myPet.setEnabled(false);
        myPet.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.execute();
            }
        });
    }
}
