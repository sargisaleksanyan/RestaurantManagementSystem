package DataBaseManagment;

import Restaurant.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sargis on 11/29/16.
 */
public  abstract  class DataBase {

    protected Statement statement;

    public DataBase() {
        Connection mycon;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant?useSSL=false", "root", "hovik2011");
            statement = mycon.createStatement();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public abstract boolean insert(Entity e);
    public abstract <T>boolean update(T ...t);
    public abstract <T>boolean check(T ...t);
}
