package Window;

import DataBaseManagment.TempDataList;
import DataBaseManagment.TemporaryOrderDataBase;
import Order.Order;
import  Order.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class EmployeeOrdersWindow extends JFrame implements ActionListener {
    protected int xCord;
    protected int yCord ;
    protected int width;
    protected int height ;
    protected JPanel mainPanel;
    private int orderCount=0;
    private  JScrollPane jScrollPane;
    private  JButton approveButton;
    private  JButton refreshButton;

    HashMap<JRadioButton,Order> buttonOrderHashMap;

    public EmployeeOrdersWindow(double w, double h)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        //this.customer=customer;
        width = (int) (dim.width * w);
        height  = (int) (dim.height * h);
        xCord=dim.width / 2 - width / 2;
        yCord=dim.height / 2 - height  / 2;
        this.setLocation(xCord, yCord);
        dim.setSize(width,height);
        buttonOrderHashMap=new HashMap<>();
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(dim);
        setVisible(true);
        initlizeView();
        addToTextView();
    }
    public void initlizeView()
    {

        JPanel buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1));


        mainPanel=new JPanel();
        setContentPane(mainPanel);
        /// subPanel=new JPanel();
        mainPanel.setBounds(xCord, 0, height, width);
        mainPanel.setLayout(new BoxLayout( mainPanel, BoxLayout.Y_AXIS));
//       mainPanel.add(mainPanel);

        jScrollPane=new JScrollPane(mainPanel);
        setContentPane(jScrollPane);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }
    public void addOrderData()
    {
        TempDataList dataList=new TempDataList();
        java.util.List<Order> orderList=dataList.getAllOrders();
    }
    public void addOrderView(Order o)
    {
        // JPanel orderPanel=new JPanel();
        // orderPanel.setLayout(new GridLayout(2,1));

        JPanel generalInfo=new JPanel();
        JTextField customerField=new JTextField();
        customerField.setEditable(false);
        customerField.setText(o.getCustomer().getName()+ "  ");
        generalInfo.setLayout(new GridLayout(1,3));
        JTextField tableField=new JTextField();
        tableField.setEditable(false);
        tableField.setText( "  N" +o.getTable()+ "  ");
        generalInfo.add(customerField);
        generalInfo.add(tableField);

        java.util.List<OrderMenuItem> orderItemList=o.getOrderMenuItems();
        JPanel menuItemPanel=new JPanel();
        menuItemPanel.setLayout(new GridLayout(orderItemList.size(),1));
        for(int i=0;i<orderItemList.size();i++)
        {

            JPanel orderItem=new JPanel(new GridLayout(1,3));
            String orderItemName= orderItemList.get(i).getMenuItem().getMenuitemName();
            JTextField menuItemField=new JTextField(orderItemName);
            menuItemField.setEditable(false);
            double amount=orderItemList.get(i).getAmount();

            //menuItemField.setText(orderItemName);
            JTextField amountField=new JTextField(" "+(int)amount);
            amountField.setEditable(false);

            orderItem.add(menuItemField);
            orderItem.add(amountField);
            menuItemPanel.add(orderItem);
        }
        // orderPanel.add(generalInfo);
        //orderPanel.add(menuItemPanel);
        JRadioButton jRadioButton=new JRadioButton("Approve");
        buttonOrderHashMap.put(jRadioButton,o);
        mainPanel.add(generalInfo);
        mainPanel.add(menuItemPanel);
        mainPanel.add(jRadioButton);
    }
    public  void addToTextView()
    {
        TempDataList dataList=new TempDataList();
        java.util.List<Order> orderList=dataList.getAllOrders();
        String text="";
        if(orderCount!=orderList.size()) {
            for (int i = orderCount; i < orderList.size(); i++) {
                if(orderList.get(i).approved==1) {
                    addOrderView(orderList.get(i));
                }
            }
            orderCount=orderList.size();
        }
        validate();
        repaint();
    }

    public static void main(String[] args) {
        // EmployeeOrdersWindow omw=new EmployeeOrdersWindow();


    }
    public void approve()
    {
        TemporaryOrderDataBase tdb=new TemporaryOrderDataBase();

        Set<JRadioButton> radioButtons= buttonOrderHashMap.keySet();
        Iterator<JRadioButton> iterator=radioButtons.iterator();
        while(iterator.hasNext())
        {
            JRadioButton radioButton=iterator.next();
            Order o=buttonOrderHashMap.get(radioButton);
            if(radioButton.isSelected()) {

                tdb.approve(buttonOrderHashMap.get(o));
                orderCount--;
            }

        }
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // addToTextView();
        if(actionEvent.getSource().equals(approveButton))
        {
            approve();
        }
        else if(actionEvent.getSource().equals(refreshButton))
        {
            addToTextView();
        }
    }
}
