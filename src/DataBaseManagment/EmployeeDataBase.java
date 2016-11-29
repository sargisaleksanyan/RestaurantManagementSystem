package DataBaseManagment;

import Restaurant.Entity;

/**
 * Created by sargis on 11/29/16.
 */
public class EmployeeDataBase extends DataBase {
    @Override
    public boolean insert(Entity e) {
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
}
