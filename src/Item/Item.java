package Item;

import Restaurant.Entity;

import Supplier.Supplier;

public class Item implements Entity{

    private int itemId;
    private  String itemName;
    private  double price;
    private  int lifeTime;
    private Supplier supplier;

    public Item(String itemName,double price,int lifeTime)
    {
        this.itemName=itemName;
        this.price=price;
        this.lifeTime=lifeTime;
    }
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        return itemId;
    }

    @Override
    public boolean equals(Object o)
    {
       /* if(this.hashCode()==o.hashCode())
        {
            return true;
        }
        */
        return this.hashCode()==o.hashCode();
    }
}
