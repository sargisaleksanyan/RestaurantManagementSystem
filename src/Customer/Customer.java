package Customer;

import Order.History;
import Restaurant.Entity;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Entity {
    private int customerId;
    //   private String
    private  String name ;
    private  String lastName;
    private  String  phoneNumber;
    private  String creditCard;


    public Customer( String name, String lastName,String phoneNumber)
    {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber=phoneNumber;
    }
    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
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

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }



}
