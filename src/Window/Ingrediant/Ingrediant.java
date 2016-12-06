package Window.Ingrediant;
import Item.Item;
import DataBaseManagment.DataList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Ingrediant implements ActionListener{

    public java.awt.List itemList;
    public DataList dataList;
    public JButton  addButton;
    public JButton  finishButton;

    public Ingrediant(JPanel jpanel)
    {
        dataList=new DataList();
        itemList=new java.awt.List();
        List<Item> items= dataList.getAllItems();
        addItemsList(items);
        jpanel.add(itemList);
        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(2,1));
        JTextField jLabel=new JTextField();
        jLabel.setText("Amount");
        jLabel.setEditable(false);
        jp.add(new JTextField());
        jpanel.add(jLabel);
        jpanel.add(jp);

    }
    public void addItemsList(java.util.List<Item> items)
    {
        for(int i=0;i<items.size();i++)
        {
            itemList.add(items.get(i).getItemName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
