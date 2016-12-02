package Window;
import DataBaseManagment.ItemDataBase;
import DataBaseManagment.DataList;
import Item.Item;
import Supplier.Supplier;


import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by sargis on 11/28/16.
 */
public class ItemsWindow extends Gui{


    private   JButton insertButton;
    private   java.awt.List listView;
    private   JTextField nameField;
    private   JTextField priceField;
    private   JTextField lifeTime;

    private   Supplier selectedSupplier;
    private    DataList dataList;
    private    HashMap<String,Supplier> supplerMap;
    public   ItemsWindow(ItemDataBase itemDataBase,double w,double h)
    {
        super(itemDataBase,w,h);
    }
   // function add new item to database

    public void setItemTextField()
    {
        listView=new java.awt.List();
        JPanel  itemPanel=new JPanel();
         supplerMap=new HashMap<String, Supplier>();
       
         JTextField name=new JTextField(" Name");
         name.setEditable(false);
         dataList=new DataList();
         itemPanel.setLayout(new GridLayout(8,1));
         nameField=new JTextField();
         insertButton=new JButton(" AddItem");
         priceField=new JTextField();
         JTextField price=new JTextField(" Price");
         price.setEditable(false);
         lifeTime=new JTextField();
         JTextField lifeTimeLabel=new JTextField("LifeTime");
         lifeTime=new JTextField();
         JTextField supplierFiled=new JTextField("Supllier");
         supplierFiled.setEditable(false);
         lifeTimeLabel.setEditable(false);
          List<Supplier> list=dataList.getAllSuppliers();
          getSuppliers(list);
          itemPanel.add(name);

         itemPanel.add(nameField);


         itemPanel.add(price);
         itemPanel.add(priceField);

         itemPanel.add(lifeTimeLabel);
         itemPanel.add(lifeTime);
         subPanel.add(itemPanel);

         itemPanel.add(supplierFiled);
         subPanel.add(listView);

         listView.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent itemEvent) {
                 int i= (int) itemEvent.getItem();

                     String s = listView.getItem(i);

                     selectedSupplier = supplerMap.get(s);

             }
         });

        itemPanel.add(insertButton);
         mainPanel.add( subPanel);
         insertButton.addActionListener(this);
         validate();
         mainPanel.repaint();
    }

    private void getSuppliers(List<Supplier> suppliers)
    {
        for(int i=0;i<suppliers.size();i++)
        {
            String str=suppliers.get(i).getName()+"  "+suppliers.get(i).getPhone();
         //   strings.add(str);
            listView.add(str);
            supplerMap.put(str,suppliers.get(i));
        }
      //  return strings;
    }



    public void clearTextFields() {
        nameField.setText("");
        priceField.setText("");
        lifeTime.setText("");
    }
    @Override
    public void insert()
    {
        String name= nameField.getText().toString();
        double price= Double.parseDouble(priceField.getText().toString());
        int lifeSpan=Integer.parseInt(lifeTime.getText().toString());
        Item item=new Item(name,price,lifeSpan);

        if(selectedSupplier==null)
        {
            if(db.insert(item))
            {
                clearTextFields();
            }
        }
       else
        {
             item.setSupplier(selectedSupplier);
             db.insert(item);
            //clearTextFields();
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
