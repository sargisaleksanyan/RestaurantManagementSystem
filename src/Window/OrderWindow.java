package Window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sargis on 11/28/16.
 */
public class OrderWindow extends JFrame {
   protected int xCord;
   protected int yCord ;
   protected int width;
   protected int height ;
    public OrderWindow()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        width = dim.width * 4/ 10;
        height  = dim.height * 8 / 10;
        xCord=dim.width / 2 - width / 2;
        yCord=dim.height / 2 - height  / 2;
        this.setLocation(xCord, yCord);
        dim.setSize(width,height);
        setVisible(true);
        // setLayout(new FlowLayout());
        setSize(dim);
        setVisible(true);
        setContentPane(getJContentPane());
    }
  private JPanel getJContentPane()
  {
    JPanel  jContentPane = new JPanel();
      jContentPane.setLayout(null);

      JPanel panel = new JPanel();

      panel.setBounds(xCord/2, 0, height, width);
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      jContentPane.add(panel);

      JCheckBox c1 = new JCheckBox("Check1");
      panel.add(c1);
      c1 = new JCheckBox("Check2");
      panel.add(c1);
      c1 = new JCheckBox("Check3");
      panel.add(c1);
      c1 = new JCheckBox("Check4");
      panel.add(c1);

      return  jContentPane;
  }


    public static void main(String[] args) {
        new OrderWindow();
    }
}
