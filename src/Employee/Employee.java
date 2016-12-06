package Employee;

import Restaurant.Entity;


public class Employee implements Entity{
    private int    idEmpoyee;
    private String name;
    private String lastName;
    private String position;
    private double salary;
    private String phone;
    public Employee(String name,String lastName,String phone)
    {
        this.name=name;
        this.lastName=lastName;
        this.phone=phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public int getIdEmpoyee() {
        return idEmpoyee;
    }

    public void setIdEmpoyee(int idEmpoyee) {
        this.idEmpoyee = idEmpoyee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
