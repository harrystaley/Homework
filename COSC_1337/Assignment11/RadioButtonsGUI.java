import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonsGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// declare variables/controls to
	// be used in program
private JLabel lblName, lblMajor, lblGrade;
private JLabel lblOutput;
private JTextField txtName, txtMajor, txtGrade;
private JButton btnDone; 
private String output;
private JRadioButton rbtName, rbtMajor, rbtGrade;
private JPanel pnlRadio;


public RadioButtonsGUI()
{
		// define listeners
	ButtonListener buttonWork = new ButtonListener();
	TransactionListener personalInfo = 
					new TransactionListener();
	
		// create a label that will
		// be used for display
	lblOutput = new JLabel("------------");
	
		// create labels and text fields
		// for name, major and grade
	lblName = new JLabel("What is your name?");
	txtName = new JTextField(12);
	
	lblMajor = new JLabel("What is your major?");
	txtMajor = new JTextField(12);
	
	lblGrade = new JLabel("What grade level are you?");
	txtGrade = new JTextField(12);
	
		// create radio buttons for name,
		// major, and grade
	rbtName = new JRadioButton("Name", true);
	rbtMajor = new JRadioButton("Major");
	rbtGrade = new JRadioButton("Grade");


	   // add the three radio buttons to the button
	   // group called 'group'.  NOTE:  'group' is 
	   // not a container, it is used to simply
	   // organize the buttons; we will still have to
	   // add each individual button to a panel
	   // (shown below)
	ButtonGroup group = new ButtonGroup();
	group.add(rbtName);
	group.add(rbtMajor);
	group.add(rbtGrade);

		// create a subpanel for
		// 	the radio buttons
	pnlRadio = new JPanel();
	pnlRadio.setBackground(Color.CYAN);
	pnlRadio.setLayout(new BoxLayout(pnlRadio, BoxLayout.X_AXIS));
	pnlRadio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	
	
	
	   // add radio buttons to this subpanel
	pnlRadio.add(rbtName);
	pnlRadio.add(Box.createRigidArea(new Dimension(5,0)));
	pnlRadio.add(rbtMajor);
	pnlRadio.add(Box.createRigidArea(new Dimension(5,0)));
	pnlRadio.add(rbtGrade);
		// create button for ending input
	btnDone = new JButton("Done");
	
		// associate listeners with 
		// appropriate controls
	btnDone.addActionListener(buttonWork);
	rbtName.addActionListener(personalInfo);
	rbtMajor.addActionListener(personalInfo);
	rbtGrade.addActionListener(personalInfo);

	
		// add all controls to panel
	add(lblName);
	add(txtName);
	add(lblMajor);
	add(txtMajor);
	add(lblGrade);
	add(txtGrade);
	add(pnlRadio);
	add(btnDone);
	add(lblOutput);
	
	
		// set up size and control of panel
    setPreferredSize (new Dimension(300, 150));
    setBackground (Color.YELLOW);
	
}	// end constructor RadioButtonsGUI

private class TransactionListener implements ActionListener
{
	public void actionPerformed (ActionEvent event)
	{
		Object source = event.getSource();
		
		   // selected Name
		if (source == rbtName)
		{
			output = txtName.getText();
		}
		   // selected Major
		else if (source == rbtMajor)
		{
			output = txtMajor.getText();
		}
		   // selected Grade
		else if (source == rbtGrade)
		{
			output = txtGrade.getText();
		}
		   // something else was selected
		else
		{
			System.out.println("Radio button ERROR");
		}  
	}
	// end method actionPerformed
}   // end class TransactionListener


private class ButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
    	  	// display this label!
    	  lblOutput.setText(output);
      }
   }// end class ButtonListener


}	// end class RadioButtonsGUI
