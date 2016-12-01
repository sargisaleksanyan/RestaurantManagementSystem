package Meal_Menu;

import Restaurant.Entity;

public abstract class MenuItem  implements Entity
{
    private int menuItemId;
    private String menuitemName;
    private double price;
    private double cost;
    private String menuCategoryName;


    public String getMenuCategoryName() {
        return menuCategoryName;
    }

    public void setMenuCategoryName(String menuCategoryName) {
        this.menuCategoryName = menuCategoryName;
    }


    public MenuItem(String menuitemName,double price,String menuCategoryName)
    {
        this.menuitemName=menuitemName;
        this.price=price;
        this.menuCategoryName=menuCategoryName;
    }
    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuitemName() {
        return menuitemName;
    }

    public void setMenuitemName(String menuitemName) {
        this.menuitemName = menuitemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
