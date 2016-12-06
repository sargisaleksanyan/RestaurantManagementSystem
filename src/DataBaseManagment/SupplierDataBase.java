package DataBaseManagment;

import Restaurant.Entity;
import Supplier.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SupplierDataBase extends EntityDataBase {

     public static final String NAME="name";
     public static final String SURNAME="surname";
     public static final String PHONE="phone";
     public static final String IDSupplier="idSuppler";

     public static final String SUPPLIERTABLE="Supplier";
    @Override
    public boolean insert(Entity e) {
        Supplier supplier=(Supplier) e;
        ResultSet resultSet=null;
        try
        {

            statement.executeUpdate("INSERT INTO "+SUPPLIERTABLE +"("+NAME+","+SURNAME+","+PHONE+") VALUES ("
                    + "'" + supplier.getName() + "', '" + supplier.getSurname() + "', '"
                    + supplier.getPhone() + "');");;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return  true;
    }

    @Override
    public <T> boolean update(T... t) {
        return false;
    }

    @Override
    public <T> boolean check(T... t) {
        return false;
    }
}
