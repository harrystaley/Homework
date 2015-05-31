import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StackGUI extends JPanel {
	   // instantiate the stack and declare other
	   // variables that will be used in the program
	private StackADT<String> myStack = new ArrayStack<String>();
	private String output;
	
	   // declare GUI components to be used
	private JPanel pnlName, pnlComplete;
	private JPanel pnlStringOutput, pnlBottom1;
	private JPanel pnlBottom2;
	private JLabel lblName, lblStringOutput, lblAuthor;
	private JTextField txtStringInput, txtStringOutput;
	private JButton btnReverse, btnClear, btnExit;
	
	public StackGUI()
	{
		   // give our panel a 'BoxLayout' with
		   // appropriate dimensions and color
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(1200, 250));
		setBackground(Color.LIGHT_GRAY);
		
			//-------create labels-------
		lblName = new JLabel("Enter a string:");
		lblName.setFont(new Font ("Helvetica", Font.PLAIN, 16));
		lblName.setForeground(Color.BLACK);
		
		lblStringOutput = new JLabel("Your string in reverse order:");
		lblStringOutput.setFont(new Font ("Helvetica", Font.PLAIN, 16));
		lblStringOutput.setForeground(Color.BLACK);
		
		lblAuthor = new JLabel("This program was written by Harry Staley.");
		lblAuthor.setFont(new Font ("Helvetica", Font.PLAIN, 16));
		lblAuthor.setForeground(Color.BLACK);
		
			//-------create text fields-------
		txtStringInput = new JTextField(70);
		txtStringInput.setFont(new Font ("Helvetica", Font.PLAIN, 16));
		txtStringInput.setForeground(Color.BLACK);
		
		txtStringOutput = new JTextField(70);
		txtStringOutput.setFont(new Font ("Helvetica", Font.PLAIN, 16));
		txtStringOutput.setForeground(Color.BLACK);
		
			//-------create normal buttons-------
		btnReverse = new JButton("Reverse your string");
		btnReverse.setBackground(Color.GREEN);
		btnReverse.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnReverse.setForeground(Color.BLACK);
		
		btnClear = new JButton("Clear");
		btnClear.setBackground(Color.BLUE);
		btnClear.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnClear.setForeground(Color.WHITE);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnExit.setForeground(Color.WHITE);
		
			//-------create panels-------
		pnlName = new JPanel();
		pnlName.add(lblName);
		pnlName.add(txtStringInput);
		
		pnlComplete = new JPanel();
		pnlComplete.add(btnReverse);
		
		pnlStringOutput = new JPanel();
		pnlStringOutput.add(lblStringOutput);
		pnlStringOutput.add(txtStringOutput);
		
		pnlBottom1 = new JPanel();
		pnlBottom1.add(pnlStringOutput);
		pnlBottom1.add(lblAuthor);
		
		pnlBottom2 = new JPanel();
		pnlBottom2.add(btnClear);
		pnlBottom2.add(btnExit);
		
			// create listeners for components
		btnReverse.addActionListener(new CompleteListener());
		btnClear.addActionListener(new ClearListener());
		btnExit.addActionListener(new ExitListener());
		
			// add sub panels to the main panels
		add(pnlName);
		add(pnlComplete);
		add(pnlBottom1);
		add(pnlBottom2);
		
	}   // end constructor StackGUI
	
		//-------listeners-------
	private class CompleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String oneChar, text;
			int i, strLength;
			
			text = txtStringInput.getText();
			
			//validate user input against a null value
			if(text.equals(""))
			{
				JOptionPane.showMessageDialog(null, "You must enter a string!","ERROR",JOptionPane.ERROR_MESSAGE);
				return;
			}//end if
			
			strLength = text.length();
			
			//traverse the entire sentence that was read in and push each char onto the stack
			for (i = 0; i < strLength; i++)
			{
				//is the stack full?
				if (myStack.full())
				{
					JOptionPane.showMessageDialog(null, "Can't push the character " + text.charAt(i) + " onto the stack.", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}//end if statement
				else //there is room for the char to be pushed onto the stack
				{	
					//if the text is not a space add it if not add a asterisk
					if (text.charAt(i) != ' ')
					{
						myStack.push("" + text.charAt(i));
					} //end if
					else
					{
						myStack.push("*");
					} //end else
				}//end else statement
			} //end of loop
			
			output = "";
			
			//pop off all the characters and assemble them backwards
			while (myStack.notEmpty())
			{
				oneChar = myStack.pop();
				output = output + oneChar;
			} //while loop
			
			//place the output text string into our text field for display
			txtStringOutput.setText(output);
			
		}   // end method actionPerformed
	}   // end class CompleteListener
	
	private class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//clear all text fields	
			txtStringInput.setText("");
			txtStringOutput.setText("");
				
		}	// end method actionPerformed
	}	// end class ClearListener
	
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int answer;
			
			answer = JOptionPane.showConfirmDialog(null, "Exit aplication?", "Terminate",JOptionPane.YES_NO_OPTION);
			
			if (answer == JOptionPane.YES_OPTION)
			{
				System.exit(0);	//shut down this program	
			}
			
		}	// end method actionPerformed
	}	// end class ExitListener
	
}   // end class StackGUI

