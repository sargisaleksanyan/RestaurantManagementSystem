package Order;

import java.util.Date;

public class History {
    private Date date;
    private int TotalAmount;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        TotalAmount = totalAmount;
    }


}
