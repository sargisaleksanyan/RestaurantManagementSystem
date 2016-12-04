package Restaurant.SignInPage;

import DataBaseManagment.CustomerDataBase;
import DataBaseManagment.SigninListener;
import Restaurant.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sargis on 12/3/16.
 */
public class CustomerSignIn extends SignInPage implements ActionListener {
  //  private JButton logIn ;
    private JButton signUp;
    private JTextField phoneField;
    private JTextField phoneLabel;
    private boolean isAddClicked=false;
    public CustomerSignIn(SigninListener db, JPanel jPanel)
    {
        super(db, jPanel);
        setView();
    }

    @Override
    public void setView()
    {
       // logIn = new JButton("Log In");

        jPanel.setLayout(new GridLayout(4,1));
        phoneLabel=new JTextField("Phone");
        phoneLabel.setEditable(false);
        phoneLabel.addActionListener(this);
        phoneField=new JTextField();
        jPanel.add(phoneLabel);
        jPanel.add(phoneField);
        signUp=new  JButton("Sign Up");
       // logIn.addActionListener(this);
        signUp.addActionListener(this);
        jPanel.add(signUp);


    }

    @Override
    public Entity getEntity()
    {
        return signinListener.signIn(phoneField.getText().toString());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       if(actionEvent.getSource()==signUp)
       {

           jPanel.removeAll();

           CustomerSignUp customerSignUp=new CustomerSignUp(jPanel);
           jPanel.getParent().validate();
       }


    }
}
