package Restaurant.FrontPage;

import Restaurant.*;

import javax.swing.*;
import java.awt.event.ActionListener;


public  interface    FrontPage extends   ActionListener {


     public  void initlizeView(JPanel jPanel);
      public void setEntity(Entity entity);
}
