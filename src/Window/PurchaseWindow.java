package Window;

import DataBaseManagment.EntityDataBase;
import DataBaseManagment.DataList;


import javax.swing.*;
import Item.Item;
import Item.PurchasedItem;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;



public class PurchaseWindow extends Gui {



    private java.awt.List listView;
    private JTextField dateFiled;
    private JTextField amountFiled;
    private  HashMap<String,Item> itemMap;
    private  DataList dataList;
    private  Item selectedItem;
    private  int itemIndex;
    private  JButton insertButton;
    public PurchaseWindow(EntityDataBase db, double w, double h)
    {
        super(db, w, h);
    }
    public void clearFileds()
    {
        dateFiled.setText("");
        amountFiled.setText("");
        listView.deselect(itemIndex);
    }
    @Override
    public void insert() {
        String date=dateFiled.getText().toString();
        int amount=Integer.parseInt(amountFiled.getText().toString());
        PurchasedItem purchasedItem=new PurchasedItem(date,amount);
        purchasedItem.setCurrentAmount(amount);
        purchasedItem.setItem(selectedItem);
        if(db.insert(purchasedItem))
        {
          clearFileds();
        }
    }
    public void setItemField()
    {
        listView=new List();
        JPanel  itemPanel=new JPanel();
        itemPanel.setLayout(new GridLayout(6,1));
        itemMap=new HashMap<String, Item>();
        dataList=new DataList();

        JTextField date=new JTextField("Date Y/M/D");
        date.setEditable(false);
        dateFiled=new JTextField();

        amountFiled=new JTextField();
        JTextField amount=new JTextField(" Amount");
        amount.setEditable(false);

        insertButton=new JButton("Buy");
        JTextField itemField=new JTextField("Item");
        itemField.setEditable(false);

        java.util.List<Item> list=dataList.getAllItems();
        listItems(list);

        itemPanel.add(date);
        itemPanel.add(dateFiled);


        itemPanel.add(amount);
        itemPanel.add(amountFiled);

        subPanel.add(itemPanel);
        subPanel.add(listView);
        itemPanel.add(itemField);
        subPanel.add(listView);
        // itemPanel.add(listView);
        listView.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                itemIndex= (int) itemEvent.getItem();

                String s = listView.getItem(itemIndex);
                selectedItem = itemMap.get(s);

            }
        });
        //  subPanel.add(insertButton);
        itemPanel.add(insertButton);
        mainPanel.add( subPanel);
        insertButton.addActionListener(this);
        validate();
        mainPanel.repaint();
    }
    public void listItems(java.util.List<Item> items)
    {
        for(int j=0;j<items.size();j++)
        {
            String it =items.get(j).getItemName();
            //int id=items.get(j).getItemId();
            itemMap.put(it,items.get(j));
            listView.add(it);
        }

    }

    @Override
    public void actionPerformed(ActionEvent a) {
       if(a.getSource()==addButton)
       {
          setItemField();
       }
       else if(a.getSource()==insertButton)
       {
         insert();
       }
    }
}
