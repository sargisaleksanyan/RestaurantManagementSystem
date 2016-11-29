package Window;
import DataBaseManagment.ItemDataBase;
import Item.Item;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by sargis on 11/28/16.
 */
public class ItemsWindow extends Gui{


    private   JButton insertButton;
    private   JButton addButton;
    private   JButton addToStore;
    private   JButton removeFromStore;
    private   JTextField nameField;
    private   JTextField priceField;
    private   JTextField lifeTime;
    private   JSpinner supplier;

    public ItemsWindow(ItemDataBase itemDataBase,double w,double h)
    {
        super(itemDataBase,w,h);
    }
   // function add new item to database
    public void setItemTextField()
    {

         JPanel  itemPanel=new JPanel();
         JLabel nameLabel=new JLabel("Name");
         itemPanel.setLayout(new GridLayout(5,1));
         nameField=new JTextField();
         insertButton=new JButton("AddItem");
         JLabel priceLabel=new JLabel("Price");
         priceField=new JTextField();

         JLabel  lifeLabel=new JLabel("LifeTime");
         lifeTime=new JTextField();

         JLabel supplierLabel=new JLabel("Supplier");
         String []str={"Mush","Atenq","Bari Samaraci"};
         SpinnerListModel model=new SpinnerListModel(str);
         supplier=new JSpinner(model);

         itemPanel.add(nameLabel);
         itemPanel.add(nameField);

         itemPanel.add(priceLabel);
         itemPanel.add(priceField);

         itemPanel.add(lifeLabel);
         itemPanel.add(lifeTime);

         itemPanel.add(supplierLabel);
         itemPanel.add(supplier);
         itemPanel.add(insertButton);
         subPanel.add(itemPanel);
         mainPanel.add( subPanel);
         insertButton.addActionListener(this);
         validate();
         mainPanel.repaint();
    }
   
  public void setButtons()
  {
      subPanel=new JPanel();
      JPanel first=new JPanel();
      first.setLayout(new GridLayout(4,1));
      addButton=new JButton("Add");
      addToStore=new JButton("Remove");
      removeFromStore=new JButton("AddStore");
      addButton.addActionListener(this);
      first.add(addButton);
      first.add(addToStore);
      first.add(removeFromStore);
      subPanel.setBounds(xCord, 0, height, width);
      subPanel.setLayout(new BoxLayout( subPanel, BoxLayout.Y_AXIS));
      subPanel.add(first);
      mainPanel.add(subPanel);
      validate();
      mainPanel.repaint();
  }

    public static void main(String[] args) {

    }
    public void clearTextFields()
    {
        nameField.setText("");
        priceField.setText("");
        lifeTime.setText("");
    }
    @Override
    public void insert() {
        String name= nameField.getText().toString();
        double price= Double.parseDouble(priceField.getText().toString());
        int lifeSpan=Integer.parseInt(lifeTime.getText().toString());
        Item item=new Item(name,price,lifeSpan);
        if(db.insert(item))
        {
            clearTextFields();
        }

    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource()==addButton)
        {
            setItemTextField();
        }
        else if(ev.getSource()==insertButton)
        {
            insert();
        }

    }
}
