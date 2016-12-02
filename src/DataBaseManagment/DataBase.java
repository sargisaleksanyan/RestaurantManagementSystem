package DataBaseManagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sargis on 12/1/16.
 */
public abstract class DataBase {
    protected Statement statement;
    private  final String SERVER_IP="95.140.195.69";
    private  final String SERVER_PORT="3306";
    private  final String DATABASE_NAME="A09155126";
    private  final String USER_NAME="A09155126";
    private  final String USER_PASSWORD="A09155126";
    public DataBase () {
        Connection mycon;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           // mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant?useSSL=false", "root", "hovik2011");
            mycon = DriverManager.getConnection("jdbc:mysql://"+SERVER_IP+":"+SERVER_PORT+
                    "/"+DATABASE_NAME+"?useSSL=false",USER_NAME,USER_PASSWORD);
            //mycon = DriverManager.getConnection("jdbc:mysql://95.140.195.69:3306/A09155126?useSSL=false", "A09155126", "A09155126");
            statement = mycon.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
