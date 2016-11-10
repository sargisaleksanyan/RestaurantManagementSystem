package meal_menu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ItemWindow  extends JFrame implements ActionListener{
    private JButton addItem;
    private JButton findItem;
    private JPanel menuPanel;
    private JPanel tablePanel;
    private JPanel textFields;

    private JTextField jName;
    private JTextField  price;
    private JTextField  expirationDate;
    private JTextField  jNumberAvailable;
    public ItemWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        int x = dim.width * 3 / 10;
        int y = dim.height * 9 / 10;
        this.setLocation(dim.width / 2 - x / 2, dim.height / 2 - y / 2);
        dim.setSize(x, y);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(dim);
        initlizButton();
        setTitle("Item");

    }


    public void initlizButton()
    {
        menuPanel=new JPanel();
        addItem =new JButton("Add");
        addItem.setPreferredSize(new Dimension(150,40));
        findItem=new JButton("Find");
        findItem.setPreferredSize(new Dimension(150,40));
        findItem.setPreferredSize(new Dimension(150,40));
        menuPanel.setLayout(new GridLayout(3,1));
        tablePanel=new JPanel();
        menuPanel.add(addItem);
        menuPanel.add(findItem);
        menuPanel.add(tablePanel);
        add(menuPanel);
        addItem.addActionListener(this);
        findItem.addActionListener(this);
    }
    public void addTable()
    {

        Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
                { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
        Object columnNames[] = { "Column One", "Column Two", "Column Three" };
        JTable table = new JTable(rowData, columnNames);
        table.setPreferredSize(new Dimension(300,40));

        //  tablePanel.add(table);
        add(table);
        validate();
    }
    public static void main(String[] args) {

        new ItemWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addItem))
        {

            addTable();

        }
        else if (e.getSource().equals(findItem))
        {

            validate();

        }
    }
}