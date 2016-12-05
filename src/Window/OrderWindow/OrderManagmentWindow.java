package Window.OrderWindow;

import DataBaseManagment.DataList;
import DataBaseManagment.TempDataList;
import Meal_Menu.*;
import Meal_Menu.MenuItem;
import Order.Order;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Order.OrderMenuItem;
/**
 * Created by sargis on 11/28/16.
 */
public class OrderManagmentWindow extends JFrame implements ActionListener{
    protected int xCord;
    protected int yCord ;
    protected int width;
    protected int height ;
    protected JPanel mainPanel;
    protected JPanel subPanel;

   private  JButton refreshButton;

    public OrderManagmentWindow(double w,double h)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        width = (int) (dim.width * w);
        height  = (int) (dim.height * h);
        xCord=dim.width / 2 - width / 2;
        yCord=dim.height / 2 - height  / 2;
        this.setLocation(xCord, yCord);
        dim.setSize(width,height);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(dim);
        refreshButton=new JButton("Refresh");
        refreshButton.addActionListener(this);
        add(refreshButton);
        mainPanel=new JPanel();
        setContentPane(mainPanel);
        subPanel=new JPanel();
        subPanel.setBounds(xCord, 0, height, width);
        subPanel.setLayout(new BoxLayout( subPanel, BoxLayout.Y_AXIS));
        mainPanel.add(subPanel);
        setVisible(true);

       addToTextView();
    }

    public void addOrderData()
    {
        TempDataList dataList=new TempDataList();
        java.util.List<Order> orderList=dataList.getAllOrders();
    }
    public void addOrderView(Order o)
    {
        JPanel orderPanel=new JPanel();
        orderPanel.setLayout(new GridLayout(2,1));

        JPanel generalInfo=new JPanel();
        JTextField customerField=new JTextField();
        customerField.setEditable(false);
        customerField.setText(o.getCustomer().getName()+ "  ");

        JTextField tableField=new JTextField();
        tableField.setEditable(false);
        tableField.setText( "  N" +o.getTable()+ "  ");
        generalInfo.add(customerField);
        generalInfo.add(tableField);

        java.util.List<OrderMenuItem> orderItemList=o.getOrderMenuItems();
        JPanel menuItemPanel=new JPanel();
        menuItemPanel.setLayout(new GridLayout(1,orderItemList.size()));
        for(int i=0;i<orderItemList.size();i++)
        {
            JPanel orderItem=new JPanel(new GridLayout(2,1));
            String orderItemName= orderItemList.get(i).getMenuItem().getMenuitemName();
            JTextField menuItemField=new JTextField(orderItemName);
            menuItemField.setEditable(false);
            double amount=orderItemList.get(i).getAmount();

            //menuItemField.setText(orderItemName);
            JTextField amountField=new JTextField(" "+amount);
            amountField.setEditable(false);

            orderItem.add(menuItemField);
            orderItem.add(amountField);
            menuItemPanel.add(orderItem);
        }
        orderPanel.add(generalInfo);
        orderPanel.add(menuItemPanel);
        subPanel.add(orderPanel);
    }
    public  void addToTextView()
    {
        TempDataList dataList=new TempDataList();
        java.util.List<Order> orderList=dataList.getAllOrders();
        String text="";
        for(int i=0;i<orderList.size();i++)
        {
         addOrderView(orderList.get(i));
        }
        validate();
        repaint();
    }

    public static void main(String[] args) {
     // OrderManagmentWindow omw=new OrderManagmentWindow();


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        addToTextView();
    }
}
