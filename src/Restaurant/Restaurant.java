package Restaurant;

import DataBaseManagment.*;
import Restaurant.FrontPage.FrontPage;
import Restaurant.FrontPage.ManagerPage;
import Restaurant.SignInPage.EmployeeSignIn;
import Restaurant.SignInPage.SignInPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant extends JFrame implements ActionListener {

	private final String name="Armenian Food";
    private JButton managerButton;
	private JButton customerButton;
	private JButton employeeButton;
	private JPanel  buttonsPanel;
	private JPanel mainPage;
	private JButton signInButton;
	private SignInPage signInPage;
	private FrontPage frontPage;
	public static boolean isManagerClciked=false;
	public Restaurant()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.getHeight();
		int x=dim.width*4/10;
		int y=dim.height*7/10;
		this.setLocation(dim.width/2-x/2, dim.height/2-y/2);
		dim.setSize(x, y);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(dim);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(name);
		mainPage=new JPanel();
	//	initButtons();
		initButtons();
	}
	public void initButtons()
	{
	    buttonsPanel=new JPanel();
		buttonsPanel.setLayout(new GridLayout(3,1));
		customerButton=new JButton("Customer");
		managerButton= new JButton("Manager");
		employeeButton=new JButton("Empoyee");
		managerButton.addActionListener(this);
		customerButton.addActionListener(this);
		employeeButton.addActionListener(this);
		buttonsPanel.add(managerButton);
		buttonsPanel.add(customerButton);
		buttonsPanel.add(employeeButton);
		add(buttonsPanel);

		validate();
	}

	public static void main(String[] args) {

		new Restaurant();

	}
    public void setSignIn()
	{
		remove(buttonsPanel);

		signInButton=new JButton("Sign in");
		signInButton.addActionListener(this);
		add(mainPage);
		mainPage.add(signInButton);
		repaint();
		validate();
	}
	public void setView()
	{

	}
	@Override
	public void actionPerformed(ActionEvent e) {
      if(e.getSource()==managerButton)
	  {
		  signInPage=new EmployeeSignIn(new EmployeeDataBase(),mainPage);
		  isManagerClciked=false;
		  frontPage=new ManagerPage();
          setSignIn();
	  }
	  else if(e.getSource()==signInButton)
	  {

		if (signInPage.getEntity()!=null)
		{
			remove(mainPage);
			mainPage=null;
			mainPage=new JPanel();
			validate();
			frontPage.initlizeView(mainPage);
			add(mainPage);
			validate();
			repaint();
		}


	  }
	}
}

