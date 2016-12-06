package DataBaseManagment;

import Restaurant.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public  abstract  class EntityDataBase extends DataBase{

    public abstract boolean insert(Entity e);
    public abstract <T>boolean update(T ...t);
    public abstract <T>boolean check(T ...t);
}
