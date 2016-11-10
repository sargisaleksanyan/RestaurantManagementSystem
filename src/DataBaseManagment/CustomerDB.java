package DataBaseManagment;

import java.sql.*;

/**
 * Created by sargis on 11/9/16.
 */
public class CustomerDB {

    private  Statement statement;
    public CustomerDB()
    {
        Connection mycon;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mycon= DriverManager.getConnection("jdbc:mysql://95.140.195.69:3306/A09155126","A09155126","A09155126");
            statement=mycon.createStatement();

           }
           catch (ClassNotFoundException e)
           {
            e.printStackTrace();
           }
           catch (SQLException e)
           {
            e.printStackTrace();
           }

    }
    public String customerLogIn(int phone)
    {
      String name=null;
        try
        {
            ResultSet myRs=statement.executeQuery("select * from Customer where  phone"+"="+phone);



               while (myRs.next()) {
                  //  System.out.println(myRs.getString("firstName") + myRs.getString("phone"));

              name=myRs.getString("firstName");

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
      return name;
    }

    public boolean signUp(String name,String surName,int phone)
    {
        if(customerLogIn(phone)==null)
        {
            try {

                statement.executeUpdate("INSERT INTO Customer (firstName,lastName,phone) VALUES ("
                        + "'" + name + "', '" + surName + "', '" + phone + "');");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return true;
        }
       return false;
    }
}
