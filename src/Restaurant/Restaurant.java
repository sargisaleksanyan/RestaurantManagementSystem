package Restaurant;

import Customer.CustomerWindow;

import DataBaseManagment.*;
import Window.MenuWindow;
import Window.MenuItemWindow;
import Window.OrderWindow;
import Window.SupplierWindow;
import Window.PurchaseWindow;
import Window.ItemsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant extends JFrame implements ActionListener {

	private final String name="Armenian Food";
	private JButton menu ;
	private JButton customer ;
	private JButton order;
	private JButton item;
	private JButton employee;
	private JButton supplier;
	private JButton storage;
	private JButton menuItem;
	private JPanel  menuPanel;
	public Restaurant()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.getHeight();
		int x=dim.width*5/10;
		int y=dim.height*8/10;
		this.setLocation(dim.width/2-x/2, dim.height/2-y/2);
		dim.setSize(x, y);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(dim);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(name);;
		initButtons();
	}
	public void initButtons()
	{
		menu    =new JButton("MenuItem");
		menu.setPreferredSize(new Dimension(150,40));
		customer=new JButton("Customers");
		customer.setPreferredSize(new Dimension(150,40));
		order   =new JButton("Orders");
		menuItem=new JButton("MenuItem");
        employee=new JButton("Empoyee");
		supplier=new JButton("Supplier");
		order.setPreferredSize(new Dimension(150,40));
		item    =new JButton("Items");
		storage=new JButton("Storage");
		item.setPreferredSize(new Dimension(150,40));
		menuPanel=new JPanel();
		menuPanel.setLayout(new GridLayout(8,1));
		menuPanel.add(menu);
		menuPanel.add(menuItem);
		menuPanel.add(storage);
		menuPanel.add(customer);
		menuPanel.add(order);
		menuPanel.add(item);
		menuPanel.add(employee);
		menuPanel.add(supplier);
		add(menuPanel);
		menuItem.addActionListener(this);
		item.addActionListener(this);
		customer.addActionListener(this);
		menu.addActionListener(this);
		order.addActionListener(this);
		employee.addActionListener(this);
		supplier.addActionListener(this);
		storage.addActionListener(this);
	}
	public static void main(String[] args) {

		new Restaurant();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(menu))
		{
			MenuWindow m=new MenuWindow();
		}
		else if(e.getSource().equals(customer))
		{
			CustomerWindow c=new CustomerWindow ();
		}
		else if(e.getSource().equals(item))
		{
			new ItemsWindow(new ItemDataBase(),0.3,0.7);
		}
		else if(e.getSource().equals(order))
		{
	     //OrderWindow orderWindow=new OrderWindow(new OrderDataBase());
		}
		else if(e.getSource().equals(supplier))
		{
			new SupplierWindow(new SupplierDataBase(),0.3,0.7);
		}
		else if(e.getSource().equals(storage))
		{
			new PurchaseWindow(new PurchaseItemDataBase(),0.3,0.7);
		}
		else if(e.getSource().equals(menuItem))
		{
			new MenuItemWindow(new MenuItemDataBase(),0.3,0.7);
		}
	}
}

