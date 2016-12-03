package Restaurant.SignInPage;

import DataBaseManagment.SigninListener;
import Restaurant.Entity;

import javax.swing.*;

/**
 * Created by sargis on 12/3/16.
 */
public class CustomerSignIn extends SignInPage {

    public CustomerSignIn(SigninListener db, JPanel jPanel)
    {
        super(db, jPanel);
    }

    @Override
    public void setView()
    {

    }

    @Override
    public Entity getEntity()
    {
        return null;
    }
}
