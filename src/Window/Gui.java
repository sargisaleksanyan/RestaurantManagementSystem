package Window;

import DataBaseManagment.DataBase;

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
    protected JPanel subPanel;
    protected DataBase db;
    public Gui(DataBase db,double w,double h)
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
        setTitle("Item");
    }
    public abstract void insert();
    public abstract void setButtons();
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }

}
