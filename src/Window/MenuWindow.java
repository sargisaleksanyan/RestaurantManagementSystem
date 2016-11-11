package Window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sargis on 10/24/16.
 */
public class MenuWindow extends JFrame {

    private JButton dish;
    private JButton salad;
    private JButton drink;
    private JPanel  menuPanel;
    public MenuWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        int x = dim.width * 7 / 10;
        int y = dim.height * 9 / 10;
        this.setLocation(dim.width / 2 - x / 2, dim.height / 2 - y / 2);
        dim.setSize(x, y);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(dim);
        initButtons();
        setTitle("Menu");
    }
    public void initButtons()
    {
        dish    =new JButton("Dish");
        dish.setPreferredSize(new Dimension(150,40));
        salad=new JButton("Salad");
        salad.setIcon(new ImageIcon("salad.jpeg"));
        drink=new JButton("Drink");
        salad.setPreferredSize(new Dimension(150,40));
        drink.setPreferredSize(new Dimension(150,40));
        menuPanel=new JPanel();
        menuPanel.setLayout(new GridLayout(4,1));
        menuPanel.add(dish);
        menuPanel.add(salad);
        menuPanel.add(drink);
        add(menuPanel);

    }


    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        new MenuWindow();

    }

}
