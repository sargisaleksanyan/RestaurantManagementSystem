package Restaurant;

import Customer.CustomerWindow;
import meal_menu.MenuWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Restaurant extends JFrame implements ActionListener {
   
	private final String name="Armenian Food";
	private JButton menu ;
	private JButton customer ;
	private JButton order;
	private JButton item;
	private JPanel  menuPanel;
	public Restaurant()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.getHeight();
		int x=dim.width*8/10;
		int y=dim.height*9/10;
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
		menu    =new JButton("Menu");
		menu.setPreferredSize(new Dimension(150,40));
		customer=new JButton("Customers");

		customer.setPreferredSize(new Dimension(150,40));
		order   =new JButton("Orders");
	    order.setPreferredSize(new Dimension(150,40));
		item    =new JButton("Items");
		item.setPreferredSize(new Dimension(150,40));
		menuPanel=new JPanel();
		menuPanel.setLayout(new GridLayout(4,1));
		menuPanel.add(menu);
		menuPanel.add(customer);
		menuPanel.add(order);
		menuPanel.add(item);
		add(menuPanel);
		customer.addActionListener(this);
		menu.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           new Restaurant();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection mycon= DriverManager.getConnection("jdbc:mysql://95.140.195.69:3306/A09155126","A09155126","A09155126");
			Statement myStmt=mycon.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from Product where productTitle='Rice'");
			while(myRs.next())
			{
				System.out.println(myRs.getString("productTitle")+myRs.getString("sellPrice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//'A09155126@37.157.220.18'
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
	}
}
