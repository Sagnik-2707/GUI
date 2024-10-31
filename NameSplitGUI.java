import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI4
{
	public static void main(String args[])
	{
		new Frame4("Name Details");
	}
}

class Frame4 implements ActionListener
{
	JFrame GUI4;
	JLabel name, f_name,m_name,l_name;
	JTextField full_name, first_name,middle_name,last_name;
	JButton btn1;
	
	Frame4(String s)
	{
		GUI4 = new JFrame(s);
		name = new JLabel("Full Name:");
		f_name = new JLabel("First Name:");
		m_name = new JLabel("Middle Name:");
		l_name = new JLabel("Last Name:");
		full_name = new JTextField(20);
		first_name = new JTextField(20);
		first_name.setEditable(false);
		middle_name = new JTextField(20);
		middle_name.setEditable(false);
		last_name = new JTextField(20);
		last_name.setEditable(false);
		btn1 = new JButton("Split Name");
		btn1.addActionListener(this);
		
		GUI4.add(name);
		GUI4.add(full_name);
		GUI4.add(f_name);
		GUI4.add(first_name);
		GUI4.add(m_name);
		GUI4.add(middle_name);
		GUI4.add(l_name);
		GUI4.add(last_name);
		GUI4.add(btn1);
		GUI4.setLayout(new FlowLayout());
		GUI4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI4.setVisible(true);
		GUI4.setSize(300,300);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String field = full_name.getText().trim();
		field = field + " ";
		int l = field.length();
		String a = "";
		ArrayList<String> al = new ArrayList<> ();
		char c;
		for(int i=0;i<l;i++)
		{
			c = field.charAt(i);
			if(Character.isDigit(c) == true || c == '.')
			{
				JOptionPane.showMessageDialog(GUI4, "Invalid name entered");
				System.exit(0);
			}
			if(c != ' ')
			{
				a = a + c;
			}
			else
			{
				al.add(a);
				a="";
			}
		
		}
		if (al.size()  == 1) 
			first_name.setText(al.get(0));
    		else if (al.size() == 2)
    		{	
    			first_name.setText(al.get(0));
    			last_name.setText(al.get(1));
    		}
    		else if (al.size() == 3) 
    		{
    			first_name.setText(al.get(0));
    			middle_name.setText(al.get(1));
    			last_name.setText(al.get(2));
		}
		else
		{
			JOptionPane.showMessageDialog(GUI4, "Invalid name entered");
		}
		full_name.setEditable(false);
	}
}
	
