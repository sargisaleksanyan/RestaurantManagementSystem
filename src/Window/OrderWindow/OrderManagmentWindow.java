package Window.OrderWindow;

import DataBaseManagment.DataList;
import Order.Order;
import javax.swing.*;
import java.awt.*;

/**
 * Created by sargis on 11/28/16.
 */
public class OrderManagmentWindow extends JFrame {
   protected int xCord;
   protected int yCord ;
   protected int width;
   protected int height ;
   private JTextArea jTextArea;
    public OrderManagmentWindow()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        width = dim.width * 4/ 10;
        height  = dim.height * 8 / 10;
        xCord=dim.width / 2 - width / 2;
        yCord=dim.height / 2 - height  / 2;
        this.setLocation(xCord, yCord);
        dim.setSize(width,height);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(dim);

        setVisible(true);
        jTextArea=new JTextArea();
        addToTextView();
        add(jTextArea);
    }
    public void addToTextView()
    {
        DataList dataList=new DataList();
        java.util.List<Order> orderList=dataList.getAllOrders();
        String text="";
        for(int i=0;i<orderList.size();i++)
        {
           text=text +orderList.get(i).getOrderId()+" ";
        }
        jTextArea.setText(text);
        validate();
        repaint();
    }

    public static void main(String[] args) {
      OrderManagmentWindow omw=new OrderManagmentWindow();
        while(true)
        {
            omw.addToTextView();
            omw.repaint();
            omw.validate();
        }
    }
}
