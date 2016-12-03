package Restaurant.SignInPage;

import DataBaseManagment.EntityDataBase;
import DataBaseManagment.SigninListener;
import Restaurant.Entity;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by sargis on 12/3/16.
 */
public abstract class SignInPage  {

    SigninListener signinListener;
    JPanel jPanel;

    public SignInPage(SigninListener  db, JPanel jPanel)
    {
        signinListener=db;

        this.jPanel=jPanel;
    }
    public abstract void setView();
 //   public abstract void setSignInView(JPanel jPanel);
    public abstract Entity getEntity();
  //  public
}
