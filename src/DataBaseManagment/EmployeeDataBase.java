package DataBaseManagment;

import Employee.Employee;
import Restaurant.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDataBase extends EntityDataBase  implements SigninListener{
    public static final String EMPLOYEE_TABLE="Employee";
    public static final String LASTNAME="lastName";
    public static final String PHONE="phone";
    public static final String NAME="name";
    public static final String POSITION="position";
    public static final String SALARY="salary";
    public static final String EMPLOYEE_ID="idEmployee";

    @Override
    public boolean insert(Entity e) {
        Employee employee=(Employee)e;
        try {
            statement.executeUpdate("INSERT INTO " + EMPLOYEE_TABLE+ "(" +NAME +
                    "," + LASTNAME + ","+POSITION+ ","+SALARY+ ","+PHONE+") VALUES ("
                    + "'" + employee.getName() + "', '" +employee.getLastName() + "', '"
                    + employee.getPosition() + "', '"+employee.getSalary()+ "', '"+employee.getPhone()+ "');");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return true;
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
    public Entity signIn(String phone) {

        Employee employee=null;
        try {
            ResultSet myRs=statement.executeQuery("select * from "+EMPLOYEE_TABLE+" where "+PHONE+"="+phone);
            while(myRs.next())
            {
                String name=myRs.getString(NAME);
                String lastname=myRs.getString(LASTNAME);
                String position=myRs.getString(POSITION);
                double salary=myRs.getDouble(SALARY);
                int id=myRs.getInt(EMPLOYEE_ID);
                employee=new Employee(name,lastname,phone);
                employee.setPosition(position);
                employee.setSalary(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
}
