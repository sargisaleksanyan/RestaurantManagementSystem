package Customer;

import Order.History;

import java.util.ArrayList;
import java.util.List;

public class Customer  {
    private int customerId;
    //   private String
    private  String name ;
    private  String lastName;
    private  int phoneNumber;
    List<History> history=new ArrayList<History>();

    public Customer(int customerId, String name, String lastName)
    {
        this.customerId = customerId;
        this.name = name;
        this.lastName = lastName;
    }

    public Customer(int customerId)
    {
        this.customerId = customerId;
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }



}
