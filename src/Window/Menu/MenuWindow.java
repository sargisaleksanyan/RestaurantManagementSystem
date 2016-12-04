package Window.Menu;

import DataBaseManagment.DataList;
import Meal_Menu.*;
import Meal_Menu.MenuItem;
import Meal_Menu.MenuItemBuilder.Meal;

import javax.swing.*;

import java.awt.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sargis on 10/24/16.
 */
public class MenuWindow extends JFrame {

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
    private  java.util.List<MenuItem> menuItemList;
    private  JScrollPane jScrollPane;
    private  DataList dataList;
    public MenuWindow(double widthPercent,double heightPercent) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        int x = (int) (dim.width * widthPercent);
        int y = (int) (dim.height * heightPercent);
        this.setLocation(dim.width / 2 - x / 2, dim.height / 2 - y / 2);
        dim.setSize(x, y);
        setVisible(true);
        menuPanel=new JPanel();
        setLayout(new FlowLayout());
        setSize(dim);
        initButtons();
        setTitle("MenuItem");
        /*

         */
    }
    public void initButtons()
    {
        dishPanel =new JPanel();
        drinkPanel=new JPanel();
        saladPanel=new JPanel();

        categorizeMenuItems();

        //menuPanel.setLayout(new GridLayout(3,1));

        initializeMenu();

        jScrollPane=new JScrollPane(menuPanel);
        setContentPane(jScrollPane);
        //jScrollPane.setHorizontalScrollBar(new JScrollBar());
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        add(jScrollPane);
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
              //  JRadioButton jRadioButton=new JRadioButton();

                drinks.add(new JRadioButton(menuItem.getMenuitemName()+" | "+menuItem.getPrice()));
            }
            else if(menuItem.getMenuCategoryName().equals(MenuItemCategory.MAIN_DISH))
            {
                JRadioButton jradioButton=new JRadioButton();
                Meal m= (Meal) menuItem;
                if(m.getFoodType()!=null) {
                    if (m.getFoodType().equals(MenuItemCategory.VEAGAN)) {
                        jradioButton.setBackground(Color.GREEN);

                    } else if (m.getFoodType().equals(MenuItemCategory.MEAT)) {
                        jradioButton.setBackground(Color.GRAY);

                    }
                }

                    jradioButton.setText(menuItem.getMenuitemName() + " | " + menuItem.getPrice());
                    dishs.add(jradioButton);

            }
            else if(menuItem.getMenuCategoryName().equals(MenuItemCategory.SALAD))
            {
                JRadioButton jradioButton=new JRadioButton();
                Meal m= (Meal) menuItem;
                if(m.getFoodType()!=null) {
                    if (m.getFoodType().equals(MenuItemCategory.VEAGAN)) {
                        jradioButton.setBackground(Color.GREEN);

                    } else if (m.getFoodType().equals(MenuItemCategory.MEAT)) {
                        jradioButton.setBackground(Color.GRAY);

                    }
                }

                jradioButton.setText(menuItem.getMenuitemName() + " | " + menuItem.getPrice());
                dishs.add(jradioButton);
                salads.add(new JRadioButton(menuItem.getMenuitemName()+" | "+menuItem.getPrice()));
            }

        }
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
           dishPanel.add(dishs.get(i));
        }
        for(int i=0;i<drinks.size();i++)
        {
           drinkPanel.add(drinks.get(i));
        }
        for(int i=0;i<salads.size();i++)
        {
            saladPanel.add(salads.get(i));
        }
        menuPanel.add(dishPanel);
        menuPanel.add(drinkPanel);
        order=new JButton("Order");
        menuPanel.add(saladPanel);
        menuPanel.add(order);

        //jScrollPane.add(dishPanel);
       // jScrollPane.add(drinkPanel);
       // jScrollPane.add(saladPanel);

    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
      //  new MenuWindow();

    }

}
