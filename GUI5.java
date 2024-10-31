import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI5 
{
    public static void main(String args[])
    {
        new Frame5("Somethin random");
    }   
}
class Frame5 
{
    JFrame GUI5;
    JLabel lbl;
    Frame5(String s)
    {
       GUI5 = new JFrame(s);
       lbl = new JLabel("Hello World!");
       lbl.setBounds(100,50,200,50);
       GUI5.add(lbl);
       GUI5.setSize(300 ,300);
       GUI5.setLayout(null);
       GUI5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       GUI5.setVisible(true); 
    }
}