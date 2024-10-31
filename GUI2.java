import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI2
{
	public static void main(String args[])
	{
		new Frame2("Student Details");
	}
}

class Frame2 implements ActionListener
{
	JFrame GUI2;
	JLabel roll,name,marks,message;
	JButton fetch,submit;
	JTextField roll_no, student_name, student_marks;
	Frame2(String s)
	{
		GUI2 = new JFrame(s);
		roll = new JLabel("Roll:");
		roll_no = new JTextField(20);
		name = new JLabel("Name: ");
		student_name = new JTextField(20);
		student_name.setEditable(false);
		marks = new JLabel("Marks: ");
		student_marks = new JTextField(20);
		fetch = new JButton("Fetch Name");
		fetch.addActionListener(this);
		submit = new JButton("Submit Marks");
		submit.addActionListener(this);
		message = new JLabel();
		
		GUI2.add(roll);
		GUI2.add(roll_no);
		GUI2.add(name);
		GUI2.add(student_name);
		GUI2.add(marks);
		GUI2.add(student_marks);
		GUI2.add(fetch);
		GUI2.add(submit);
		GUI2.add(message);
		GUI2.setLayout(new FlowLayout());
		GUI2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI2.setSize(300,300);
		GUI2.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Fetch Name"))
			fetchNameForRoll();
		else if(ae.getActionCommand().equals("Submit Marks"))
			submitMarks();
	}
	
	private void fetchNameForRoll()
	{
		String roll = roll_no.getText();
		String name = getNameFromFile("details.csv", roll);
		if(name != null)
		{
			student_name.setText(name);
			roll_no.setEditable(false);
		}
		else
		{
			JOptionPane.showMessageDialog(GUI2, "Name not in record");
			//student_name.setEditable(true);
		}
	}
	private String getNameFromFile(String filename, String rollNo)
	{
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String line;
			while((line = br.readLine()) != null)
			{
				String parts[] = line.split(",");
				if(parts.length == 3 && parts[0].trim().equals(rollNo))
				{
					return parts[1].trim();
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(GUI2, "Error reading file : " +e.getMessage());
		}
		return null;
	}
	private void submitMarks()
	{
		String roll = roll_no.getText();
		String marks = getMarksFromFile("details.csv", roll);
		if(Integer.parseInt(marks) <= 0 || marks != null)
		{
			writeMarksInFile("details.csv", roll);
			message.setText("Marks updated");
		}
		else
		{
			JOptionPane.showMessageDialog(GUI2, "Entered marks cannot be changed");
		}
	}
	private String getMarksFromFile(String filename, String rollNo) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(",");
                if (parts.length == 3 && parts[0].trim().equals(rollNo)) {
                    return parts[2].trim();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(GUI2, "Error reading file");
        }
        return null;
    }

    private void writeMarksInFile(String filename, String rollNo) {
        ArrayList<String> lines = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String marks = student_marks.getText();
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(",");
                if (parts.length == 3 && parts[0].trim().equals(rollNo)) {
                    parts[2] = marks;
                }
                lines.add(String.join(",", parts));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(GUI2, "Error reading file");
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (String ln : lines) {
                pw.println(ln);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(GUI2, "Error writing file");
        }
    }
}
