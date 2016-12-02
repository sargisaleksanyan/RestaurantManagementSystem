package Window;

import DataBaseManagment.EntityDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sargis on 11/29/16.
 */
public abstract  class Gui extends JFrame implements ActionListener {
    protected int xCord;
    protected int yCord ;
    protected int width;
    protected int height ;
    protected JPanel mainPanel;
    protected JButton addButton;
    protected JButton removeButton;
    protected JButton modifyButton;
    protected JPanel subPanel;
    protected EntityDataBase db;
    public Gui(EntityDataBase db, double w, double h)
    {
        this.db=db;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) (dim.width *w);
        height  =(int) (dim.height * h);
        xCord=dim.width / 2 - width / 2;
        yCord=dim.height / 2 - height  / 2;
        this.setLocation(xCord, yCord);
        dim.setSize(width,height);
        setVisible(true);
        mainPanel=new JPanel();
        setContentPane(mainPanel);
        setSize(dim);
        setButtons();

    }
    public abstract void insert();

    public void setButtons() {
        subPanel=new JPanel();
        JPanel first=new JPanel();
        first.setLayout(new GridLayout(3,1));
        addButton=new JButton("Add");
        removeButton=new JButton("Remove");
        modifyButton=new JButton("Modify");
        first.add(addButton);
        first.add(removeButton);
        first.add(modifyButton);
        subPanel.setBounds(xCord, 0, height, width);
        subPanel.setLayout(new BoxLayout( subPanel, BoxLayout.Y_AXIS));
        subPanel.add(first);
        mainPanel.add(subPanel);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        modifyButton.addActionListener(this);
        validate();
        mainPanel.repaint();
    }
    public void setAddButton(String text)
    {
        addButton.setText(text);
    }
    public void setremoveButtonButton(String text)
    {
        addButton.setText(text);
    }
    public void setModifyButton(String text)
    {
        modifyButton.setText(text);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }

}
