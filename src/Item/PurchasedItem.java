package Item;

import Restaurant.Entity;

/**
 * Created by sargis on 11/28/16.
 */
public class PurchasedItem implements Entity{
    private String purchaseDate;
    private int purchaseId;
    private double purchaseAmount;
    private double currentAmount;
    private Item item;
   public PurchasedItem(String purchaseDate,double purchaseAmount)
    {
        this.purchaseDate=purchaseDate;
        this.purchaseAmount=purchaseAmount;
    }
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


}
