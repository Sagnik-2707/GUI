import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI1
{
	public static void main(String args[])
	{
		new Frame1("Admission Counter");
	}
}

class Frame1 implements ActionListener
{
	JFrame GUI1;
	JLabel lbl1,lbl2,lbl3,lbl4,result;
	JTextField cseCount, csbsCount;
	JButton btn1;
	Frame1(String s)
	{
		GUI1 = new JFrame(s);
		lbl1 = new JLabel("CSE Capacity : 120");
		lbl2 = new JLabel("CSBS Capacity : 60");
		lbl3 = new JLabel("CSE: ");
		cseCount = new JTextField(20);
		lbl4 = new JLabel("CSBS: ");
		csbsCount = new JTextField(20);
		btn1 = new JButton("Calculate");
		btn1.addActionListener(this);
		result = new JLabel();
		
		
		GUI1.setLayout(new GridBagLayout());
        	GridBagConstraints gbc = new GridBagConstraints();
        	gbc.insets = new Insets(10, 10, 10, 10);  // Padding between components
        
        // Add lbl1 at the top (row 0, column 0, spans 2 columns)
        	gbc.gridx = 0;
        	gbc.gridy = 0;
        	gbc.gridwidth = 2;
        	gbc.anchor = GridBagConstraints.CENTER; // Center alignment
        	GUI1.add(lbl1, gbc);

        // Add lbl2 (row 1, column 0, spans 2 columns)
        	gbc.gridx = 0;
        	gbc.gridy = 1;
        	gbc.gridwidth = 2;
        	GUI1.add(lbl2, gbc);

        // Add lbl3 and cseCount side by side (row 2)
        	gbc.gridwidth = 1; // Reset width to 1 for individual components
        	gbc.gridx = 0;
        	gbc.gridy = 2;
        	GUI1.add(lbl3, gbc);
        
        	gbc.gridx = 1;
        	GUI1.add(cseCount, gbc);

        // Add lbl4 and csbsCount side by side (row 3)
        	gbc.gridx = 0;
        	gbc.gridy = 3;
        	GUI1.add(lbl4, gbc);
        
        	gbc.gridx = 1;
        	GUI1.add(csbsCount, gbc);

        // Add btn1 at the bottom (row 4, spans 2 columns)
        	gbc.gridx = 0;
        	gbc.gridy = 4;
        	gbc.gridwidth = 2;
        	gbc.anchor = GridBagConstraints.CENTER;
        	GUI1.add(btn1, gbc);
        
        //Add result label at the bottom(row 5,spans 2 columns)	
        	gbc.gridx = 0;
        	gbc.gridy = 5;
        	gbc.gridwidth = 2;
        	GUI1.add(result,gbc);
        	
		GUI1.setSize(300,300);
		GUI1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI1.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String field1 = cseCount.getText();
		String field2 = csbsCount.getText();
		if(field1.isEmpty() || field2.isEmpty())
		{
			result.setText("Count(s) cannot be empty");
		}
		else
		{
			try
			{
				int n1 = Integer.parseInt(field1);
				int n2 = Integer.parseInt(field2);
				if(n1 < 0 || n2 < 0)
				{
					result.setText("Count(s) cannot be negative");
				}
				else if(n1 > 120 || n2 > 60)
				{
					result.setText("Count(s) exceed max capacity");
				}
				else
				{
					int sum = n1 + n2;
					String field3 = Integer.toString(sum);
					result.setText("Total Students: " +field3);
					cseCount.setEditable(false);
					csbsCount.setEditable(false);
				}
			}
			catch(Exception e)
			{
				result.setText("Count(s) should be a whole number");
			}
		}
	}
}
			
		
		
		
