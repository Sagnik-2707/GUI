import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumOfDigitsGUI
{
	public static void main(String args[])
	{
		new Frame6("Sum of Digits");
	}
}

class Frame6 implements ActionListener
{
	JFrame GUI6;
	JLabel lbl1,lbl2;
	JTextField number,sum;
	JButton btn1;
	Frame6(String s)
	{
		GUI6 = new JFrame(s);
		lbl1 = new JLabel("Entered number: ");
		lbl2 = new JLabel("Sum of digits: ");
		number = new JTextField(20);
		sum = new JTextField(20);
		sum.setEditable(false);
		btn1 = new JButton("Calculate");
		btn1.addActionListener(this);
		
		GUI6.add(lbl1);
		GUI6.add(number);
		GUI6.add(lbl2);
		GUI6.add(sum);
		GUI6.add(btn1);
		GUI6.setSize(300,300);
		GUI6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI6.setLayout(new FlowLayout());
		GUI6.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String field = number.getText();
		int num,d;
		int s=0;
		if(field.isEmpty())
		{
			JOptionPane.showMessageDialog(GUI6, "Field cannot be left empty");
		}
		else
		{
			try
			{
				num = Integer.parseInt(field);
				int a = num;
				while(a>0)
				{
					d=a%10;
					s=s+d;
					a=a/10;
				}
				sum.setText(Integer.toString(s));
				number.setEditable(false);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(GUI6, "An integer has to be entered");
			}
		}
	}
}
