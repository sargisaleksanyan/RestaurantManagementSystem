package DataBaseManagment;

import Customer.Customer;
import Restaurant.Entity;

import java.sql.*;

/**
 * Created by sargis on 11/9/16.
 */
public class CustomerDataBase extends EntityDataBase  implements SigninListener{

   private  final String PHONE="phone";
   private  final String NAME="name";
   private  final String LASTNAME="lastname";
   private  final String id="lastname";
   private  final String CREDITCARD="creditCard";

    public String customerLogIn(String phone)
    {
      String name=null;
        try
        {
            ResultSet myRs=statement.executeQuery("select * from Customer where "+ PHONE+"+="+phone);
            while (myRs.next())
            {
                //  System.out.println(myRs.getString("firstName") + myRs.getString("phone"));
                name=myRs.getString(NAME);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return name;
    }



    @Override
    public boolean insert(Entity e) {
        Customer customer=(Customer)e;
        if(customerLogIn(customer.getPhoneNumber())==null)
        {
            try {
                if(customer.getCreditCard()==null) {
                    statement.executeUpdate("INSERT INTO Customer ("+NAME+","+LASTNAME+","+PHONE+") VALUES ("
                            + "'" + customer.getName() + "', '" + customer.getLastName() + "', '"
                            + customer.getPhoneNumber() + "');");
                }
                else
                {

                    statement.executeUpdate("INSERT INTO Customer ("+NAME+","+LASTNAME+","+PHONE+","+CREDITCARD+") VALUES ("
                            + "'" + customer.getName() + "', '" + customer.getLastName() +
                            "', '" + customer.getPhoneNumber() + "', '"+customer.getCreditCard()+ "');");
                }
            } catch (SQLException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
            return true;
        }
        return false;
    }


    @Override
    public <T> boolean update(T... t) {
        return false;
    }

    @Override
    public <T> boolean check(T... t) {
        return false;
    }


    @Override
    public Entity signIn(String string) {
        return null;
    }
}
