package Window.Menu;

import Customer.Customer;
import DataBaseManagment.*;
import Meal_Menu.*;
import Meal_Menu.MenuItem;
import Meal_Menu.MenuItemBuilder.Meal;

import javax.swing.*;

import java.awt.*;
import Order.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuWindow extends JFrame implements ActionListener{

    protected int xCord;
    protected int yCord ;
    protected int width;
    protected int height ;
    private  JPanel  menuPanel;
    private  JPanel  dishPanel;
    private  JPanel  drinkPanel;
    private  JPanel saladPanel;
    private  JButton order;
    private  List<JRadioButton> dishs;
    private  List<JRadioButton> salads;
    private  List<JRadioButton> drinks;
    JTextField orderDate;
    private  java.util.List<MenuItem> menuItemList;
    private  JScrollPane jScrollPane;
    private  DataList dataList;
    private HashMap<JRadioButton,MenuItem> menuItemButtonMap;
    private HashMap<JRadioButton,JTextField> radioToText;
    private Customer customer;
    private JTextField tableField;
    private TemporaryOrderDataBase orderDataBase;
    public MenuWindow(Customer customer,double widthPercent, double heightPercent)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        this.customer=customer;
        menuItemButtonMap=new HashMap<>();
        radioToText=new HashMap<>();
        tableField=new JTextField();
        orderDate=new JTextField();
        int x = (int) (dim.width * widthPercent);
        int y = (int) (dim.height * heightPercent);
        this.setLocation(dim.width / 2 - x / 2, dim.height / 2 - y / 2);
        dim.setSize(x, y);
        setVisible(true);
        menuPanel=new JPanel();
        setLayout(new FlowLayout());
        setSize(dim);
        initButtons();
         orderDataBase=new TemporaryOrderDataBase();
        setTitle("MenuItem");
    }
    public void initButtons()
    {
        dishPanel =new JPanel();
        drinkPanel=new JPanel();
        saladPanel=new JPanel();
        categorizeMenuItems();
        initializeMenu();
        jScrollPane=new JScrollPane(menuPanel);
        setContentPane(jScrollPane);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        menuPanel.setBounds(xCord, 0, height, width);
        menuPanel.setLayout(new BoxLayout( menuPanel, BoxLayout.Y_AXIS));
        validate();
    }
    public void categorizeMenuItems()
    {

        dishs=new ArrayList<>();
        salads=new ArrayList<>();
        drinks=new ArrayList<>();
        dataList=new DataList();
        menuItemList=new ArrayList<>();
        menuItemList=dataList.getAllMenuItems();
        for(int i=0;i<menuItemList.size();i++)
        {
            MenuItem menuItem=menuItemList.get(i);
            if(menuItem.getMenuCategoryName().equals(MenuItemCategory.DRINK))
            {
                JRadioButton jRadioButton=new JRadioButton(menuItem.getMenuitemName());
                menuItemButtonMap.put(jRadioButton,menuItem);
                drinks.add(jRadioButton);
            }
            else if(menuItem.getMenuCategoryName().equals(MenuItemCategory.MAIN_DISH))
            {
                JRadioButton jradioButton=new JRadioButton();
                Meal m= (Meal) menuItem;
                menuItemButtonMap.put(jradioButton,menuItem);
                jradioButton.setText(menuItem.getMenuitemName());
                dishs.add(jradioButton);

            }
            else if(menuItem.getMenuCategoryName().equals(MenuItemCategory.SALAD))
            {
                JRadioButton jradioButton=new JRadioButton();
                Meal m= (Meal) menuItem;


                jradioButton.setText(menuItem.getMenuitemName());

                menuItemButtonMap.put(jradioButton,menuItem);
                salads.add(jradioButton);

            }

        }
    }
    public JPanel makeMenuItemPanel(JRadioButton radioButton)
    {
        JPanel jPanel=new JPanel(new GridLayout(1,4));

        jPanel.add(radioButton);
        Meal meal= (Meal) menuItemButtonMap.get(radioButton);
        JTextField jTextField=new JTextField(meal.getPrice()+" $ ");
        jTextField.setEditable(false);
        if(meal.getFoodType()!=null) {
            if (meal.getFoodType().equals(MenuItemCategory.MEAT)) {
                Icon icon = new ImageIcon("tbone.jpg");
                radioButton.setIcon(icon);
            } else if (meal.getFoodType().equals(MenuItemCategory.VEAGAN)) {
                radioButton.setBackground(Color.GREEN);
            }
        }

        jPanel.add(radioButton);

        jPanel.add(jTextField);
        JTextField jtext=new JTextField();
        //jtext.setB
        jPanel.add(jtext);
        radioToText.put(radioButton,jtext);
        return jPanel;
    }


    public void initializeMenu()
    {
        dishPanel.setLayout(new GridLayout(dishs.size()+1,1));
        drinkPanel.setLayout(new GridLayout(drinks.size()+1,1));
        saladPanel.setLayout(new GridLayout(salads.size()+1,1));
        JTextField dishLabel=new JTextField("Dish");
        dishLabel.setEditable(false);
        JTextField drinkLabel=new JTextField("Drink");
        drinkLabel.setEditable(false);
        JTextField saladLabel=new JTextField("Salad");
        saladLabel.setEditable(false);
        dishPanel.add(dishLabel);
        drinkPanel.add(drinkLabel);
        saladPanel.add(saladLabel);
        for(int i=0;i<dishs.size();i++)
        {
            dishPanel.add(makeMenuItemPanel(dishs.get(i)));
        }

        for(int i=0;i<drinks.size();i++)
        {


            drinkPanel.add(makeMenuItemPanel(drinks.get(i)));

        }
        for(int i=0;i<salads.size();i++)
        {
            //saladPanel.add(new JTextField());
            saladPanel.add(makeMenuItemPanel(salads.get(i)));

        }

        menuPanel.add(dishPanel);
        menuPanel.add(drinkPanel);
        order=new JButton("Order");
        order.addActionListener(this);
        menuPanel.add(saladPanel);
        JTextField tableLabel=new JTextField("Table");
        tableLabel.setEditable(false);
        JTextField  dateLabel=new JTextField("Date");
        dateLabel.setEditable(false);
        menuPanel.add(tableLabel);
        menuPanel.add(tableField);
        menuPanel.add(dateLabel);
        menuPanel.add(orderDate);
        menuPanel.add(order);



    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
      //  new MenuWindow();

    }

    public void insert()
    {
        Order order=new Order();
        String date=orderDate.getText().toString();
        if(date.equals(""))
        {
            date=CurrentTime.getTime();
        }
        order.setCustomer(customer);
        order.setOrderDate(date);
        int tableNumber=Integer.parseInt(tableField.getText().toString());
        order.setTable(tableNumber);
        order.approved=0;
        for(int i=0;i<dishs.size();i++)
        {
            if(dishs.get(i).isSelected())
            {
               //private HashMap<JRadioButton,MenuItem> menuItemButtonMap;
               //private HashMap<JRadioButton,JTextField> radioToText;
                MenuItem mi=menuItemButtonMap.get(dishs.get(i));
                String amount=radioToText.get(dishs.get(i)).getText().toString();
                int quntity=1;
                if(!amount.equals("")) {
                    quntity = Integer.parseInt(amount);
                }
                OrderMenuItem orderMenuItem=new OrderMenuItem(mi,quntity);
                order.addItem(orderMenuItem);
            }

        }
        for(int i=0;i<drinks.size();i++)
        {
            if(drinks.get(i).isSelected()) {
                MenuItem mi = menuItemButtonMap.get(dishs.get(i));
                String amount = radioToText.get(dishs.get(i)).getText().toString();
                int quntity = 1;
                if (!amount.equals("")) {
                    quntity = Integer.parseInt(amount);
                }
                OrderMenuItem orderMenuItem = new OrderMenuItem(mi, quntity);
                order.addItem(orderMenuItem);
            }
        }
        for(int i=0;i<salads.size();i++) {
            if (salads.get(i).isSelected()) {
                MenuItem mi = menuItemButtonMap.get(dishs.get(i));
                String amount = radioToText.get(dishs.get(i)).getText().toString();
                int quntity = 1;
                if (!amount.equals("")) {
                    quntity = Integer.parseInt(amount);
                }
                OrderMenuItem orderMenuItem = new OrderMenuItem(mi, quntity);
                order.addItem(orderMenuItem);
            }
        }
        orderDataBase.insert(order);
        Order resultedOrder=orderDataBase.getOrder(customer.getCustomerId(),date);
        order.setOrderId(resultedOrder.getOrderId());
        TemporaryOrderItemDataBase  orderItemDataBase=new  TemporaryOrderItemDataBase();
        orderItemDataBase.insert(order);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         insert();
    }
}
